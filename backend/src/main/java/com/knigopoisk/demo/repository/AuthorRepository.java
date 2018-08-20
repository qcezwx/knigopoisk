package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Author;
import com.knigopoisk.demo.projection.AuthorProjection;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findById(Long id);

    Author findByFullname(String fullname);

    @Query(value = "select distinct a.author_id as id," +
            " a.fullname as fullname," +
            " a.birth_date as birthDate," +
            " a.death_date as deathDate," +
            " avg(b.rating) over (partition by a.author_id) as rating" +
            " from authors a join books b on a.author_id = b.author_id" +
            " order by rating desc", nativeQuery = true)
    List<AuthorProjection> findAllAuthorsWithRating();
}
