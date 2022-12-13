package com.songday.benchmark.springboot3webflux.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HandlersRouter {
    @Bean
    public RouterFunction<ServerResponse> functionalRoutes(PersonHandler personHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/person/get") , personHandler::getPerson)
                ;
    }
}
