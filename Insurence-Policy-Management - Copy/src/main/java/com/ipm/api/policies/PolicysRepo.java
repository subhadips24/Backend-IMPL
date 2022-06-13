package com.ipm.api.policies;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PolicysRepo extends JpaRepository<Policys, Long> {

	public Policys findByPid(Long id);




	

}
