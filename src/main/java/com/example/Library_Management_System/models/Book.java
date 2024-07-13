package com.example.Library_Management_System.models;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Book {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    Long id;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> bookAuthors = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id")
    private Borrower borrower;


    private String title;

    public Book(){

    }
    public Book(String title){
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id  = id;
    }

    public Set<Author> getBookAuthors() {
        return bookAuthors;
    }

    public void addAuthor(Author author) {
        bookAuthors.add(author);
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void checkout(Borrower borrower) {
        this.borrower = borrower;
    }
}
