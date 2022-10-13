package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Iterable<Customer> getCustomers(){
		return customerRepo.findAll();
	}
	
	public Customer getCustomerById(Integer customerId) {
		return customerRepo.findById(customerId).get();
	}
	
	 
    //update a customer
    public void updateCustomer(Customer customer) throws Exception {
        if(customerRepo.findById(customer.getFcustomerid())!=null) {
        	customerRepo.save(customer);
        }
        else {
            throw new Exception("Customer Id not found");
        }
    }
    public void deleteCustomer(Integer customerId) {
		customerRepo.deleteById(customerId);
	}
}
