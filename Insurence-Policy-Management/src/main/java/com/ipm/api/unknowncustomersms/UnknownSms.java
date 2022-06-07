package com.ipm.api.unknowncustomersms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnknownSms {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long usmsid;
	private String usmsemail;
	private String ucustomername;
	private String  sms;
	
}
