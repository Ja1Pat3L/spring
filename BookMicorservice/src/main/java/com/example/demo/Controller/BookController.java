package com.example.demo.Controller;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public Book saveBook(@RequestBody @Valid Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping
	public Iterable<Book> getAllBooks(){
		return bookService.getBooks();
	}
	
	@GetMapping("/{BookId}")
	public ResponseEntity<Book> get(@PathVariable("BookId") Integer BookId) {
	  try {
	         Book book = bookService.getBookbyId(BookId);
	         return new ResponseEntity<Book>(book, HttpStatus.OK);
	      } catch (NoSuchElementException e) {
	          return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);}
	}
	    
	@GetMapping("/byTitle/{title}")
	public Iterable<Book> getBooksByTitle(@PathVariable("title") String title){
		return bookService.getBooksByTitle(title);
	}  

}
