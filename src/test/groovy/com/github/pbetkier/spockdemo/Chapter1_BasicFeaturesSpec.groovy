package com.github.pbetkier.spockdemo

import spock.lang.Specification


/**
 * A simple specification class showing spock basic features.
 */
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

    def "should allow asserting that exception was thrown"() {
        when:
        Integer.valueOf("not a number")

        then:
        thrown NumberFormatException
    }

}