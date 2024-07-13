package com.example.Library_Management_System.config;
import com.example.Library_Management_System.models.Book;
import com.example.Library_Management_System.repositories.AuthorRepository;
import com.example.Library_Management_System.models.Author;
import com.example.Library_Management_System.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorInitializer {

    @Bean
    CommandLineRunner authorCommandLineRunner(AuthorRepository authorRepository) {
        return arg -> {
            Author author1 = new Author("Ryan", "Ramola");
            authorRepository.save(author1);
        };
    }
}
