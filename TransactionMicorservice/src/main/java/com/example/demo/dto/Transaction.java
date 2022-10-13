package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;



public class Transaction {

	public int transactionid;

	public int customerid;

	public int bookid;

	public LocalDate trxndate;

	public String trxntype;
	
	public Transaction() {
		super();
		
	}



	public Transaction(int transactionid, int customerid, int bookid, LocalDate trxndate, String trxntype) {
		super();
		this.transactionid = transactionid;
		this.customerid = customerid;
		this.bookid = bookid;
		this.trxndate = trxndate;
		this.trxntype = trxntype;
	}



	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public LocalDate getTrxndate() {
		return trxndate;
	}

	public void setTrxndate(LocalDate trxndate) {
		this.trxndate = trxndate;
	}

	public String getTrxntype() {
		return trxntype;
	}

	public void setTrxntype(String trxntype) {
		this.trxntype = trxntype;
	}

}
