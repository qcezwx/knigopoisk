package com.knigopoisk.demo.service;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.projection.BookProjection;
import com.knigopoisk.demo.repository.BookRepository;
import com.knigopoisk.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;

    public List<BookProjection> getTopBooks() {
        List<BookProjection> topBooks = bookRepository.findAllBooks(new Sort(Sort.Direction.DESC, "rating")).subList(0,49);

        return topBooks;
    }

    public Optional<Book> getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        return book;
    }

    public List<Book> getBooksByGenre(String genre) {
        List<Book> booksByGenre = bookRepository.findBookByGenresOrderByRatingDesc(genreRepository.findGenreByGenreName(genre));

        return booksByGenre;
    }
}
