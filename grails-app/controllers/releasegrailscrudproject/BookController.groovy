package releasegrailscrudproject

import grails.converters.JSON
import grails.plugins.redis.RedisService
import org.grails.web.json.JSONObject

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

        Date date = new Date()
        long timeInMilli = date.getTime()
        JSONObject myObject = new JSONObject()
        JSONObject myString = new JSONObject().put("JSON", ["object":"Book", "name":"Name", "action":"Edit"])
        redisService.hset("book:one", timeInMilli.toString(), myString.toString())
    }

// after creating - save book
    def save(){
        def book = new Book(params)
        book.save(failOnError: true)
        Date date = new Date()
        long timeInMilli = date.getTime()
        JSON myString = new JSONObject().put("JSON", ["object":"Book", "name":book.name.toString(), "action":"Create"])
        redisService.hset("book:one", timeInMilli.toString(), myString.toString())
        redirect (action: 'index')
    }

// find book to edit
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
        Date date = new Date()
        long timeInMilli = date.getTime()
        JSON myString = new JSONObject().put("JSON", ["object":"Book", "name":book.name.toString(), "action":"Edit"])
        redisService.hset("book:one", timeInMilli.toString(), myString.toString())
    }

// delete current book
    def delete(Long id){
        if (id == null) {
            print("It's null, nerd !!!!!!!!!!!!!!!!!!!!!!!!!")
        } else {
            def book = Book.get(params.id)
            Date date = new Date()
            long timeInMilli = date.getTime()
            JSON myString = new JSONObject().put("JSON", ["object":"Book", "name":book.name.toString(), "action":"Delete"])
            redisService.hset("book:one", timeInMilli.toString(), myString.toString())
            Book.get(id).delete(flush: true)
            redirect(action: 'index')
        }
    }
}
