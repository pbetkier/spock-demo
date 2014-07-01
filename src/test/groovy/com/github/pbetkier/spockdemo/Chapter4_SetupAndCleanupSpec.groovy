package com.github.pbetkier.spockdemo

import spock.lang.Shared
import spock.lang.Specification


/**
 * Use simple conventions to execute some code around your tests.
 * Reinitialize your variables with each test or share them between
 * executions. Run the tests and analyze the output.
 */
class Chapter4_SetupAndCleanupSpec extends Specification {

    def refreshed = new Object()

    @Shared
    def shared = new Object()

    def setupSpec() {
        println "setupSpec called (like @BeforeClass)"
    }

    def setup() {
        println "  setup called (like @Before)"
    }

    def cleanup() {
        println "  cleanup called (like @After)"
    }

    def cleanupSpec() {
        println "cleanupSpec called (like @AfterClass)"
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