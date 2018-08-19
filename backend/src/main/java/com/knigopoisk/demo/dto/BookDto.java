package com.knigopoisk.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    Long id;
    String title;
    String author;
    float rating;

    public BookDto(Long id, String title, String author, float rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
    }
}
