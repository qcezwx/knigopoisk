package com.knigopoisk.demo.controller;

import com.knigopoisk.demo.model.Author;
import com.knigopoisk.demo.projection.AuthorDto;
import com.knigopoisk.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> getAuthor(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }
}
