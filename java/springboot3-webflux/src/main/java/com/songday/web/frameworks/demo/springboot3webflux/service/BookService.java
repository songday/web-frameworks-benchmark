package com.songday.web.frameworks.demo.springboot3webflux.service;

import com.songday.web.frameworks.demo.springboot3webflux.dto.Book;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookService {
    public Book getBook() {
        final Book book = new Book();
        book.setId(1);
        book.setTitle("Book title");
        book.setPreview("Book preview");
        book.setCreatedAt(new Date());
        return book;
    }
}
