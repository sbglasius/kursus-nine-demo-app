package nine.demo.app

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class MyServiceSpec extends Specification implements ServiceUnitTest<MyService>, DataTest {

    def setup() {
        service.todoDataService = Mock(TodoDataService)
    }

    void "test something"() {
        when:
            def result = service.findMyTodoList(new Person(name: 'Kryf', category: Category.CODE))
        then:
            1 * service.todoDataService.findAllByCategory(Category.CODE, [:]) >> []

        and:
            result.size() == 0
    }
}
