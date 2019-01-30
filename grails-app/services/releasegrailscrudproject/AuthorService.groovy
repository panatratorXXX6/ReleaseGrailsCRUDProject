package releasegrailscrudproject

import grails.gorm.transactions.Transactional

@Transactional
class AuthorService {

    def findAll(){
        return Author.all
    }

// show amount of all authors
    int amountOfAuthors(){
        List<Author> list = findAll()
        if (list != null) {
            return list.size()
        } else {
            print("No one author is available in our database. Hurry up, create new one !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        }
    }

// show what author is the most old
        Author getTheYoungestAuthor(List<Author> list){
            Collections.sort(list, new Comparator<Author>() {
                @Override
                int compare(Author author1, Author author2) {
                    return author1.getBirthday() <=> author2.getBirthday()
                }
            })
            return list.get(list.size()-1)
    }

// show what author is the most young
    Author getTheOldestAuthor(List<Author> list) {

        Collections.sort(list, new Comparator<Author>() {
            @Override
             int compare(Author author1, Author author2) {
                return author1.getBirthday() <=> author2.getBirthday()
            }
        })
        return list.get(0)
    }

// Method show the current author who has sold more books than another authors in a bundle
//     Author getTheBestSellingAuthor(List<Author> list) {
//
//        int bestPrinting = 0
//        int maxValue = 0
//        Author bestAuthor
//
//        for (author in list) {
//            Set<Book> bookbook = author.books
//
//            for (book in bookbook) {
//                bestPrinting = book.getCount() + bestPrinting
//            }
//            if(bestPrinting > maxValue) {
//                maxValue = bestPrinting
//                bestAuthor = author
//            }
//            bestPrinting=0
//        }
//        return bestAuthor
//    }

// Method show the current author who has sold less books than another authors in a bundle
//     Author getTheLeastSellingAuthor(List<Author> list) {
//
//        int minValue = Integer.MAX_VALUE
//        int printing = 0
//        Author leastAuthor = null
//
//        for (currentAuthor in list) {
//            Set<Book> booksbooks = currentAuthor.books()
//
//            for (book in booksbooks) {
//                printing = book.getCount() + printing
//
//            }
//            if(printing < minValue) {
//                minValue = printing
//                leastAuthor = currentAuthor
//            }
//            printing=0
//        }
//        return leastAuthor
//    }

// The most efficient author (Current author's printing/current author's books)
//     Author getTheMostEfficientAuthor(List<Author> list) {
//
//        int printing = 0
//        Author mostEfficientAuthor = null
//        int koefValue = 0
//        int bestValue = 0
//
//        for (Author a: list) {
//            Set<Book> booksbooks = a.books()
//
//            for(Book b: booksbooks) {
//                printing = b.getCount() + printing
//            }
//
//            try {
//                koefValue = printing / booksbooks.size()
//            }
//            catch (ArithmeticException e) {
//
//            }
//
//            if (koefValue > bestValue) {
//                bestValue = koefValue
//                mostEfficientAuthor = a
//            }
//            printing = 0
//        }
//        return mostEfficientAuthor
//    }

    Author get(Serializable id){
        return authorService.get(id)
    }
}
