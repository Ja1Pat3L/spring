package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	/*
	 * @Autowired private RestTemplate resttemplate;
	 */
	
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Iterable<Book> getBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBookbyId(int BookId) {
		 return bookRepo.findById(BookId).get();
	}
	
	public Iterable<Book> getBooksByTitle(String title){
		return bookRepo.findBytitle(title);
	}
	
	public void delete(int bookId){
		bookRepo.deleteById(bookId);
	}
}
