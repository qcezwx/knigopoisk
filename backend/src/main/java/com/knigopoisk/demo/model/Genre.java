package com.knigopoisk.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@Data
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "genre_id")
    private Long id;
    @NotNull
    @Column(name = "name")
    private String genreName;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<Book>();

    public Genre() {}

    public Genre(@NotNull String genreName) {
        this.genreName = genreName;
    }
}
