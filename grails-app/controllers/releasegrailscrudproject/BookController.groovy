package releasegrailscrudproject

import grails.plugins.redis.RedisService
import java.text.DateFormat
import java.text.SimpleDateFormat

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
        Date date = new Date()
        String strDate = dateFormat.format(date)
        //JSONObject myString = new JSONObject().put("Book", ["object":"Book", "name":"Name", "action":"Create"])
        String myString =
        redisService.hset("book:one", strDate.toString(), myString.toString())
    }

// after creating - save book
    def save(){
        def book = new Book(params)
        book.save(failOnError: true)
        String strDate = bookService.addRecordInRedisDB()
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
        Date date = new Date()
        String strDate = dateFormat.format(date)
        //JSON myString = new JSONObject().put("Book", ["object":"Book", "name":book.name.toString(), "action":"Edit"])
        String myString = "Book with name " + book.name + " was Edited"
        redisService.hset("book:one", strDate.toString(), myString.toString())
    }

// delete current book
    def delete(Long id){
        if (id == null) {
            print("It's null, nerd !")
        } else {
            def book = Book.get(params.id)
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
            Date date = new Date()
            String strDate = dateFormat.format(date)
            //JSON myString = new JSONObject().put("Book", ["object":"Book", "name":book.name.toString(), "action":"Delete"])
            String myString = "Book with name " + book.name + " was Deleted"
            redisService.hset("book:one", strDate.toString(), myString.toString())
            Book.get(id).delete(flush: true)
            redirect(action: 'index')
        }
    }
}
