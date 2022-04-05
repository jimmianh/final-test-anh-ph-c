package com.javamaster.springsecurityjwt.repository;

import com.javamaster.springsecurityjwt.entity.CaseStatus;
import com.javamaster.springsecurityjwt.entity.CaseType;
import com.javamaster.springsecurityjwt.entity.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {

	boolean existsByNumber(String number);

	CriminalCase findByNumber(String number);

	List<CriminalCase> findByStatus(CaseStatus status);

	List<CriminalCase> findByType(CaseType type);

}
