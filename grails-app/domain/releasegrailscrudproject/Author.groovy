package releasegrailscrudproject

class Author {

    static hasMany = [books:Book]

    String name
    Date birthday
    String address
    String description

    static mapping = {
        books cascade: 'none'
    }

    static constraints = {
    }
}
