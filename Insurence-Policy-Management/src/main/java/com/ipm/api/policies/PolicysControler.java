package com.ipm.api.policies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class PolicysControler {
		@Autowired
		PolicysService ps;
		//Save Policys
		@PostMapping("/addpolicys")
		public String addPolicys(@RequestBody Policys po) {
				try {
					ps.saveCustomer(po);
					return "Thanks for Add "+po.getPolicycatagory()+ "Policy";
				} catch ( Exception e) {
					return "You have Account "+HttpStatus.BAD_REQUEST;
				}
			
		}
		//get policy
		@GetMapping("/getpolicys")
		public List<Policys> getPolicys(){
			return  ps.showPolicys();
			
		}
		//Update Policy by id
		@PutMapping("/updatepolicy/{id}")
		public String updatePolicy(@PathVariable("id") Long id,@RequestBody Policys p) {
				Policys pp=ps.updatePolicyById(id, p);
				if(pp!=null) {
					return id+" id's Policy is Updated  "+HttpStatus.ACCEPTED;
				}else {
					return id+"This id is not  Found...... "+HttpStatus.BAD_REQUEST;
				}
		}
		@DeleteMapping("/deletepolicy/{id}")
		public String deletePolicyById(@PathVariable Long id) {
				try {
					ps.deletebyid(id);
					return id+" this id is Delete"+ HttpStatus.ACCEPTED;
				} catch (Exception e) {
				
					return id+" This id not found ...Please check "+HttpStatus.BAD_REQUEST;
				}
		}
		
		
		
}
