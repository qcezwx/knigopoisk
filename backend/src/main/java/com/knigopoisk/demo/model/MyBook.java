package com.knigopoisk.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
@Data
public class MyBook extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @Column(name = "lang")
    private String language;
    private String publisher;

}
