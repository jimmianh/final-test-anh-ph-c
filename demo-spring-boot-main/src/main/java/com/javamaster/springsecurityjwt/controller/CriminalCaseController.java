package com.javamaster.springsecurityjwt.controller;

import com.javamaster.springsecurityjwt.entity.CaseStatus;
import com.javamaster.springsecurityjwt.entity.CriminalCase;
import com.javamaster.springsecurityjwt.service.ICriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping(value = "/criminalCase")
@Validated
public class CriminalCaseController {

	@Autowired
	ICriminalCaseService caseService;

	@GetMapping()
	public ResponseEntity<?> getAllCriminalCases() {
		return new ResponseEntity<>(caseService.getAllCriminalCases(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCriminalCaseByID(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<CriminalCase>(caseService.getCriminalCaseById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createCriminalCase(@RequestBody @Valid CriminalCase criminalCase) {

		return ResponseEntity.ok(caseService.createCriminalCase(criminalCase));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateCriminalCase(@RequestBody @Valid CriminalCase criminalCase) {
		return ResponseEntity.ok(caseService.updateCriminalCase(criminalCase));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCriminalCase(@PathVariable(name = "id") Long id) {
		caseService.deleteCriminalCaseById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@GetMapping(value = "/{status}")
	public ResponseEntity<?> getStatus(@PathVariable(name = "status") CaseStatus status) {
		return new ResponseEntity<>(caseService.findByStatus(status), HttpStatus.OK);
	}

}
