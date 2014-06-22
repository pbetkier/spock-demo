package com.github.pbetkier.spockdemo

import spock.lang.Specification


class Chapter4_SetupAndCleanupSpec extends Specification {

    def setupSpec() {
        println "setupSpec called"
    }

    def setup() {
        println "  setup called"
    }

    def cleanup() {
        println "  cleanup called"
    }

    def cleanupSpec() {
        println "cleanupSpec called"
    }

    def "some test"() {
        given:
        println "    some test called"

        expect:
        true
    }

    def "some other test"() {
        given:
        println "    some other test called"

        expect:
        true
    }

}