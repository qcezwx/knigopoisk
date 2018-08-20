package com.knigopoisk.demo.projection;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AuthorDto {
    Long id;
    String fullname;
    Date birthDate;
    Date deathDate;
    Float rating;
    List<String> titles;

    public AuthorDto() {
    }

    public AuthorDto(Long id, String fullname, Date birthDate, Date deathDate, Float rating) {
        this.id = id;
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.rating = rating;
    }

    public static AuthorDto fromProjection(AuthorProjection authorProjection) {
        AuthorDto authorDto = new AuthorDto(authorProjection.getId(),
                authorProjection.getFullname(),
                authorProjection.getBirthDate(),
                authorProjection.getDeathDate(),
                authorProjection.getRating());

        return authorDto;
    }

}
