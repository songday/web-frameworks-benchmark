package com.songday.web.frameworks.demo.springboot3mvc.controller;

import com.songday.web.frameworks.demo.springboot3mvc.dto.Book;
import com.songday.web.frameworks.demo.springboot3mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public Book test() {
        return bookService.getBook();
    }
}
