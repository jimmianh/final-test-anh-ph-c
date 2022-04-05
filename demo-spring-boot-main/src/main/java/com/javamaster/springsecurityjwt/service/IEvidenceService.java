package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.dto.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.CaseType;
import com.javamaster.springsecurityjwt.entity.Evidence;

import java.util.List;

public interface IEvidenceService {

	Evidence getEvidenceById(Long Id);

	ResponseDTO createEvidence(Evidence evidence);

	ResponseDTO updateEvidence(Evidence evidence);

	void deleteEvidenceById(Long Id);

	List<Evidence> findByEvidencesType(CaseType type);

}
