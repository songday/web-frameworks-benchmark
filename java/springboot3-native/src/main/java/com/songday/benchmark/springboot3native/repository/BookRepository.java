package com.songday.benchmark.springboot3native.repository;

import com.songday.benchmark.springboot3native.model.Book;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
    @Modifying
    @Query("INSERT INTO books(id,title,preview,price,created_at)VALUES(:#{#book.id},:#{#book.title},:#{#book.preview},:#{#book.price},:#{#book.createdAt})")
    Mono<Book> insertNew(@Param("book") Book book);
    @Query("SELECT * FROM books ORDER BY id DESC LIMIT 1")
    Mono<Book> getLatestBook();
}
