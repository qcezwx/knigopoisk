package com.knigopoisk.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MyBookController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/book")
    public MyBook showMyBook(@RequestParam(value = "title", defaultValue = "TestBook") String title,
                             String author, String language, String publisher) {
        return new MyBook(
                (int) counter.incrementAndGet(),
                "newBook",
                "newAuthor",
                "eng",
                "newPublisher");
    }
}
