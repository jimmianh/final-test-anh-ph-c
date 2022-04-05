package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.entity.CaseStatus;
import com.javamaster.springsecurityjwt.entity.CriminalCase;
import com.javamaster.springsecurityjwt.repository.CriminalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CriminalCaseService implements ICriminalCaseService {

	@Autowired
	private CriminalCaseRepository caseRepository;

	@Override
	public List<CriminalCase> getAllCriminalCases() {

		return caseRepository.findAll();
	}

	@Override
	public CriminalCase getCriminalCaseById(Long Id) {

		return caseRepository.findById(Id).get();
	}

	@Override
	public String createCriminalCase(CriminalCase crimCase) {
		String message = "thất bại";
		if (caseRepository.existsByNumber(crimCase.getNumber())) {
			return message;
		} else {
			caseRepository.save(crimCase);
			return "thành công";
		}
	}

	@Override
	public String updateCriminalCase(CriminalCase criminalCase) {

		CriminalCase criminalCase1 = new CriminalCase();

		if (caseRepository.findById(criminalCase.getId()).equals(null)) {

			return "Id không tồn tại!";
		} else {
			criminalCase1.setNumber(criminalCase1.getNumber());
			criminalCase1.setDetailDescription(criminalCase1.getDetailDescription());
			criminalCase1.setNotes(criminalCase1.getNotes());
			criminalCase1.setShortDescription(criminalCase1.getShortDescription());
			criminalCase1.setStatus(criminalCase1.getStatus());
			criminalCase1.setType(criminalCase1.getType());
			caseRepository.save(criminalCase);
			return "Update thành công!";
		}
	}

	@Override
	public void deleteCriminalCaseById(Long Id) {

		caseRepository.deleteById(Id);
	}

	@Override
	public List<CriminalCase> findByStatus(CaseStatus status) {

		return caseRepository.findByStatus(status);
	}

}
