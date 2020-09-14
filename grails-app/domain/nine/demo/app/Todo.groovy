package nine.demo.app

class Todo {
    String name
    Category category
    Date due
    String description

    static hasMany = [items: ActionItem]

    static constraints = {
        name maxSize: 100
        category nullable: true
        due nullable: true, validator: { val, object ->
            def today = new Date().clearTime()
            if(val?.before(today)) {
                return 'beforeToday'
            }
        }
        description maxSize: Integer.MAX_VALUE
    }

    static mapping = {
        table name: 'TODOS'
        description sqlType: 'TEXT'
    }
}
