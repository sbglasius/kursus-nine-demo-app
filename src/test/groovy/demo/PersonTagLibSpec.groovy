package demo

import grails.testing.web.taglib.TagLibUnitTest
import nine.demo.app.Person
import spock.lang.Specification

class PersonTagLibSpec extends Specification implements TagLibUnitTest<PersonTagLib> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given:
            Person p = new Person(name: "Søren")
        expect:
            "Du hedder S&oslash;ren" == applyTemplate('<p:show person="${person}"/>', [person: p])

    }
}
