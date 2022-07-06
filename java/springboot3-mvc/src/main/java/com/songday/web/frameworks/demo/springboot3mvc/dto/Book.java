package com.songday.web.frameworks.demo.springboot3mvc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private long id;
    private String title;
    private String preview;
    private Date createdAt;
}
