package com.knigopoisk.demo.service;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getTopBooks() {
        List<Book> topBooks = bookRepository.findTop50ByOrderByRatingDesc();

        return  topBooks;
    }

    public Book getBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        return book;
    }
}
