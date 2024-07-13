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
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book, Long id) {
        if(!bookRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found");
        }
        book.setId(id);
        addBook(book);
        return book;
    }
}
