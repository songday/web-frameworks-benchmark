package com.songday.benchmark.springboot3webflux.handler;

import com.songday.benchmark.springboot3webflux.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookHandler {
    private final BookService bookService;
    public Mono<ServerResponse> getBook(ServerRequest req) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        bookService.saveBook(bookService.genBook()).then(bookService.getLatestBook())
                        ,String.class
                );
    }

}
