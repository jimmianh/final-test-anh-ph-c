package com.javamaster.springsecurityjwt.controller;

import com.javamaster.springsecurityjwt.entity.Detective;
import com.javamaster.springsecurityjwt.service.IDetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/detective")
@Validated
public class DetectiveController {

	@Autowired
	private IDetectiveService detecService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDetectiveByID(@PathVariable(name = "id") Long id) {

		return new ResponseEntity<Detective>(detecService.getDetectiveById(id), HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<?> createDetective(@RequestBody @Valid Detective detective) {

		return ResponseEntity.ok(detecService.createDetective(detective));
	}

	@PutMapping()
	public ResponseEntity<?> updateDetective(@RequestBody @Valid Detective detective) {

		return ResponseEntity.ok(detecService.updateDetective(detective));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDetective(@PathVariable(name = "id") Long id) {

		detecService.deleteDetectiveById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
