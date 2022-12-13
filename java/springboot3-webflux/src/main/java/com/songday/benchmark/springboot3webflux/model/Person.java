package com.songday.benchmark.springboot3webflux.model;

import lombok.Data;

@Data
public class Person {
    private String id;
    private String name;
    private short age;
    private String description;
}
