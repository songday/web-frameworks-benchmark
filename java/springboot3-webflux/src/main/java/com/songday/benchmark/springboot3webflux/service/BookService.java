package com.songday.benchmark.springboot3webflux.service;

import com.songday.benchmark.springboot3webflux.model.Book;
import com.songday.benchmark.springboot3webflux.repository.BookRepository;
import io.github.scru128.Scru128;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Mono<Book> getLatestBook() {
        return bookRepository.getLatestBook();
    }

    public Mono<Book> saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book genBook() {
        Book book = new Book();
        book.setId(Scru128.generateString());
        book.setTitle("Book title");
        book.setPreview("Preview content of this book");
        book.setPrice((short) 20);
        book.setCreatedAt(new Date());
        return book;
    }

}
