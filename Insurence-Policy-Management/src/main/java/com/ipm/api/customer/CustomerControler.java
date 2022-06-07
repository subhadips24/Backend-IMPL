package com.ipm.api.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControler {
	@Autowired
	CustomerService cs;
	//For adding Customer use (/addcustomer)
	@PostMapping("/addcustomer")
	public HttpStatus addCustomer(@RequestBody Customer cc) {
		
			try {
				cs.saveCustomer(cc);
			} catch (Exception e) {
				System.out.println("Something wend wrong ...."+e);
				return HttpStatus.IM_USED;
			}
		return HttpStatus.CREATED;
	}
	
	@GetMapping("/")
		public List<Customer> showallCus() {
		return cs.showCustomers();
	}
	@GetMapping("/showdata/{email}/{password}")
	public Customer showallCustomer(@PathVariable("email") String email,@PathVariable("password") String password ) {
		
		
		Customer cu= cs.showCustomerUsingLogin(email, password);
		if(cu!=null) {
			return cu;
			
		}else {
			return null;
		}
	
	}
	@GetMapping("/login/{email}/{password}")
	public boolean loginSystem(@PathVariable("email") String email,@PathVariable("password") String password){
		if(cs.showCustomerUsingLogin(email, password)==null) {
			return false;
		}else {
			return true;
			
		}
	}
	@PutMapping("/updatecustomer/{email}")
	public HttpStatus updateCustomer(@PathVariable("email") String email, @RequestBody Customer customer) {
		try {
			
			Customer cc=cs.updateCustomerByEmail(email, customer);
			if(cc!=null)
			{
				return HttpStatus.ACCEPTED;
			}else {
				return HttpStatus.FAILED_DEPENDENCY;
			}
			
		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
		
		
	}
	
}
