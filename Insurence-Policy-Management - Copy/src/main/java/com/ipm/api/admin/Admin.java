package com.ipm.api.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ipm.api.TodysDate;

import lombok.Data;
@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminid;
	@Column(unique = true,nullable = false )
	private String adminemail;
	@Column(nullable = false)
	private String adminname;
	private String adminpassword;
	private String adminphno;
	private String adminage;
	private String admingender;
	private String adminaddress;
	
	private String  seniormangeremail;
	private String adminJoinDate=TodysDate.todayDate();
}
