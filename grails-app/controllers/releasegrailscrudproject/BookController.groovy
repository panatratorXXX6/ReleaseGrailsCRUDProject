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

// create book
    def create(){

        respond new Book(params)

        Date date = new Date()
        long timeInMilli = date.getTime()
        JSON myString = new JSONObject().put("JSON", ["object":"Book", "name":"Book_name", "action":"Create_button"])
        redisService.hset("book:one", timeInMilli.toString(), myString.toString())
    }

    def save(){
        def book = new Book(params)
        book.save(failOnError: true)
        Date date = new Date()
        long timeInMilli = date.getTime()
        JSON myString = new JSONObject().put("JSON", ["object":"Book", "name":"Book_name", "action":"Save_button"])
        redisService.hset("book:one", timeInMilli.toString(), myString.toString())
        redirect (action: 'index')
    }

// create edit() method in BookService class
    def edit(Long id){
        def book = Book.get(id)
        [bookBook: book]
    }

    def editBook(){
        def book = Book.get(params.id)
        book.properties = params
        book.save(flush: true)
        redirect(action: 'index')
        Date date = new Date()
        long timeInMilli = date.getTime()
        JSON myString = new JSONObject().put("JSON", ["object":"Book", "name":"Book_name", "action":"Edit_button"])
        redisService.hset("book:one", timeInMilli.toString(), myString.toString())
    }

    def delete(Long id){
        if (id == null) {
            print("It's null, nerd !!!!!!!!!!!!!!!!!!!!!!!!!")
        } else {
            Date date = new Date()
            long timeInMilli = date.getTime()
            JSON myString = new JSONObject().put("JSON", ["object":"Book", "name":"Book_name", "action":"Delete_button"])
            redisService.hset("book:one", timeInMilli.toString(), myString.toString())

            Book.get(id).delete(flush: true)
            redirect(action: 'index')
        }
    }

//    def createNewBookInRedis(){
//        table.setName(redisService.qet("tabel:etrewt"))
//        redisService.set()
//    }

}
