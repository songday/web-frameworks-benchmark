package com.songday.benchmark.springboot3webflux.repository;

import com.songday.benchmark.springboot3webflux.model.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
    @Query("SELECT * FROM Books ORDER BY id DESC LIMIT 1")
    Mono<Book> getLatestBook();
}
