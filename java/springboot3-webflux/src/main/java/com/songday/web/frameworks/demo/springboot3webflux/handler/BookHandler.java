package com.songday.web.frameworks.demo.springboot3webflux.handler;

import com.songday.web.frameworks.demo.springboot3webflux.dto.Book;
import com.songday.web.frameworks.demo.springboot3webflux.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class BookHandler {

    private final BookService bookService;

    @Autowired
    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Mono<ServerResponse> test(ServerRequest req) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(bookService.getBook()), Book.class
                );
    }
}
