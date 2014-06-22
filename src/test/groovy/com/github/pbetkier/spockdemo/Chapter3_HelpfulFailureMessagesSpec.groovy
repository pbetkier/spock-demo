package com.github.pbetkier.spockdemo

import spock.lang.Ignore
import spock.lang.Specification


class Chapter3_HelpfulFailureMessagesSpec extends Specification {

    @Ignore
    def "should provide clear failure message on basic assertion"() {
        expect:
        1 == 2
    }

    @Ignore("unignore to see how it fails")
    def "should provide helpful failure message on string assertion"() {
        expect:
        "hello everyone!" == "hello anyone?"
    }

    @Ignore
    def "should provide output of every call in the invocation chain"() {
        given:
        def event = [eventId: 123, meta: [timestamp: 234, source: ["example.com"]]]
        def key = "timestamp"

        expect:
        event.meta.get(key) == 999
    }
}