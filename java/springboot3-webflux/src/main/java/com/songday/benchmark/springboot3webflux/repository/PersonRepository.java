package com.songday.benchmark.springboot3webflux.repository;

import com.songday.benchmark.springboot3webflux.model.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
    @Query("SELECT * FROM persons ORDER BY id DESC LIMIT 1")
    Mono<Person> getLatestPerson();
}
