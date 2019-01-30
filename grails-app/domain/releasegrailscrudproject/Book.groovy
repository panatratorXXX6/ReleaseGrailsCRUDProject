package releasegrailscrudproject

class Book {

    static belongsTo = Author
    static hasMany = [authors:Author]

    String name
    String isbn
    Integer age
    Date publishDate
    Integer count

    static mapping = {
        authors cascade: 'none'
    }

    static constraints = {
    }
}
