package com.github.pbetkier.spockdemo

import spock.lang.Shared
import spock.lang.Specification


class Chapter4_SetupAndCleanupSpec extends Specification {

    def refreshed = new Object()

    @Shared
    def shared = new Object()

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
        println "    some test called (refreshed: ${refreshed.hashCode()}, shared: ${shared.hashCode()})"

        expect:
        true
    }

    def "some other test"() {
        given:
        println "    some other test called (refreshed: ${refreshed.hashCode()}, shared: ${shared.hashCode()})"

        expect:
        true
    }

}