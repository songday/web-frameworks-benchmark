package com.songday.benchmark.springboot3webflux.handler;

import com.songday.benchmark.springboot3webflux.dto.Response;
import com.songday.benchmark.springboot3webflux.model.Book;
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
        Book book = bookService.genBook();
        return bookService.saveBook(book).then(bookService.getLatestBook()).map(b -> {
            Response<Book> res = new Response<>();
            res.setStatus(200);
            res.setData(b);
            return res;
        }).flatMap(r -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(r)
                        , Response.class
                )
        );
    }

}
