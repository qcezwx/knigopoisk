package com.knigopoisk.demo.model;

public class NewBook {
    String title;
    String authorName;
    String language;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {

        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getLanguage() {
        return language;
    }

    public String toString() { return "title: " + title + ", author: " + authorName + ", lang: " + language; }
}
