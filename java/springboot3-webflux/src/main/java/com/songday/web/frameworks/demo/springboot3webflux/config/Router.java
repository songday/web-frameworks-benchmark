package com.songday.web.frameworks.demo.springboot3webflux.config;

import com.songday.web.frameworks.demo.springboot3webflux.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> functionalRoutes(BookHandler bookHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/")
                        , bookHandler::test);
    }
}
