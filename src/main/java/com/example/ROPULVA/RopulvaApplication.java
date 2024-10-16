package com.example.ROPULVA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RopulvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RopulvaApplication.class, args);
	}

}
