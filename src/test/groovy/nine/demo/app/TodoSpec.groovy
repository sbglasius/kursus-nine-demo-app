package nine.demo.app

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TodoSpec extends Specification implements DomainUnitTest<Todo> {

    def setup() {
    }

    def cleanup() {
    }

    void "test due validator"() {
        given:
            def todo = new Todo(due: new Date() - 1)
        when:
            todo.validate()
        then:
            todo.hasErrors()
        and:
            todo.errors.getFieldError('due').code == 'beforeToday'


    }
    void "test due validator uden fejl"() {
        given:
            def todo = new Todo(due: new Date() + 1)
        when:
            todo.validate(['due'])
        then:
            !todo.hasErrors()
    }
}
