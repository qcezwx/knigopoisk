package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findById(Long id);

    //@Query("select a.id, a.fullname, a.birthDate, a.deathDate, b.rating from Author a join a.books b")
    @Query(value = "select distinct a.author_id, a.fullname, a.birth_date, a.death_date, avg(b.rating) over (partition by a.author_id) from authors a join books b on a.author_id = b.author_id", nativeQuery = true)
    List<Object[]> findAllAuthorsWithRating();
}
