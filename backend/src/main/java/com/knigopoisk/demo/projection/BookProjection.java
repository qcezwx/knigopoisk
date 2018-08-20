package com.knigopoisk.demo.projection;

import com.knigopoisk.demo.model.Author;

public interface BookProjection {
    Long getId();

    String getTitle();

    Author getAuthor();

    Float getRating();
}
