package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Book;

import com.example.demo.Service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book")
public class BookUIController {

	@Autowired
	private BookService bookService;
	RestTemplate restTemp=new RestTemplate();
	
	  @RequestMapping(path = "/showBooks.html", method = RequestMethod.GET)
	    public String findAllBooks(Model model) {
		  try {
			  ResponseEntity<List<Book>> responseEntity = 
	    			  restTemp.exchange(
	    					  "http://localhost:8081/api/book",
	    			    HttpMethod.GET,
	    			    null,
	    			    new ParameterizedTypeReference<List<Book>>() {}
	    			  );
	    			List<Book> books = responseEntity.getBody();
		    	      
		    	    	model.addAttribute("books",books);
								 
		    			
		    	    
	        model.addAttribute("books",books);
	        return "list-of-books";
		  }catch(Exception e) {
			  System.out.println(e.getMessage());
			  return "Error occured.";
		  }
		  
		  
	
}
	  //GET
	    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
	    public String register(Model model) {
	      
	        return "add-book";
	    }
	  
	  //post
	    @RequestMapping(value = "registerBook", method = RequestMethod.POST)
	    @ResponseStatus(value = HttpStatus.OK)
	    public void  addBook(@ModelAttribute("book") Book book, HttpServletResponse response) throws Exception {    
	    	
	    	
	    	bookService.saveBook(book);
	        response.sendRedirect("/book/showBooks.html");

	    }
	    
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") int id, Model model) {
	        bookService.delete(id);
	        return "redirect:/book/showBooks.html";
	    }
}
