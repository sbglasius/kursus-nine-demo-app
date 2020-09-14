package nine.demo.app

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@Transactional
class MyService implements IMyService {

    TodoDataService todoDataService

    @ReadOnly
    List<Todo> findMyTodoList(Person person) {
        todoDataService.findAllByCategory(person.category, [:])

    }
}
