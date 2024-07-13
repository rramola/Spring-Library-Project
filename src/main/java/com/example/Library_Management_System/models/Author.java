package com.example.Library_Management_System.models;

import jakarta.persistence.*;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    Long id;

    private String firstName;

    private String lastName;

    public Author(String firstName, String lastName) {
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
}
