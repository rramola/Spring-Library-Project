package com.example.Library_Management_System.Services;

import com.example.Library_Management_System.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.Library_Management_System.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        if(!bookRepository.existsById(Long.valueOf(id))){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found");
        }bookRepository.deleteById(id);
    }

    public Book updateBook(Book book, Integer id) {
        if(!bookRepository.existsById(Long.valueOf(id))){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found");
        }
        book.setId(Long.valueOf(id));
        addBook(book);
        return book;
    }

    public Book getBook(Long id) {

        if(!bookRepository.existsById(Long.valueOf(id))){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found");
        }
        return bookRepository.findById(id).get();
    }

    public Book getByTitle(String title) {
        var bookCheck = bookRepository.getByTitle(title);
        if (bookCheck == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found");
        }
        return bookCheck;
    }

}
