package com.example.Library_Management_System.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Borrower {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "borrower")
    private Set<Book> books = new HashSet<>();

    private String firstName;

    private String lastName;

    public Borrower() {
    }

    public Borrower(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

}
