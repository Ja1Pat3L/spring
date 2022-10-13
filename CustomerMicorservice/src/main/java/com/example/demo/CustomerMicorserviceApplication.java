package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerMicorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicorserviceApplication.class, args);
		System.out.println("Customer Microservice Started");
	}

}
