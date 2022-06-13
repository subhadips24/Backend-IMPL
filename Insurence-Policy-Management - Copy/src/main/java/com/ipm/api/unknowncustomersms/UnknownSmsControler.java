package com.ipm.api.unknowncustomersms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipm.api.execptions.ProjectExecption;

@RestController
@CrossOrigin("http://localhost:4200")
public class UnknownSmsControler {
		@Autowired
		public UnknownSmsService userv;
		HttpStatus hs;
		
		
		//Save All Unknown sms 
		
		@PostMapping("/addunknowsms")
		public HttpStatus saveSms( @RequestBody UnknownSms sms) {
			
			try {
				userv.saveSms(sms);
				return hs.CREATED;
			} catch (Exception e) {
				
					throw new ProjectExecption() ;
			}
			
		}
	//Get Unknown sms 
		@GetMapping("/getunknownsms")
		public List<UnknownSms> getsmss(){
			return userv.getAllSms();
		}
		//Count unknown sms 
		@GetMapping("/unknownsmscount")
		public int countUnknownSMs() {
			
			return userv.countSms();
		}
		

	
}
