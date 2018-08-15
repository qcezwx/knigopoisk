package com.knigopoisk.demo.service;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.repository.BookRepository;
import com.knigopoisk.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;

    public List<Book> getTopBooks() {
        List<Book> topBooks = bookRepository.findTop50ByOrderByRatingDesc();

        return topBooks;
    }

    public Book getBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);

        return book;
    }

    public List<Book> getBooksByGenre(String genre) {
        List<Book> booksByGenre = bookRepository.findBookByGenresOrderByRatingDesc(genreRepository.findGenreByGenreName(genre));

        return booksByGenre;
    }
}
