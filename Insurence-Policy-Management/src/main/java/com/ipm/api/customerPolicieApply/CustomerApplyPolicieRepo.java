package com.ipm.api.customerPolicieApply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
 interface CustomerApplyPolicieRepo extends JpaRepository<CustomerApplyPolicie, Long> {
		public CustomerApplyPolicie findByAppid(Long id);

     public	List<CustomerApplyPolicie> findByStatusIs(String status);
     
     	public List<CustomerApplyPolicie> findBycustomeremailIs(String customeremail);
		
}

