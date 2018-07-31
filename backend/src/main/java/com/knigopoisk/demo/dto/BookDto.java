package com.knigopoisk.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class BookDto {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String authorFullname;
    private Set<String> genres = new HashSet<String>();
    private Date publicationDate;
    private String language;
    private int rating;
    private float totalValues;

}
