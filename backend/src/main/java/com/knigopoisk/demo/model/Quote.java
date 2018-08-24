package com.knigopoisk.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quotes")
@Data
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quote_seq")
    @SequenceGenerator(name="quote_seq", initialValue=200, allocationSize=1)
    @Column(name = "quote_id")
    private Long id;
    @NotNull
    @Column(name = "book_id")
    private int bookId;
    @NotNull
    @Column(name = "author_id")
    private int authorId;
    @NotNull
    private String quote;
}
