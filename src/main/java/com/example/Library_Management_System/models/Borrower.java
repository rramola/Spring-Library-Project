package com.example.Library_Management_System.models;

import jakarta.persistence.*;

@Entity
@Table
public class Borrower {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    Long id;


    private String firstName;

    private String lastName;

    public Borrower(String firstName, String lastName) {
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
}
