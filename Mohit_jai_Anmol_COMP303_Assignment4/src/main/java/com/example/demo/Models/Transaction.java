package com.example.demo.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int TransactionId;
	@Column(nullable = false)
	public int CustomerId;
	@Column(nullable = false)
	public int BookId;
	@Column(nullable = false)
	public String TrxnDate;
	@Column(nullable = false)
	public String TrxnType;
	
	public Transaction() {
		super();
		
	}
	public Transaction(int transactionId, int customerId, int bookId, String trxnDate, String trxnType) {
		super();
		TransactionId = transactionId;
		CustomerId = customerId;
		BookId = bookId;
		TrxnDate = trxnDate;
		TrxnType = trxnType;
	}
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getTrxnDate() {
		return TrxnDate;
	}
	public void setTrxnDate(String trxnDate) {
		TrxnDate = trxnDate;
	}
	public String getTrxnType() {
		return TrxnType;
	}
	public void setTrxnType(String trxnType) {
		TrxnType = trxnType;
	}

}
