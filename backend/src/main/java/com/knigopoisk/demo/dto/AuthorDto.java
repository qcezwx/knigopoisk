package com.knigopoisk.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorDto {
    Long id;
    String fullname;
    Date birthDate;
    Date dearthDate;
    float rating;

    public AuthorDto() {
    }

    public AuthorDto(Long id, String fullname, Date birthDate, Date dearthDate, float rating) {
        this.id = id;
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.dearthDate = dearthDate;
        this.rating = rating;
    }
}
