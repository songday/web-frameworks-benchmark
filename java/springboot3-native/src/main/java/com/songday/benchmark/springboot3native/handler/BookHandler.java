package com.songday.benchmark.springboot3native.handler;

import com.songday.benchmark.springboot3native.dto.Response;
import com.songday.benchmark.springboot3native.model.Book;
import com.songday.benchmark.springboot3native.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookHandler {
    private final BookService bookService;

    // https://stackoverflow.com/questions/74880928/content-type-application-json-not-supported-for-bodytype-when-using-native-ima
//    @RegisterReflectionForBinding(value = {Response.class, Book.class})
    @RegisterReflectionForBinding(value = {Response.class})
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
