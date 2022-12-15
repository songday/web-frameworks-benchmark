package com.songday.benchmark.springboot3mvc;

import lombok.Data;

@Data
public class Response<D> {
    private int status;
    private D data;
    private String error;
}
