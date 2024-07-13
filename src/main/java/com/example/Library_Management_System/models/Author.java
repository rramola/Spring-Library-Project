package com.example.Library_Management_System.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookAuthors")
    private Set<Book> books = new HashSet<>();

    private String firstName;

    private String lastName;

    public Author() {
    }

    public Author (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
