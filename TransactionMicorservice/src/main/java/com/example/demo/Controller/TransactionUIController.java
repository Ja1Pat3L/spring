package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Service.TransactionService;
import com.example.demo.dto.Book;
import com.example.demo.dto.Customer;
import com.example.demo.dto.Transaction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/transactions")
public class TransactionUIController {

	@Autowired
	private TransactionService transactionService;
	
	RestTemplate restTemp=new RestTemplate();
	
	  @RequestMapping(path = "/lendBook", method = RequestMethod.GET)
	    public String findAllTransactions(Model model) {
		  try {
			  
	ResponseEntity<Customer> responseEntity = 
			  			
			  			restTemp.exchange(
								
			  					"http://localhost:8082/api/customer", HttpMethod.GET,
								 
		    			    null,Customer.class
		    			  );
		    	       Customer customer=responseEntity.getBody();
		    	    	//model.addAttribute("customers",customer);	
		    	    	
		    	    	
		    	    	ResponseEntity<Book> responseEntity2 = 
					  			
					  			restTemp.exchange(
										
					  					"http://localhost:8081/api/book", HttpMethod.GET,
										 
				    			    null,Book.class
				    			  );
				    	      Book book=responseEntity2.getBody();
				    	    	model.addAttribute("books",book);	
		    	    	
	       // model.addAttribute("transactions",transaction);
	        return "lend-book";
		  }catch(Exception e) {
			  System.out.println(e.getMessage());
			  return "Error occured.";
		  }
		  
		  
	  }
	  @RequestMapping(path = "/showTransactions", method = RequestMethod.GET)
	  public String showTransactions(Model model) {
		  model.addAttribute("transactions", transactionService.getTransactions());
		  return "show-all-transaction";
	  }
	
}
		  