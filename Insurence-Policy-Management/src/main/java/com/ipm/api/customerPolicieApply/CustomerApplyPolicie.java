package com.ipm.api.customerPolicieApply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ipm.api.TodysDate;

import lombok.Data;

@Entity
@Table(name = "Customer_Apply_Policies")
@Data
public class CustomerApplyPolicie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appid;
	@Column(nullable = false)
	private String customername;
	@Column(nullable = false)
	private String customeremail;
	
	private String policyPrice;
	@Column(nullable = false)
	private String policyCatagory;
	
	private String policyName;
	private String status = "Pending";
	private String policyapplydate =TodysDate.todayDate(); 

	
}
