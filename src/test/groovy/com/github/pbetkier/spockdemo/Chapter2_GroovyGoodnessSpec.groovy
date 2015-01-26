package com.github.pbetkier.spockdemo

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import spock.lang.Specification

/**
 * Exploit Groovy goodness to make your tests concise and readable.
 */
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
        names*.length() == [4, 7, 3]
        names.max { it.length() } == "William"
        names.every { Character.isUpperCase(it.charAt(0)) }
    }

    def "should allow creating JSON representations easily"() {
        given:
        def builder = new JsonBuilder()
        builder {
            person {
                name "Guillaume"
                age 33
            }
        }

        expect:
        builder.toString() == '{"person":{"name":"Guillaume","age":33}}'
    }

    def "should allow reading JSON representations easily"() {
        given:
        def result = new JsonSlurper().parseText('{"person":{"name":"Guillaume","age":33}}')

        expect:
        result.person.name == "Guillaume"
        result.person.age == 33
    }

    def "should allow exploiting groovy-truth boolean coercion in assertions"() {
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