package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Id;


@Entity
@Table(name="book")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookid")
	public int bookId;
	@NotBlank(message = "Title is mandatory")
	public String title;
	@NotBlank(message = "LastName is mandatory")
	public String authorlastname;
	@NotBlank(message = "FirstName is mandatory")
	public String authorfirstname;
	@NotNull(message = "Rating is mandatory")
	@Min(value = 1, message = "Rating can only be between 1 and 5")
	@Max(5)
	public int rating;
	
	public Book() {
		super();
		
	}

	public Book(int bookId, @NotBlank(message = "Title is mandatory") String title,
			@NotBlank(message = "LastName is mandatory") String authorlastname,
			@NotBlank(message = "FirstName is mandatory") String authorfirstname,
			@NotNull(message = "Rating is mandatory") @Min(value = 1, message = "Rating can only be between 1 and 5") @Max(5) int rating) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authorlastname = authorlastname;
		this.authorfirstname = authorfirstname;
		this.rating = rating;
	}


	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorlastname() {
		return authorlastname;
	}

	public void setAuthorlastname(String authorlastname) {
		this.authorlastname = authorlastname;
	}

	public String getAuthorfirstname() {
		return authorfirstname;
	}

	public void setAuthorfirstname(String authorfirstname) {
		this.authorfirstname = authorfirstname;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
