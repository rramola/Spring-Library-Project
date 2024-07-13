package com.example.Library_Management_System.controllers;

import com.example.Library_Management_System.Services.BookService;
import com.example.Library_Management_System.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @PostMapping("")
    public Book addNewBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book updateBookById(@RequestBody Book book, @PathVariable Long id){
        return bookService.updateBook(book, id);
    }

    @DeleteMapping("id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBook(Long.valueOf(id));
    }
}
