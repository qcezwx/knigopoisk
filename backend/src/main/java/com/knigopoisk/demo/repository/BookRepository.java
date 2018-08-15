package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findTop50ByOrderByRatingDesc();

    Book findByTitle(String title);

    Optional<Book> findById(Long id);

    List<Book> findBookByGenresOrderByRatingDesc(Genre genre);
}
