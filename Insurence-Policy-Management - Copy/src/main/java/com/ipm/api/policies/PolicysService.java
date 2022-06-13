package com.ipm.api.policies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ipm.api.TodysDate;


@Service
public class PolicysService {
	@Autowired
	PolicysRepo prepo;
	
	// Insert data in Database
	public Policys saveCustomer(Policys c) {
		
		return prepo.save(c);
		
	}
	//Show all customer details
	public List<Policys> showPolicys(){
		
		return prepo.findAll();
		
	}
	//Update Policy--
	public Policys updatePolicyById(Long id,Policys p) {
		Policys   fp=prepo.findByPid(id);
		if (fp!=null) {
			fp.setAddDateOfPolicy(TodysDate.todayDate());
			
			fp.setPolicycatagory(p.getPolicycatagory());
			fp.setPolicyname(p.getPolicyname());
			return prepo.save(fp);
		}else {
			return null;
		}
	}
	
	//Delete By Id
	public void deletebyid(Long id) {
		prepo.deleteById(id);
	}
}
	
	

