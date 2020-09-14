package nine.demo.app

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current in [Environment.DEVELOPMENT, Environment.TEST]) {

            new Todo(name: 'Learn Grails', category: Category.CODE, due: new Date() + 10, description: "Learn the awesomeness of Grails", items: [new ActionItem(task: 'first'), new ActionItem(task: 'second')]
            ).save(failOnError: true)
            new Todo(name: 'Code at ERST', category: Category.CODE, description: 'Be awesome').save(failOnError: true)
            new Todo(name: 'Learn to build ERST', category: Category.CI, description: 'On Jenkins').save(failOnError: true)
        }

    }
    def destroy = {
    }
}
