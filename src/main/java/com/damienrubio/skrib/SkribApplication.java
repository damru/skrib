package com.damienrubio.skrib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkribApplication {

	public static SkribContext contexte = new SkribContext();

	public static void main(String[] args) {
		SpringApplication.run(SkribApplication.class, args);
	}
}
