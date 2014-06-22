package com.github.pbetkier.spockdemo

import spock.lang.Specification


class Chapter2_GroovyGoodnessSpec extends Specification {

    def "should make tests concise with groovy list literals"() {
        given:
        def symbols = ["alpha", "beta"]

        when:
        symbols.add("gamma")

        then:
        symbols == ["alpha", "beta", "gamma"]
    }

    def "should make tests concise with groovy map literals"() {
        given:
        def mapping = [key: "value"]

        when:
        mapping.remove("key")

        then:
        mapping.isEmpty()
    }

}