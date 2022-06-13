package com.ipm.api.questionsbycustomer;

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
public class QuestionsCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	@Column(nullable = false)

	private String customeremail;
	@Column(nullable = false)
	private String qtopic;
	@Column(nullable = false)
	private String qdetails;
	private String qdate = TodysDate.todayDate();
	private String qanswer;
	private String answerdate;

}
