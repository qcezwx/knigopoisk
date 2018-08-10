package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findTop50ByOrderByRatingDesc();

    public Book findByTitle(String title);
}
