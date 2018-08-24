package com.knigopoisk.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "authors")
@Data

public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @SequenceGenerator(name="author_seq", initialValue=200, allocationSize=1)
    @Column(name = "author_id", nullable = false)
    private Long id;
    @NotNull
    private String fullname;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "death_date")
    private Date deathDate;

    @JsonIgnore
    @OneToMany(mappedBy = "author", targetEntity = Book.class, cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author() {
    }

    public Author(@NotNull String fullname, Date birthDate, Date deathDate) {
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }
}
