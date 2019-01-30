package releasegrailscrudproject

import grails.gorm.transactions.Transactional

@Transactional
class BookService {

    BookService bookService

    def findAll(){
        Book.all
    }

    def save(Book book){
        bookService.save(book)
    }

}
