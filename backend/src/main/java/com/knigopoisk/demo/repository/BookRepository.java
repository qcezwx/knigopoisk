package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.model.Genre;
import com.knigopoisk.demo.projection.BookProjection;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b.id as id, b.title as title, b.author as author, b.rating as rating from Book b")
    List<BookProjection> findAllBooks(Sort sort);

    Optional<Book> findById(Long id);

    List<Book> findBookByGenresOrderByRatingDesc(Genre genre);

    @Query("select b.title as title from Book b join b.author a where a.id = ?1")
    List<String> findBooksByAuthor_Id(Long id);
}
