package nine.demo.app

import grails.converters.JSON
import nine.dawa.DawaService

class DawaController {

    DawaService dawaService

    def index() {
        render dawaService.regioner as JSON
    }
}
