package com.knigopoisk.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "author_sequence")
    @Column(name = "author_id", nullable = false)
    private Long id;
    @NotNull
    private String fullname;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "death_date")
    private Date deathDate;

    @OneToMany(mappedBy = "author", targetEntity = Book.class, cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author(){}

    public Author(@NotNull String fullname, Date birthDate, Date deathDate) {
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }
}
