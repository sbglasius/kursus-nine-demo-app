package nine.demo.app

import javax.sql.DataSource

class MockMyService implements IMyService{

    DataSource dataSource

    @Override
    List<Todo> findMyTodoList(Person person) {
        return [new Todo(name: 'Mock')]
    }
}
