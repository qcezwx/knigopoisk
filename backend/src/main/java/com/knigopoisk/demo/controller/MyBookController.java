package com.knigopoisk.demo.controller;

import com.knigopoisk.demo.model.MyBook;
import com.knigopoisk.demo.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyBookController {
    @Autowired
    private MyBookRepository myBookRepository;


    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<MyBook> getListOfBooks() { return myBookRepository.findAll(); }

//    @RequestMapping(value = "/book", method = RequestMethod.GET)
//    public Page<MyBook> getBooks(Pageable pageable) {
//        return myBookRepository.findAll(pageable);
//    }
}
