package com.javamaster.springsecurityjwt.controller;

import com.javamaster.springsecurityjwt.entity.Evidence;
import com.javamaster.springsecurityjwt.service.IEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/evidence")
@Validated
public class EvidenceController {

	@Autowired
	private IEvidenceService evidenceService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getEvidenceByID(@PathVariable(name = "id") Long id) {

		return new ResponseEntity<Evidence>(evidenceService.getEvidenceById(id), HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<?> createEvidence(@RequestBody @Valid Evidence evidence) {

		return ResponseEntity.ok(evidenceService.createEvidence(evidence));
	}

	@PutMapping()
	public ResponseEntity<?> updateEvidence(@RequestBody @Valid Evidence evidence) {

		return ResponseEntity.ok(evidenceService.updateEvidence(evidence));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteEvidence(@PathVariable(name = "id") Long id) {

		evidenceService.deleteEvidenceById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
