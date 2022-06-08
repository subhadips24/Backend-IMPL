package com.ipm.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("http://localhost:4200")
public class AdminControl {
	HttpStatus hs;
	@Autowired
	AdminService adminService;
	//For adding Customer use (/addadmin)
	@PostMapping("/addadmin")
	@ResponseStatus(HttpStatus.CREATED)
	public HttpStatus addAdmin(@RequestBody Admin aa) {
		
			try {
				adminService.saveAdmin(aa);
				return hs.CREATED;
			} catch (Exception e) {
				return hs.BAD_REQUEST;
				
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
	public HttpStatus updateCustomer(@PathVariable("email") String email, @RequestBody Admin admin) {
		try {
			
			Admin cc=adminService.updateAdminByEmail(email, admin);
			if(cc!=null)
			{
				return  hs.OK;
			}else {
				
				return  hs.NOT_ACCEPTABLE;
			}
			
			
		} catch (Exception e) {
			return hs.INTERNAL_SERVER_ERROR ;
		}
		
		
	}
	//Delete Data in admin
	
	@DeleteMapping("/deleteadmin/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public HttpStatus deleteUser(@PathVariable("id") Long id) {
		try {
			adminService.deleteAdmin(id);
			return hs.OK;
		} catch (Exception e) {
			return HttpStatus.NOT_FOUND;
			
		}
	}

}
