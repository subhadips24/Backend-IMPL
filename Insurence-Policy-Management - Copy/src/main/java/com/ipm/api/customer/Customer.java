package com.ipm.api.customer;

import javax.persistence.Column;
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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	@Column(unique = true,nullable = false )
	private String cemail;
	private String cname;
	private String cpassword;
	private String cphno;
	private String cage;
	private String cgender;
	private String caddress;
	
	
	
}
