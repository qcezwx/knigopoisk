package com.knigopoisk.demo.controller;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> getTopBooks() {
        return bookService.getTopBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

//    @GetMapping("/book/{title}")
//    public Book getBookById(@PathVariable("title") String title) {
//        return bookService.getBookById(title);
//    }

    @GetMapping("/book/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable("genre") String genre) {
        return bookService.getBooksByGenre(genre);
    }
}
