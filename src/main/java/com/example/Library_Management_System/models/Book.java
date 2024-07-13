package com.example.Library_Management_System.models;

import jakarta.persistence.*;

@Entity
@Table
public class Book {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    Long id;

    private String title;

    public Book(String title) {
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
}
