package com.knigopoisk.demo.service;

import com.knigopoisk.demo.model.Author;
import com.knigopoisk.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        List<Author> authors = authorRepository.findAll();

        return authors;
    }

    public Optional<Author> getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        return  author;
    }
}
