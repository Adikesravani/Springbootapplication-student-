package com.javafullstack.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javafullstack.student.exception.ResourceNotFoundException;
import com.javafullstack.student.model.Proffessor;
import com.javafullstack.student.model.Student;
import com.javafullstack.student.repository.ProffessorRepository;
import com.javafullstack.student.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2")
public class ProffessorController {

	@Autowired
	private ProffessorRepository proRepository;

	// get all proffessors
	@GetMapping("/proffessors")
	public List<Proffessor> getAllProffessor() {
		return proRepository.findAll();
	}

	// create proffessors rest api
	@PostMapping("/proffessors")
	public Proffessor createProffessor(@RequestBody Proffessor proffessors) {
		return proRepository.save(proffessors);
	}
	// create proffessors rest api
		@PostMapping("/proffessorslist")
		public List<Proffessor> createProffessor(@RequestBody List<Proffessor> proffessors) {
			return proRepository.saveAll(proffessors);
		}


	// get proffessors by id rest api
	@GetMapping("/proffessors/{pId}")
	public ResponseEntity<Proffessor> getProffessorById(@PathVariable Long pId) {
		Proffessor proffessors = proRepository.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("proffessors not exist with id :" + pId));
		return ResponseEntity.ok(proffessors);
	}

	// update proffessors rest api

	@PutMapping("/proffessors/{pId}")
	public ResponseEntity<Proffessor> updateProffessor(@PathVariable Long pId, @RequestBody Proffessor proffessorDetails) {
		Proffessor proffessors = proRepository.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("proffessors not exist with id :" +pId));

//Proffessor.setProName(proffessorDetails.getProName());
//		Proffessor.setProSub(proffessorDetails.getProSub());
//          Proffessor.setpId(proffessorDetails.getpId());

		Proffessor updatedProffessor = proRepository.save(proffessors);
		return ResponseEntity.ok(updatedProffessor);
	}

	// delete student rest api
	@DeleteMapping("/proffessor/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long pId) {
		Proffessor proffessor = proRepository.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("proffessor not exist with id :" + pId));

		proRepository.delete(proffessor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
