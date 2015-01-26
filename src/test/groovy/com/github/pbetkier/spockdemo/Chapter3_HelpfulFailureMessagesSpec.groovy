package com.github.pbetkier.spockdemo

import spock.lang.Ignore
import spock.lang.Specification

/**
 * Spock offers very helpful failure messages. Unignore the spec and
 * investigate the failures yourself.
 */
@Ignore("Unignore to see them fail")
class Chapter3_HelpfulFailureMessagesSpec extends Specification {

    def "should provide clear failure message on basic assertion"() {
        given:
        def x = 1

        expect:
        x == 2
    }

    def "should provide helpful failure message on string assertion"() {
        expect:
        "hello everyone!" == "hello anyone?"
    }

    def "should provide output of every call in the invocation chain"() {
        given:
        def event = [eventId: 123, meta: [timestamp: 234, source: ["example.com"]]]
        def key = "timestamp"

        expect:
        event.meta.get(key) == 999
    }
}