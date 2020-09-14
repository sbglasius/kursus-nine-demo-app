package nine.demo.app

class ActionItem {
    String task
    boolean done
    String description

    static belongsTo = [todo: Todo]

    static constraints = {
        description nullable: true
    }
}
