package com.knigopoisk.demo.service;

import com.knigopoisk.demo.model.Author;
import com.knigopoisk.demo.projection.AuthorDto;
import com.knigopoisk.demo.projection.AuthorProjection;
import com.knigopoisk.demo.projection.BookProjection;
import com.knigopoisk.demo.repository.AuthorRepository;
import com.knigopoisk.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Autowired


    public List<AuthorDto> findSortedByRating() {
        List<AuthorProjection> topAuthorsProjection = authorRepository.findAllAuthorsWithRating();
        List<AuthorDto> topAuthors = new LinkedList<AuthorDto>();

        for (AuthorProjection authorProjection : topAuthorsProjection) {
            AuthorDto authorDto = AuthorDto.fromProjection(authorProjection);
            Long selectedId = authorProjection.getId();
            List<BookProjection> titlesAndAuthorIds = bookRepository.findBooksByAuthor_Id(selectedId);
            authorDto.setTitles(titlesAndAuthorIds);
            topAuthors.add(authorDto);
        }

        return topAuthors;
    }

    public AuthorDto findById(Long id) {
        AuthorProjection author = authorRepository.findAuthorById(id);
        AuthorDto authorDto = AuthorDto.fromProjection(author);
        List<BookProjection> titlesAndAuthorIds = bookRepository.findBooksByAuthor_Id(author.getId());
        authorDto.setTitles(titlesAndAuthorIds);

        return authorDto;
    }

    public Author findByFullname(String fullname) {
        Author author = authorRepository.findByFullname(fullname);

        return author;
    }
}
