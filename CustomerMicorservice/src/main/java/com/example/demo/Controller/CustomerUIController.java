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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;
@Controller
@RequestMapping("/customer")
public class CustomerUIController {
	@Autowired
	private CustomerService customerService;
	
	RestTemplate restTemp=new RestTemplate();
	  @RequestMapping(path = "/showCustomers", method = RequestMethod.GET)
	    public String findAllCustomers(Model model) {
		  try {
			  
			  ResponseEntity<List<Customer>> responseEntity = 
	    			  restTemp.exchange(
	    					  "http://localhost:8082/api/customer",
	    			    HttpMethod.GET,
	    			    null,
	    			    new ParameterizedTypeReference<List<Customer>>() {}
	    			  );
	    			List<Customer> customers = responseEntity.getBody();
		    	      
		    	    	model.addAttribute("customers",customers);
			  
	        //model.addAttribute("customers", customerService.getCustomers());
	        return "list-of-customers";
		  }catch(Exception e) {
			  System.out.println(e.getMessage());
			  return "Error occured.";
		  }
	  }
	
	  
	  //GET
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model model) {
      
        return "register-customer";
    }
 
  
  //post
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void  addCustomer(@ModelAttribute("customer") Customer customer, HttpServletResponse response) throws Exception {    
    	
    	
    	customerService.saveCustomer(customer);
    	
    	restTemp.postForEntity("http://localhost:8082/api/customer", customer, String.class);
        response.sendRedirect("/customer/showCustomers");

    }
    	   
	/*
	 * //POST
	 * 
	 * @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	 * 
	 * @ResponseStatus(value = HttpStatus.OK) public void
	 * updateCustomer(@ModelAttribute("customer") Customer customer,
	 * HttpServletResponse response) throws Exception {
	 * customerService.updateCustomer(customer);
	 * response.sendRedirect("/list-Of-Customers"); }
	 */
    
    //GET
    //GET
    //to delete customer
    @RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("customerId") int customerId) throws Exception {
    	//customerService.deleteCustomer(customerId);
    	restTemp.delete("http://localhost:8082/api/customer/deleteCustomer/"+customerId);
     return new ModelAndView("forward:/customer/showCustomers");
    }
    
    
    
    
  	//GET
      //to update customer details
      @RequestMapping(value = "/update/{customerId}", method = RequestMethod.GET)
         public String modifyCustomer(@PathVariable("customerId") int customerId ,Model model ) throws Exception {
          model.addAttribute("customer",customerService.getCustomerById(customerId));
          return "update-customer";
      }
    //POST
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCustomer(@ModelAttribute("customer") Customer customer, HttpServletResponse response) throws Exception {
        customerService.updateCustomer(customer);
        response.sendRedirect("/customer/showCustomers");
    }
    
   
       
}
