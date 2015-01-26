package com.github.pbetkier.spockdemo

import spock.lang.Specification

/**
 * Nice, yet powerful DSL for mocking your collaborators.
 */
class Chapter7_MockingSpec extends Specification {

    def "should allow verifying a simple interaction"() {
        given:
        def mocked = Mock(EmailService)
        def person = new Person("Bob")

        when:
        mocked.send(person, "Hello!")

        then:
        1 * mocked.send(person, "Hello!")
        0 * mocked.send(person, "not executed")
    }

    def "only interactions within the 'when' block should be considered"() {
        given:
        def mocked = Mock(EmailService)
        def person = new Person("Bob")
        mocked.send(person, "Hello!")

        when:
        mocked.send(person, "Hello!")

        then:
        1 * mocked.send(person, "Hello!")
    }

    def "should allow verifying an interaction with argument constraints"() {
        given:
        def mocked = Mock(EmailService)
        def person = new Person("Bob")

        when:
        mocked.send(person, "Hello!")
        mocked.send(person, "not a bad message")
        mocked.send(person, "# message")
        mocked.send(person, "whatever")

        then:
        1 * mocked.send(_ as Person, "Hello!")
        1 * mocked.send(_, !"bad message")
        1 * mocked.send(!null, { it.startsWith("#") })
        1 * mocked.send(*_)  // don't care
    }

    def "should allow verifying interactions in an extreme way (you shouldn't usually need this)"() {
        given:
        def mocked = Mock(EmailService)

        when:
        1 + 2

        then:
        0 * _  // zero interactions on any mock
        0 * mocked._  // zero interactions on 'mocked' object
        _ * _._(*_)  // going extreme
    }

    def "should allow imposing the order of invocations"() {
        given:
        def mocked = Mock(EmailService)
        def person = new Person("Bob")

        when:
        mocked.send(person, "Hello!")
        mocked.send(person, "Bye!")

        then:
        1 * mocked.send(person, "Hello!")

        then:
        1 * mocked.send(person, "Bye!")
    }

    def "should allow mixing mocking and stubbing (you shouldn't usually need this)"() {
        given:
        def mocked = Mock(DataProvider)

        when:
        def data = mocked.pagedData(0, 5)

        then:
        data == ["A", "B"]
        1 * mocked.pagedData(0, 5) >> ["A", "B"]
    }
}
