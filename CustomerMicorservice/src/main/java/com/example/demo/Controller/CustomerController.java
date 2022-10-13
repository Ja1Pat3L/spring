package com.example.demo.Controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping()
	public Customer saveCustomer(@RequestBody @Valid Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping
	public Iterable<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> get(@PathVariable("customerId") Integer customerId) {
        try {
            Customer customer = customerService.getCustomerById(customerId);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }
    
    //PUT
    @RequestMapping(value = "/updateCustomer/{customerId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) throws Exception {
    	customer.setFcustomerid(customerId);
    	customerService.updateCustomer(customer);
    }
    
    //GET
    //to show the customer details
    @RequestMapping(value = "/view/{customerId}", method = RequestMethod.GET)
       public String viewCustomer(@PathVariable("customerId") int customerId ,Model model ) throws Exception {
        model.addAttribute("customer",customerService.getCustomerById(customerId));
        return "customerDetails";
    }
    
    //DELETE
    @RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteCustomer(@PathVariable("customerId") int customerId) throws Exception {
        customerService.deleteCustomer(customerId);
    }
    
}
