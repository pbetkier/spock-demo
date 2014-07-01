package com.github.pbetkier.spockdemo

import spock.lang.Specification
import spock.lang.Unroll


/**
 * Convenient tests parameterization is spock's killer feature.
 */
class Chapter5_DataDrivenTestsSpec extends Specification {

    def "should allow achieving lightweight tests parameterization"() {
        expect:
        Math.max(a, b) == result

        where:
        a | b | result
        1 | 2 | 2
        2 | 1 | 2
        0 | 0 | 0
    }

    @Unroll
    def "max between #a and #b should be #result"() {
        expect:
        Math.max(a, b) == result

        where:
        a | b | result
        1 | 2 | 2
        2 | 1 | 2
        0 | 0 | 0
    }

    def "should allow for another syntax for tests parameterization"() {
        expect:
        name.size() == size

        where:
        name << ["John", "William", "Sue"]
        size << [4, 7, 3]
    }

    def "... and another one..."() {
        expect:
        name.size() == size

        where:
        [name, size] << [["John", 4], ["William", 7], ["Sue", 3]]
        // [name, size] << sql.rows("select name, size from names")
    }

}