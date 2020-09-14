package nine.demo.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TodoController {

    TodoDataService todoDataService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
//        respons Todo.list(params),  model: [todoCount: Todo.count()]
        respond todoDataService.list(params), model:[todoCount: todoDataService.count()]
    }

    def show(Long id) {
        respond todoDataService.get(id)
    }

    def create() {
        Todo todo = new Todo(params)
        respond todo
    }

    def save(Todo todo) {
        if (todo == null) {
            notFound()
            return
        }

        try {
            todoDataService.save(todo)
        } catch (ValidationException e) {
            respond todo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'todo.label', default: 'Todo'), todo.id])
                redirect todo
            }
            '*' { respond todo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond todoDataService.get(id)
    }

    def update(Todo todo) {
        if (todo == null) {
            notFound()
            return
        }

        try {
            todoDataService.save(todo)
        } catch (ValidationException e) {
            respond todo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'todo.label', default: 'Todo'), todo.id])
                redirect todo
            }
            '*'{ respond todo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        todoDataService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'todo.label', default: 'Todo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
