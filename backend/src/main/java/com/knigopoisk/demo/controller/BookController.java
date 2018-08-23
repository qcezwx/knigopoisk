package com.knigopoisk.demo.controller;

import com.knigopoisk.demo.model.Book;
import com.knigopoisk.demo.projection.BookProjection;
import com.knigopoisk.demo.service.AuthorService;
import com.knigopoisk.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/api/book")
    public List<BookProjection> getTopBooks() {
        return bookService.findTopBooks();
    }

    @GetMapping("/api/book/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/api/book/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable("genre") String genre) {
        return bookService.findByGenre(genre);
    }

    @PostMapping("/api/book")
    public ResponseEntity<Object> createBook(@RequestBody String title, String fullname) {
        if (bookService.findByTitle(title) != null && authorService.findByFullname(fullname) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookService.saveBook(new Book(title, authorService.findByFullname(fullname)));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/book/{id}")
    public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);

        if (!bookOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        book.setId(id);
        bookService.saveBook(book);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
    }
}
