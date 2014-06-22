package com.github.pbetkier.spockdemo

import spock.lang.Specification


class Chapter2_GroovyGoodnessSpec extends Specification {

    def "should make tests concise with list literals"() {
        given:
        def symbols = ["alpha", "beta"]

        when:
        symbols.add("gamma")

        then:
        symbols.contains("gamma")
    }

    def "should make tests concise with map literals"() {
        given:
        def mapping = [key: "value"]

        when:
        mapping.remove("key")

        then:
        mapping.isEmpty()
    }

    def "should make asserting on collections easy"() {
        when:
        def names = ["John", "William", "Sue"]

        then:
        names.collect { it.length() } == [4, 7, 3]
        names.max { it.length() } == "William"
        names.every { Character.isUpperCase(it.charAt(0)) }
    }

    def "should allow exploiting groovy-truth boolean coercion"() {
        expect:
        "something"
        !""

        ["something"]
        ![]

        1
        !0

        !null
    }

}