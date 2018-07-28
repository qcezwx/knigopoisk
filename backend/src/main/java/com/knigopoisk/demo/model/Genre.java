package com.knigopoisk.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "genre_id")
    private Long id;
    @NotNull
    @Column(name = "name")
    private String genreName;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<Book>();

    public Genre(@NotNull String genreName) {
        this.genreName = genreName;
    }
}
