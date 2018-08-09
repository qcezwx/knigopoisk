package com.knigopoisk.demo.controller;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.repository.BookRepository;
import com.knigopoisk.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;


//    @RequestMapping(value = "/book", method = RequestMethod.GET)
//    public List<Book> getListOfBooks() {
//        return bookRepository.findAll();
//    }

    @GetMapping("/book")
    public List<Book> getTopBooks() {
        return bookService.getTopBooks();
    }


}
