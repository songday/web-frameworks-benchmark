package com.songday.benchmark.springboot3webflux.dto;

import lombok.Data;

@Data
public class Response<D> {
    private int status;
    private D data;
    private String error;
}
