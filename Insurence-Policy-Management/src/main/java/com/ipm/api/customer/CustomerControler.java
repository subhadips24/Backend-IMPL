package com.ipm.api.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControler {
	@Autowired
	CustomerService cs;
	//For adding Customer use (/addcustomer)
	@PostMapping("/addcustomer")
	@ResponseStatus(HttpStatus.CREATED)
	public String addCustomer(@RequestBody Customer cc) {
		
			try {
				cs.saveCustomer(cc);
			} catch (Exception e) {
				System.out.println("Something wend wrong ...."+e);
				
			}
		return "Thank You! You have done Registration Sucessfully  "+cc.getCname();
	}
	
	@GetMapping("/showcustomers")
	@ResponseStatus(HttpStatus.FOUND)
		public List<Customer> showallCus() {
		return cs.showCustomers();
	}
	
	@GetMapping("/showdata/{email}/{password}")
	@ResponseStatus(HttpStatus.FOUND)
	public Customer showaCustomerByEamilAndPass(@PathVariable("email") String email,@PathVariable("password") String password ) {
		
		
		Customer cu= cs.showCustomerUsingLogin(email, password);
		if(cu!=null) {
			return cu;
			
		}else {
			return null;
		}
	
	}
	//Check for Login MAping.....
	
	@GetMapping("/login/{email}/{password}")
	@ResponseStatus(HttpStatus.FOUND)
	public boolean loginSystem(@PathVariable("email") String email,@PathVariable("password") String password){
		if(cs.showCustomerUsingLogin(email, password)==null) {
			return false;
		}else {
			return true;
			
		}
	}
	@PutMapping("/updatecustomer/{email}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String updateCustomer(@PathVariable("email") String email, @RequestBody Customer customer) {
		try {
			
			Customer cc=cs.updateCustomerByEmail(email, customer);
			if(cc!=null)
			{
				return  customer.getCname()+" Your data is updated";
			}else {
				
				return  "Your data not there please check your email id "+email;
			}
			
			
		} catch (Exception e) {
			return "Something wend wrong" ;
		}
		
		
	}
	@DeleteMapping("/deletecustomer/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public String deleteUser(@PathVariable("id") Long id) {
		try {
			cs.deletecustomer(id);
			return id+"  this Id of Customer Deleted";
		} catch (Exception e) {
			return id+"  this  id "+HttpStatus.NOT_FOUND;
			
		}
	}
	//Count Register Customer...
	@GetMapping("/countcustomer")
	public int countCustomer() {
		List<Customer> cl=cs.showCustomers();
		
		return cl.size();
	}
	
}
