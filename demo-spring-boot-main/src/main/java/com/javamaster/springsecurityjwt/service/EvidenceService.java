package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.dto.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.CaseType;
import com.javamaster.springsecurityjwt.entity.CriminalCase;
import com.javamaster.springsecurityjwt.entity.Evidence;
import com.javamaster.springsecurityjwt.repository.CriminalCaseRepository;
import com.javamaster.springsecurityjwt.repository.EvidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EvidenceService implements IEvidenceService {

	@Autowired
	private EvidenceRepository evidRepository;

	@Autowired
	private CriminalCaseRepository caseRepository;

	@Override
	public Evidence getEvidenceById(Long Id) {

		return evidRepository.findById(Id).get();
	}

	@Override
	public ResponseDTO createEvidence(Evidence evidence) {

		ResponseDTO respo = new ResponseDTO();
		String message = "Number đã tồn tại";
		if (evidRepository.existsByNumber(evidence.getNumber())) {
			respo.setCode("error");
			respo.setMassage(message);
			return respo;

		}
		Evidence evidence1 = evidRepository.save(evidence);
		respo.setCode("sucssesfully!");
		respo.setMassage("thành công");
		respo.setData(evidence1);

		return respo;
	}

	@Override
	public ResponseDTO updateEvidence(Evidence evidence) {
		ResponseDTO respo = new ResponseDTO();
		String message = "Id không tồn tại!";
		if (evidRepository.findById(evidence.getEvidenceId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage(message);
			return respo;

		}
		evidence.setNumber(evidence.getNumber());
		evidence.setItemName(evidence.getItemName());
		evidence.setNotes(evidence.getNotes());
		evidence.setArchived(evidence.getArchived());
		respo.setCode("sucssesfully");
		respo.setMassage("thành công!");
		respo.setData(evidRepository.save(evidence));

		return respo;
	}

	@Override
	public void deleteEvidenceById(Long Id) {

		evidRepository.deleteById(Id);
	}

	@Override
	public List<Evidence> findByEvidencesType(CaseType type) {
		List<CriminalCase> listCrimi = caseRepository.findByType(type);
		List<Evidence> listEvi1 = new ArrayList<>();
		for (CriminalCase criminalCase : listCrimi) {
			List<Evidence> listEvi = evidRepository.findByCriminalCase(criminalCase);
			listEvi1.addAll(listEvi1);
		}
		return listEvi1;
	}

}
