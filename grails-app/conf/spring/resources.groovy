import grails.util.Environment
import nine.demo.app.MockMyService

// Place your Spring DSL code here
beans = {
    if (Environment.current == Environment.DEVELOPMENT) {
        myService(MockMyService) {
            dataSource = ref('dataSource')
        }
    }


}
