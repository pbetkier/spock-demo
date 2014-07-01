package com.github.pbetkier.spockdemo

import spock.lang.Specification


/**
 * Nice DSL for stubbing your collaborators with minimum effort.
 */
class Chapter6_StubbingSpec extends Specification {

    def "should allow stubbing easily"() {
        given:
        def stubbed = Stub(DataProvider)

        expect:
        stubbed instanceof DataProvider
    }

    def "stubbed methods should return nice default values for collections and primitive wrappers"() {
        given:
        def stubbed = Stub(DataProvider)

        expect:
        stubbed.size() == 0
        stubbed.data() == []
    }

    def "stubbed methods should return non-proxied instances if returned type has a default constructor"() {
        given:
        def stubbed = Stub(DataProvider)

        expect:
        stubbed.updatedAt().class == Date
    }

    def "stubbed methods should return stubs if returned type doesn't have a default constructor (requires cglib)"() {
        given:
        def stubbed = Stub(DataProvider)

        expect:
        stubbed.responsible().class != Person
    }

    def "should allow configuring returned value"() {
        given:
        def stubbed = Stub(DataProvider)
        stubbed.data() >> ["A", "B"]

        expect:
        stubbed.data() == ["A", "B"]
    }

    def "should allow configuring responses at creation time"() {
        given:
        def stubbed = Stub(DataProvider) {
            data() >> ["A", "B"]
            size() >> 1
        }

        expect:
        stubbed.data() == ["A", "B"]
        stubbed.size() == 1
    }

    def "should allow configuring returned value for specific arguments"() {
        given:
        def stubbed = Stub(DataProvider)
        stubbed.pagedData(0, 10) >> ["A", "B"]

        expect:
        stubbed.pagedData(0, 10) == ["A", "B"]
        stubbed.pagedData(0, 2) == []
    }

    def "should allow configuring returned value not caring about an argument value"() {
        given:
        def stubbed = Stub(DataProvider)
        stubbed.pagedData(0, _ as Integer) >> ["A", "B"]

        expect:
        stubbed.pagedData(0, 10) == ["A", "B"]
        stubbed.pagedData(0, 2) == ["A", "B"]
    }

    def "should allow configuring subsequent returned values"() {
        given:
        def stubbed = Stub(DataProvider)
        stubbed.size() >>> [1, 2]

        expect:
        stubbed.size() == 1
        stubbed.size() == 2
        stubbed.size() == 2
    }

    def "should allow configuring response action"() {
        given:
        def stubbed = Stub(DataProvider)
        stubbed.size() >> { throw new UnsupportedOperationException() }

        when:
        stubbed.size()

        then:
        thrown UnsupportedOperationException
    }

}
