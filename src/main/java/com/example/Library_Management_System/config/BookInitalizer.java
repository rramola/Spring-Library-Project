package com.example.Library_Management_System.config;

import com.example.Library_Management_System.models.Book;
import com.example.Library_Management_System.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookInitalizer {

    @Bean
    CommandLineRunner bookCommandLineRunner(BookRepository bookRepository){
        return arg -> {
            Book book1 = new Book("Test Book");
            bookRepository.save(book1);
        };
    }
}
