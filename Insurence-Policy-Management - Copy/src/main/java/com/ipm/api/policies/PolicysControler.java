package com.ipm.api.policies;

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
import org.springframework.web.bind.annotation.RestController;

import com.ipm.api.execptions.ProjectExecption;

@RestController
@CrossOrigin("http://localhost:4200")

public class PolicysControler {
		@Autowired
		PolicysService ps;
		HttpStatus hs;
		//Save Policys
		@PostMapping("/addpolicys")
		public HttpStatus addPolicys(@RequestBody Policys po) {
				try {
					ps.saveCustomer(po);
					return hs.CREATED;
				} catch ( Exception e) {
					throw new ProjectExecption() ;
				}
			
		}
		//get policy
		@GetMapping("/getpolicys")
		public List<Policys> getPolicys(){
			return  ps.showPolicys();
			
		}
		//Update Policy by id
		@PutMapping("/updatepolicy/{id}")
		public HttpStatus updatePolicy(@PathVariable("id") Long id,@RequestBody Policys p) {
				Policys pp=ps.updatePolicyById(id, p);
				if(pp!=null) {
					return HttpStatus.OK;
				}else {
					throw new ProjectExecption();
				}
		}
		@DeleteMapping("/deletepolicy/{id}")
		public HttpStatus deletePolicyById(@PathVariable Long id) {
				try {
					ps.deletebyid(id);
					return  HttpStatus.OK;
				} catch (Exception e) {
				
					 throw new ProjectExecption();
				}
		}
		
		//Counting Policies
		@GetMapping("/countpolicie")
		public int countPolicie() {
			List<Policys> pl=ps.showPolicys();
			return pl.size();
		}
		
		
		
}
