package com.example.bookshopSystem.repositories;

import com.example.bookshopSystem.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("SELECT a FROM Author a WHERE a.books.size > 0 ORDER BY a.books.size DESC")
    List<Author> findAllOrderedByBooksSize();

    Author findAllByFirstNameAndLastName(String firstName, String lastName);
}
