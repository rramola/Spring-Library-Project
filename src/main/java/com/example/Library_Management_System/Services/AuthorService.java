package com.example.Library_Management_System.Services;

import com.example.Library_Management_System.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.Library_Management_System.repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(Long.valueOf(id));
    }

    public Author updateAuthor(Author author, Long id) {
        if(!authorRepository.existsById(Long.valueOf(id))){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        author.setId(id);
        authorRepository.save(author);
        return author;
    }
}
