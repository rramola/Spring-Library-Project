package com.example.Library_Management_System.controllers;


import com.example.Library_Management_System.Services.AuthorService;
import com.example.Library_Management_System.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAllAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/name/{firstName}/{lastName}")
    public Author getByName(@PathVariable String firstName, @PathVariable String lastName){
        return authorService.getAuthorByName(firstName, lastName);
    }

    @PostMapping("")
    public Author addNewAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Author updateAuthorById(@RequestBody Author author, @PathVariable Integer id){
        return authorService.updateAuthor(author, id);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable Long id) { authorService.deleteAuthor(Long.valueOf(id));}
}
