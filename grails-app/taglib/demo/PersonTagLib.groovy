package demo

import nine.demo.app.Person

class PersonTagLib {
    static defaultEncodeAs = [taglib:'html']
    static namespace = "p"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def show = { attrs, body ->
        Person person = attrs.person

        if(person?.name) {
            out << "Du hedder $person.name"

        } else {
            out << "Jeg ved ikke hvad du hedder"
        }

        out << body.call()

    }
}
