package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Id;

@Entity
@Table(name="customer")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int fcustomerid;
	@NotBlank(message = "firstname is mandatory")
	public String firstname;
	@NotBlank(message = "lastname is mandatory")
	public String lastname;
	@NotBlank(message = "address is mandatory")
	public String address;
	@NotBlank(message = "Phone number is mandatory")
	@Size(max = 10, min = 10, message = "Phone number should be of 10 digits")
    @Pattern(regexp = "[1-9][0-9]{9}", message = "Phone number is invalid")
	public String phone;
	@NotBlank(message = "Email is mandatory")
	@Column(unique=true)
	public String emailid;
	
	public Customer() {
		super();
		
	}

	public Customer(int fcustomerid, @NotBlank(message = "firstname is mandatory") String firstname,
			@NotBlank(message = "lastname is mandatory") String lastname,
			@NotBlank(message = "address is mandatory") String address,
			@NotBlank(message = "Phone number is mandatory") @Size(max = 10, min = 10, message = "Phone number should be of 10 digits") @Pattern(regexp = "[2-9][0-9]{9}", message = "Phone number is invalid") String phone,
			@NotBlank(message = "Email is mandatory") String emailid) {
		super();
		this.fcustomerid = fcustomerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
	}

	public int getFcustomerid() {
		return fcustomerid;
	}

	public void setFcustomerid(int fcustomerid) {
		this.fcustomerid = fcustomerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	
	
}
