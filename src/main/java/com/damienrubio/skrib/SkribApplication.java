package com.damienrubio.skrib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SkribApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkribApplication.class, args);
	}
}
