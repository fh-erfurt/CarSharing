package com.javaii.carsharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.javaii.carsharing.controller",
		"com.javaii.carsharing.model",
		"com.javaii.carsharing.repository",
		"com.javaii.carsharing.service",
		"com.javaii.carsharing.api"
})
public class CarsharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsharingApplication.class, args);
	}

}
