package com.example.demo.dto;

import com.example.demo.Entity.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LendResponse {

	public LendResponse(Book book, Customer customer, String transactionType) {
		// TODO Auto-generated constructor stub
	}
	Book book;
	Customer customer;
	String transactionType;
}
