package com.ipm.api.unknowncustomersms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UnknownSmsService {
	@Autowired
	public UnknownSmsRepo urepo;
	// Save sms in DB

	public UnknownSms saveSms(UnknownSms sms) {
			return urepo.save(sms);

	}
	
	//Get All unknown sms 
	public List<UnknownSms> getAllSms(){
		
		return urepo.findAll();
	}
	//Count sms 
	
	public int countSms() {
		List<UnknownSms> allsms=urepo.findAll();
		return allsms.size();
	}
}
