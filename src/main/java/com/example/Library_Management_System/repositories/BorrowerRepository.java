package com.example.Library_Management_System.repositories;

import com.example.Library_Management_System.models.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
