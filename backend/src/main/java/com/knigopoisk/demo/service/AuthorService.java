package com.knigopoisk.demo.service;

import com.knigopoisk.demo.model.Author;
import com.knigopoisk.demo.projection.AuthorDto;
import com.knigopoisk.demo.projection.AuthorProjection;
import com.knigopoisk.demo.repository.AuthorRepository;
import com.knigopoisk.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public List<AuthorDto> findSortedByRating() {
        List<AuthorProjection> topAuthorsProjection = authorRepository.findAllAuthorsWithRating();
        List<AuthorDto> topAuthors = new LinkedList<AuthorDto>();

        for (int i = 0; i < topAuthorsProjection.size(); i++) {
            AuthorDto authorDto = AuthorDto.fromProjection(topAuthorsProjection.get(i));
            Long selectedId = topAuthorsProjection.get(i).getId();
            List<String> titlesAndAuthorIds = bookRepository.findBooksByAuthor_Id(selectedId);
            authorDto.setTitles(titlesAndAuthorIds);
            topAuthors.add(authorDto);
        }

        return topAuthors;
    }

    public Optional<Author> findById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        return author;
    }

    public Author findByFullname(String fullname) {
        Author author = authorRepository.findByFullname(fullname);

        return  author;
    }
}
