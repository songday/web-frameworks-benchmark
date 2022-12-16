package com.songday.benchmark.springboot3webflux.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("books")
public class Book {
    @Id
    private String id;
    @Column("title")
    private String title;
    @Column("preview")
    private String preview;
    @Column("price")
    private short price;
    @Column("created_at")
    private LocalDateTime createdAt;

}
