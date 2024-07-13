package com.example.Library_Management_System.repositories;

import com.example.Library_Management_System.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query("SELECT a FROM Author a WHERE UPPER(a.firstName) = UPPER(?1) and UPPER(a.lastName) = UPPER(?2)")
    Author getByFirstNameAndLastName(String firstName, String lastName);
}
