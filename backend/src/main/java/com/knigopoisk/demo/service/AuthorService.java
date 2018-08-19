package com.knigopoisk.demo.service;

import com.knigopoisk.demo.model.Author;
import com.knigopoisk.demo.repository.AuthorRepository;
import com.knigopoisk.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.math.BigInteger;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public List<Object[]> getAuthors() {
        List<Object[]> topAuthors = authorRepository.findAllAuthorsWithRating();

        for (int i = 0; i < topAuthors.size(); i++) {
            Object[] selectedAuthor = topAuthors.get(i);
            BigInteger selectedId = (BigInteger) selectedAuthor[0];
            Long longSelectedId = selectedId.longValue();
            List<Object> titlesAndAuthorIds = bookRepository.findBooksByAuthor_Id(longSelectedId);
            Object[] authorWithBooks = new Object[selectedAuthor.length + 1];
            for (int j = 0; j < selectedAuthor.length; j++) {
                authorWithBooks[j] = selectedAuthor[j];
            }
            authorWithBooks[selectedAuthor.length] = titlesAndAuthorIds;
            topAuthors.remove(i);
            topAuthors.add(i, authorWithBooks);
        }


        return topAuthors;
    }

    public Optional<Author> getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        return  author;
    }
}
