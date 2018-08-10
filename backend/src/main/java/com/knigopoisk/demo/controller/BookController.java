package com.knigopoisk.demo.controller;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/book/{title}")
    public Book getBook(@PathVariable("title") String title) {
        return bookService.getBookByTitle(title);
    }
}
