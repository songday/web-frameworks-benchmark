package com.songday.benchmark.springboot3native.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HandlersRouter {
    @Bean
    public RouterFunction<ServerResponse> functionalRoutes(BookHandler bookHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/book/latest") , bookHandler::getBook)
                ;
    }
}
