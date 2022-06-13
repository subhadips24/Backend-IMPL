package com.ipm.api.policies;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ipm.api.TodysDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policys {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	@Column(nullable = false)
	private String policyname;


	@Column(nullable = false)
	private String policycatagory;
	
	private String addDateOfPolicy=TodysDate.todayDate();

	// TODO Auto-generated method stub

	

	


}
