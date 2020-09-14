package nine.demo.app

import grails.converters.JSON
import grails.converters.XML
import grails.validation.Validateable

class MyController {

    IMyService myService

    def index(Person person) {
        println params.toString()
        println (params.number.getClass().name)
        println person.errors
//        respond(person)
        respond(myService.findMyTodoList(person))
    }
}

class Person implements Validateable {
    String name
    Integer age
    Date dob
    Category category
    static constraints = {
        age nullable: true
        dob nullable: true
    }
}
