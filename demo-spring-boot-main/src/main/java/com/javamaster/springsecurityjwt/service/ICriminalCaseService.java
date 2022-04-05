package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.entity.CaseStatus;
import com.javamaster.springsecurityjwt.entity.CriminalCase;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ICriminalCaseService {

	List<CriminalCase> getAllCriminalCases();

	CriminalCase getCriminalCaseById(Long Id);

//	CriminalCase createCriminalCase(CriminalCase criminalCase);

	String updateCriminalCase(CriminalCase criminalCase);

	void deleteCriminalCaseById(Long Id);

	String createCriminalCase(CriminalCase CriminalCase);

	List<CriminalCase> findByStatus(CaseStatus status);
	
	

}
