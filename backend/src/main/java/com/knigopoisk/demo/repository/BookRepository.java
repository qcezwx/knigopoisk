package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b.id, b.title, b.author, b.rating from Book b")
    List<Book> findTop50ByOrderByRatingDesc();

    Book findByTitle(String title);

    Optional<Book> findById(Long id);

    List<Book> findBookByGenresOrderByRatingDesc(Genre genre);

    @Query("select b.title from Book b join b.author a where a.id = ?1")
    List<Object> findBooksByAuthor_Id(Long id);
}
