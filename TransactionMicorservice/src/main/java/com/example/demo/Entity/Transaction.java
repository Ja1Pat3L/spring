package com.example.demo.Entity;

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


@Entity
@Table(name="transaction")
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int transactionid;
	@Column(nullable = false, unique=true)
	@NotNull(message = "customerid is mandatory")
	public int customerid;
	@Column(nullable = false, unique=true)
	@NotNull(message = "bookid is mandatory")
	public int bookid;
	@NotNull(message = "Transaction date is mandatory")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate trxndate;
	@NotBlank(message = "Transaction type is mandatory")
	public String trxntype;
	
	public Transaction() {
		super();
		
	}

	public Transaction(int transactionid, @NotNull(message = "customerid is mandatory") int customerid,
			@NotNull(message = "bookid is mandatory") int bookid,
			@NotNull(message = "Transaction date is mandatory") LocalDate trxndate,
			@NotBlank(message = "Transaction type is mandatory") String trxntype) {
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
