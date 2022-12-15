package com.songday.benchmark.springboot3mvc.model;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String id;
    private String title;
    private String preview;
    private short price;
    private Date createdAt;

}
