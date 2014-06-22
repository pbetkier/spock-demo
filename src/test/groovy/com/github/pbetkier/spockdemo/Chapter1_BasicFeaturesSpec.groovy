package com.github.pbetkier.spockdemo

import spock.lang.Specification


class Chapter1_BasicFeaturesSpec extends Specification {

    def "should allow writing readable, spec-like tests"() {
        given:
        def greeting = "hello world!"

        when:
        def edited = greeting.substring(6)

        then:
        edited == "world!"
    }

    def "should provide shorter form for simple tests"() {
        expect:
        Math.max(1, 3) == 3
    }

}