package com.knigopoisk.demo.projection;

import java.util.Date;

public interface AuthorProjection {
    Long getId();

    String getFullname();

    Date getBirthDate();

    Date getDeathDate();

    Float getRating();
}

