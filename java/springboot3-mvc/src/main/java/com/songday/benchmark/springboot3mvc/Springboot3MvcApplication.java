package com.songday.benchmark.springboot3mvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.songday.benchmark.springboot3mvc.dao")
public class Springboot3MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3MvcApplication.class, args);
	}

}
