package com.knigopoisk.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "genres")
@Data
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    @SequenceGenerator(name="genre_seq", initialValue=200, allocationSize=1)
    @Column(name = "genre_id")
    private Long id;
    @NotNull
    @Column(name = "name")
    private String genreName;

    public Genre() {
    }

    public Genre(@NotNull String genreName) {
        this.genreName = genreName;
    }
}
