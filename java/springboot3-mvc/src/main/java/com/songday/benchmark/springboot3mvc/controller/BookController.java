package com.songday.benchmark.springboot3mvc.controller;

import com.songday.benchmark.springboot3mvc.dto.Response;
import com.songday.benchmark.springboot3mvc.model.Book;
import com.songday.benchmark.springboot3mvc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("book/latest")
    public Response<Book> get() {
        bookService.saveBook(bookService.genPerson());
        Book book = bookService.getLatestBook();
        Response<Book> res = new Response<>();
        res.setStatus(200);
        res.setData(book);
        return res;
    }
}
