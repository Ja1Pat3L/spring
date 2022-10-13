package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.example.demo.advice.ValidationExceptionHandler;

@SpringBootApplication
public class BookMicorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMicorserviceApplication.class, args);
		System.out.println("Book microservice started");
	}
	/*
	 * @Bean
	 * 
	 * @LoadBalanced public RestTemplate restTemplate() { return new RestTemplate();
	 * }
	 */
}
