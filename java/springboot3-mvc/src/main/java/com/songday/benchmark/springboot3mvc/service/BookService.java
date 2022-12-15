package com.songday.benchmark.springboot3mvc.service;

import com.songday.benchmark.springboot3mvc.dao.BookMapper;
import com.songday.benchmark.springboot3mvc.model.Book;
import io.github.scru128.Scru128;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    public Book getLatestBook() {
        return bookMapper.getLatestBook();
    }

    public void saveBook(Book book) {
        bookMapper.addBook(book);
    }

    public Book genPerson() {
        Book book = new Book();
        book.setId(Scru128.generateString());
        book.setTitle("Book title");
        book.setPreview("Preview content of this book");
        book.setPrice((short) 20);
        book.setCreatedAt(new Date());
        return book;
    }
}
