package nine.demo.app

import grails.gorm.services.Service

@Service(Todo)
interface TodoDataService {

    Todo get(Serializable id)

    Todo findByCategory(Category category)

    List<Todo> findAllByCategory(Category category, Map params)

    List<Todo> findAllByNameIlike(String name, Map params)

    List<Todo> list(Map args)

    Long count()

    void delete(Serializable id)

    Todo save(Todo todo)

}
