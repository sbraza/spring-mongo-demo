package com.sample.springboot.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MongoRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoRabbitApplication.class, args);
	}

}
