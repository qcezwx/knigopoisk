package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findTop50ByOrderByRatingDesc();

    Book findByTitle(String title);

    List<Book> findBookByGenresOrderByRatingDesc(Genre genre);
}
