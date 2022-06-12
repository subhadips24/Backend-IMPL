package com.ipm.api.customerPolicieApply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipm.api.policies.PolicysService;

@Service
public class CustomerApllyPolicieService {
	@Autowired
	public CustomerApplyPolicieRepo apprepo;;
	
	@Autowired
	public PolicysService policysService;
	
	//Aplly Policy or Save Policy in Apply Table 
	public CustomerApplyPolicie apllicatonPolicy(CustomerApplyPolicie apply) {
			return apprepo.save(apply);
	}
	
	// Getting Apllication Table
		public List<CustomerApplyPolicie >  getCustomerApllication() {

		return  apprepo.findAll() ;

	}
		
		
		
	//Delete Customer Application
		public void deleteCustomerApllication(Long id) {
			
			this.apprepo.deleteById(id);
		}
		
	//Update Status
		public CustomerApplyPolicie updateStatus(Long id,CustomerApplyPolicie application) {
				CustomerApplyPolicie cp=apprepo.findByAppid(id);
				if(cp!=null) {
					cp.setStatus(application.getStatus());
					return apprepo.save(cp);
				}else {
					return null;
				}
				
				
			}
		
	//Counting which one approve or disapprove 
		public int countOfApprove(String status) {
			
			List<CustomerApplyPolicie> capplist=apprepo.findByStatusIs(status);
			
			return capplist.size();
			
			
		}
		
		
		public List<CustomerApplyPolicie> history(String cemail) {
			
					return apprepo.findBycustomeremailIs(cemail);
			
		}
		
		//Customer can't apply above all Policy count 
		public boolean matchApplicationWithTotdalPolicy( String email) {
				int countPolicy=policysService.showPolicys().size();
				int countApplicationByEmailId=history(email).size();
				
				if(countApplicationByEmailId<countPolicy) {
					
					return true;
				}else {
					return false;
				}
				
		}
		
public List<CustomerApplyPolicie> showDatabStatus(String status) {
			
			List<CustomerApplyPolicie> capplist=apprepo.findByStatusIs(status);
			
			return  capplist;
			
			
		}

		
	
	
}
