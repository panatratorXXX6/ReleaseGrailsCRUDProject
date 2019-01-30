package releasegrailscrudproject

import grails.converters.JSON

class AuthorController {

    AuthorService authorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]

    def index() {
         List<Author> list = authorService.findAll()
        [amountOfAuthors:authorService.amountOfAuthors(),
            youngestAuthor:authorService.getTheYoungestAuthor(list),
                oldestAuthor:authorService.getTheOldestAuthor(list),
                    allAuthors:list,
                        findAuthorById: authorService.findAll()
//                    bestSellingAuthor:authorService.getTheBestSellingAuthor(list),
//                        leastSellingAuthor:authorService.getTheLeastSellingAuthor(list),
//                            efficientAuthor:authorService.getTheMostEfficientAuthor(list)
//
        ]
    }

// creating author
    def create(){

    }

// saving new author
    def save(){
        def author = new Author(params)
        author.save(failOnError: true)
        redirect (action: 'index')
    }

// find author to edit
    def edit(Long id) {
        def author = Author.get(id)
        [authorAuthor: author]
    }

// edit current author
    def editAuthor(){
        def author = Author.get(params.id)
        author.properties = params
        author.save(flush: true)
        redirect (action: 'index')
    }

// deleting author
    def delete(Long id) {
        if (id == null) {
            print("It's null, geek !!!!!!!!!!!!!!!!!!!!!!!!!")
        } else {
            Author.get(id).delete(flush: true)
            redirect(action: 'index')
        }
    }

// ajax call for render fields of current author
    def ajax(){
        def authorJSON = Author.get(request.JSON.id)
        def result = [authorKey: authorJSON]
            render result as JSON
    }
}
