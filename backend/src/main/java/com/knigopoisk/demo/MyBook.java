package com.knigopoisk.demo;

import java.util.Date;

public class MyBook {
    int id;
    String title;
    String author;
    String language;
    String publisher;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public String getPublisher() {
        return publisher;
    }

    public MyBook(int id, String title, String author, String language, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.publisher = publisher;
    }
}
