package com.songday.benchmark.springboot3webflux.handler;

import com.songday.benchmark.springboot3webflux.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonHandler {
    private final PersonService personService;
    public Mono<ServerResponse> getPerson(ServerRequest req) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        personService.savePerson(personService.genPerson()).then(personService.getLatestPerson())
                        ,String.class
                );
    }

}
