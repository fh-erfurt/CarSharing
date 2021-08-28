package com.javaii.carsharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CarsharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsharingApplication.class, args);
	}

}
