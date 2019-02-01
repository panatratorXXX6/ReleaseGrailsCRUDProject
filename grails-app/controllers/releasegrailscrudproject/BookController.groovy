package releasegrailscrudproject

import grails.plugins.redis.RedisService

class BookController {

    BookService bookService
    RedisService redisService

    def index() {

        List<Author> list = bookService.findAll()
        [allBooks: list,
         findBookById: bookService.findAll(),
         booky: Book.list()
        ]
    }

// create new book
    def create(){
        respond new Book(params)
        String strDate = bookService.getDateFormat()
            String myString = "New book was Created"
        redisService.hset("book:one", strDate.toString(), myString.toString())
    }

// after creating - save book
    def save(){
        def book = new Book(params)
        book.save(failOnError: true)
        String strDate = bookService.getDateFormat()
        String myString = "Book with name " + book.name + " was Saved"
        redisService.hset("book:one", strDate.toString(), myString.toString())
        redirect (action: 'index')
    }

// edit found book
    def edit(Long id){
        def book = Book.get(id)
        [bookBook: book]
    }

// edit current book
    def editBook(){
        def book = Book.get(params.id)
        book.properties = params
        book.save(flush: true)
        redirect(action: 'index')
        String strDate = bookService.getDateFormat()
        String myString = "Book with name " + book.name + " was Edited"
        redisService.hset("book:one", strDate.toString(), myString.toString())
    }

// delete current book
    def delete(Long id){
        if (id == null) {
            redirect(action: create())
        } else {
            def book = Book.get(params.id)
            String strDate = bookService.getDateFormat()
            String myString = "Book with name " + book.name + " was Deleted"
            redisService.hset("book:one", strDate.toString(), myString.toString())
            Book.get(id).delete(flush: true)
            redirect(action: 'index')
        }
    }
}
