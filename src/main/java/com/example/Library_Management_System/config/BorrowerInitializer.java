package com.example.Library_Management_System.config;

import com.example.Library_Management_System.models.Book;
import com.example.Library_Management_System.models.Borrower;
import com.example.Library_Management_System.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BorrowerInitializer {
    @Bean
    CommandLineRunner borrowerCommandLineRunner(BookRepository bookRepository){
        return arg -> {
            Borrower borrower1 = new Borrower("Ryan", "Ramola");
        };
    }
}
