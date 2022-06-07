package com.ipm.api.questionsbycustomer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QustionsCustomerRepo extends JpaRepository<QuestionsCustomer, Long> {
	//public QuestionsCustomer findByQid(Long id);

	public QuestionsCustomer findByQidIs(Long qid);
}
