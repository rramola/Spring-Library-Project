package com.example.Library_Management_System.repositories;

import com.example.Library_Management_System.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query("SELECT b FROM Book b WHERE REPLACE(UPPER(b.title), ' ', '') = UPPER(:title)")
    Book getByTitle(@Param("title") String title);
}
