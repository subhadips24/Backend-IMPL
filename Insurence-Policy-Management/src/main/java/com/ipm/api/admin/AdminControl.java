package com.ipm.api.admin;

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

import com.ipm.api.customer.Customer;
import com.ipm.api.customer.CustomerService;

@RestController
public class AdminControl {
	@Autowired
	AdminService adminService;
	//For adding Customer use (/addadmin)
	@PostMapping("/addadmin")
	@ResponseStatus(HttpStatus.CREATED)
	public String addAdmin(@RequestBody Admin aa) {
		
			try {
				adminService.saveAdmin(aa);
				return "Thank You! You have done Registration Sucessfully  "+aa.getAdminname();
			} catch (Exception e) {
				return "Something went wrong";
				
			}
	
	}
	
	//Getting Data from Admin tale 
	
	@GetMapping("/showadmins")
	@ResponseStatus(HttpStatus.FOUND)
		public List<Admin> showallAdmins() {
		return adminService.showAdmins();
	}
	
	//Getting data using emaiid and password
	
	@GetMapping("/adminshowdata/{email}/{password}")
	@ResponseStatus(HttpStatus.FOUND)
	public Admin showaCustomerByEamilAndPass(@PathVariable("email") String email,@PathVariable("password") String password ) {
		
		
		Admin adu= adminService.showAdminUsingLogin(email, password);
		if(adu!=null) {
			
			return adu;
		
		}else {
			return null;
		}
	
	}
	//Check for Login MAping.....
	
	@GetMapping("/adminlogin/{email}/{password}")
	@ResponseStatus(HttpStatus.FOUND)
	public boolean loginSystem(@PathVariable("email") String email,@PathVariable("password") String password){
		if(adminService.showAdminUsingLogin(email, password)==null) {
			return false;
		}else {
			return true;
			
		}
	}
	
	@PutMapping("/updateadmin/{email}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String updateCustomer(@PathVariable("email") String email, @RequestBody Admin admin) {
		try {
			
			Admin cc=adminService.updateAdminByEmail(email, admin);
			if(cc!=null)
			{
				return  cc.getAdminname()+" Your data is updated";
			}else {
				
				return  "Your data not there please check your email id "+email;
			}
			
			
		} catch (Exception e) {
			return "Something wend wrong" ;
		}
		
		
	}
	//Delete Data in admin
	
	@DeleteMapping("/deleteadmin/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public String deleteUser(@PathVariable("id") Long id) {
		try {
			adminService.deleteAdmin(id);
			return id+"  this Id of Customer Deleted";
		} catch (Exception e) {
			return id+"  this  id "+HttpStatus.NOT_FOUND;
			
		}
	}

}
