package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@SpringBootApplication
@Data
public class Ex00Application {
	int data;
	public static void main(String[] args) {
		SpringApplication.run(Ex00Application.class, args);
	}

}
