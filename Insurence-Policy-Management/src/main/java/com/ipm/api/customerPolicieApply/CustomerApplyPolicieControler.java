package com.ipm.api.customerPolicieApply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipm.api.execptions.ProjectExecption;

@RestController
@CrossOrigin("http://localhost:4200")
public class CustomerApplyPolicieControler {
	@Autowired
	CustomerApllyPolicieService apservice;
	HttpStatus httpStatus;

	// Save Application
	@PostMapping("/applypolicy")

	public HttpStatus apllicationSave(@RequestBody CustomerApplyPolicie cpp) {
		try {

			apservice.apllicatonPolicy(cpp);
			return httpStatus.CREATED;

		} catch (Exception e) {
			throw new ProjectExecption() ;
		}
	}

	@GetMapping("/getallaplicationofpolicy")

	public List<CustomerApplyPolicie> showApllication() {

		return apservice.getCustomerApllication();
	}

	// Update Status
	@PutMapping("/updatestatus/{id}")

	public String  updateStatus(@PathVariable Long id, @RequestBody CustomerApplyPolicie cap) {

		CustomerApplyPolicie cp=apservice.updateStatus(id, cap);
			if(cp!=null) {
				
			apservice.updateStatus(id, cap);

			return "Updated";
			}else {
				throw new ProjectExecption();
			}
		

	}

	@GetMapping("/countApprove")
	public int countApprove() {

		return apservice.countOfApprove("Approved");
	}

	// count pending
	@GetMapping("/countPending")
	public int countPending() {

		return apservice.countOfApprove("Pending");
	}

	@GetMapping("/countrejected")
	public int countRejacted() {
		return apservice.countOfApprove("Rejected");
	}

	@GetMapping("/countapllication")
	public int countApply() {
		List<CustomerApplyPolicie> capp = apservice.getCustomerApllication();
		return capp.size();
	}

}
