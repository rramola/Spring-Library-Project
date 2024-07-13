package com.example.Library_Management_System.controllers;
import com.example.Library_Management_System.Services.AuthorService;

import com.example.Library_Management_System.Services.BookService;
import com.example.Library_Management_System.Services.BorrowerService;
import com.example.Library_Management_System.models.Author;
import com.example.Library_Management_System.models.Book;
import com.example.Library_Management_System.models.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    BorrowerService borrowerService;


    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/title/{title}")
    public Book getBookByTitle(@PathVariable String title){
        return bookService.getByTitle(title);
    }

    @PostMapping("")
    public Book addNewBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book updateBookById(@RequestBody Book book, @PathVariable Integer id) {
        return bookService.updateBook(book, id);
    }

    @PutMapping("/{bookId}/authors/{authorId}")
    Book addNewAuthorToBook(
        @PathVariable Long bookId,
        @PathVariable Long authorId
    ) {
        Book book = bookService.getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        book.addAuthor(author);
        return bookService.addBook(book);
    }

    @PutMapping("/{bookId}/borrowers/{borrowerId}")
    Book checkOutBook(
            @PathVariable Long bookId,
            @PathVariable Long borrowerId
    ) {
        Book book = bookService.getBook(bookId);
        Borrower borrower = (Borrower) borrowerService.getBorrower(borrowerId);
        book.checkout(borrower);
        return bookService.addBook(book);
    }


    @DeleteMapping("id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBook(Long.valueOf(id));
    }
}
