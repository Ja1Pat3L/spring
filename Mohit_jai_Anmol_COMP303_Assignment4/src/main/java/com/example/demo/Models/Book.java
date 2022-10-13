package com.example.demo.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int BookId;
	@Column(nullable = false)
	public String Title;
	@Column(nullable = false)
	public String AuthorLastName;
	@Column(nullable = false)
	public String AuthorFirstName;
	@Column(nullable = false)
	public int Rating;
	
	public Book() {
		super();
		
	}

	public Book(int bookId, String title, String authorLastName, String authorFirstName, int rating) {
		super();
		BookId = bookId;
		Title = title;
		AuthorLastName = authorLastName;
		AuthorFirstName = authorFirstName;
		Rating = rating;
	}

	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthorLastName() {
		return AuthorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		AuthorLastName = authorLastName;
	}

	public String getAuthorFirstName() {
		return AuthorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		AuthorFirstName = authorFirstName;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}
	
}
