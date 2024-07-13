package com.example.Library_Management_System.repositories;

import com.example.Library_Management_System.models.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    @Query("SELECT b FROM Borrower b WHERE UPPER(b.firstName) = UPPER(?1) and UPPER(b.lastName) = UPPER(?2)")
    Borrower findBorrowerByFirstNameAndLastName(String firstName, String lastName);
}
