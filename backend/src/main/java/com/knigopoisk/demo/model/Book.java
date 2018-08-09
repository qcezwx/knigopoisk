package com.knigopoisk.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Data

public class Book extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "book_id")
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_genre",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private Set<Genre> genres = new HashSet<Genre>();
    @Column(name = "publication_date")
    private Date publicationDate;
    @Column(name = "lang")
    private String language;
    private float rating;
    @Column(name = "total_values")
    private int totalValues;

    public Book() {
    }

    public Book(@NotNull String title, @NotNull Author author, Set<Genre> genres, Date publicationDate, String language, float rating, int totalValues) {
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.publicationDate = publicationDate;
        this.language = language;
        this.rating = rating;
        this.totalValues = totalValues;
    }
}
