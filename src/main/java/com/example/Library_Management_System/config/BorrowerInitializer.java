package com.example.Library_Management_System.config;

import com.example.Library_Management_System.models.Book;
import com.example.Library_Management_System.models.Borrower;
import com.example.Library_Management_System.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.Library_Management_System.repositories.BorrowerRepository;

@Configuration
public class BorrowerInitializer {
    @Bean
    CommandLineRunner borrowerCommandLineRunner(BorrowerRepository borrowerRepository){
        return arg -> {
            Borrower borrower1 = new Borrower("Ryan", "Ramola");
            borrowerRepository.save(borrower1);
        };
    }
}
