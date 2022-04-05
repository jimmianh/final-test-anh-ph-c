package com.javamaster.springsecurityjwt.repository;

import com.javamaster.springsecurityjwt.entity.CriminalCase;
import com.javamaster.springsecurityjwt.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {

	boolean existsByNumber(String number);

	Evidence findByNumber(String number);
	
	List<Evidence> findByCriminalCase(CriminalCase criminalCase);
	
	

}
