package releasegrailscrudproject

import grails.gorm.transactions.Transactional
import grails.plugins.redis.RedisService
import redis.clients.util.RedisOutputStream

import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional
class BookService {

    BookService bookService
    RedisService redisService

    def findAll(){
        Book.all
    }

    def save(Book book){
        bookService.save(book)
    }

    def addRecordInRedisDB(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
        Date date = new Date()
        String strDate = dateFormat.format(date)
        return strDate
    }

}
