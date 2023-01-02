package com.songday.benchmark.springboot3native;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot3NativeApplication {

	public static void main(String[] args) {
//		Consumer<TypeHint.Builder> builderConsumer = TypeHint.builtWith(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.DECLARED_FIELDS);
		SpringApplication.run(Springboot3NativeApplication.class, args);
	}

}
