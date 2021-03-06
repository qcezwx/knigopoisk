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
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(GenreRepository genreRepository, BookRepository bookRepository) {
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    public List<BookProjection> findTopBooks() {
        List<BookProjection> topBooks = bookRepository.findAllBooks(new Sort(Sort.Direction.DESC, "rating")).subList(0,49);

        return topBooks;
    }

    public Optional<Book> findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        return book;
    }

    public Book findByTitle(String title) {
        Book book = bookRepository.findByTitle(title);

        return book;
    }

    public List<Book> findByGenre(String genre) {
        List<Book> booksByGenre = bookRepository.findBookByGenresOrderByRatingDesc(genreRepository.findGenreByGenreName(genre));

        return booksByGenre;
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book saveBook(Book book) {
        Book bookToSave = bookRepository.save(book);
        return bookToSave;
    }


}
