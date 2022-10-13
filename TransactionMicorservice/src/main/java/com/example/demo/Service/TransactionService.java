package com.example.demo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Transaction;
import com.example.demo.Repository.TransactionRepository;
import com.example.demo.dto.Book;
import com.example.demo.dto.Customer;
import com.example.demo.dto.LendRequest;
import com.example.demo.dto.LendResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
@RefreshScope
public class TransactionService {
	
	Logger logger= LoggerFactory.getLogger(TransactionService.class);
	@Autowired
	private TransactionRepository transactionRepo;
	@Autowired
	private RestTemplate resttemplate;

	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepo.save(transaction);
	}
	
	public Transaction getTransactionById(Integer transactionId) {
		return transactionRepo.findById(transactionId).get();
	}
	
	public Iterable<Transaction> getTransactions(){
		return transactionRepo.findAll();
	}
	
	public void deleteTransaction(Integer transactionId) {
		transactionRepo.deleteById(transactionId);
	}

	public Iterable<Transaction> getLentBooks(String trxntype) {
		return transactionRepo.findBytrxntype(trxntype);
		
	}

	public LendResponse displayLentBook(LendRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * public LendResponse displayLentBook(LendRequest request) throws
	 * JsonProcessingException { com.example.demo.dto.Transaction transaction =
	 * request.getTransaction(); Customer customer =
	 * resttemplate.getForObject("http://CUSTOMER-SERVICE/api/customer/"+transaction
	 * .getCustomerid(), Customer.class);
	 * logger.info("Transaction Service getting Response from Customer-Service : "
	 * +new ObjectMapper().writeValueAsString(customer)); Book book =
	 * resttemplate.getForObject("http://BOOK-SERVICE/api/book/"+transaction.
	 * getBookid(), Book.class); return new
	 * LendResponse(book,customer,transaction.getTrxntype()); }
	 */

}
