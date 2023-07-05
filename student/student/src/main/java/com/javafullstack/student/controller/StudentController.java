package com.javafullstack.student.controller;
import com.javafullstack.student.model.Student.StudentDTOIntf;

import java.util.ArrayList;
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
import com.javafullstack.student.model.Student;
import com.javafullstack.student.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private StudentRepository stdRepository;

	// get all students
	@GetMapping("/students")
	public List<Student> getAllStudent() {
		return stdRepository.findAll();
	}

	// create students rest api
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student students) {
		return stdRepository.save(students);
	}

	// create All students rest api
	@PostMapping("/studentslist")
	public List<Student> createStudent(@RequestBody List<Student> students) {
ArrayList<Student> std=new ArrayList<>();
 for(int i=0;i<students.size();i++) {
	 Student s = students.get(i);
	 s.setTotal(s.getTelugu()+s.getHindi()+s.getEnglish()+s.getMaths()+s.getSocial()+s.getScience());
	 std.add(s);
 }
		
		
		return stdRepository.saveAll(students);
	}

	// get students by id rest api
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student students = stdRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		return ResponseEntity.ok(students);
	}
	@GetMapping("/studentsprodetails")
	public List<StudentDTOIntf> getStudentProDetails(int pid){
		List<StudentDTOIntf> sp=stdRepository.getStudentProDetails(pid);
		return sp;
	}
	// update students rest api

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		Student students = stdRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
   
		students.setStudent_name(studentDetails.getStudent_name());
		students.setTelugu(studentDetails.getTelugu());
		students.setHindi(studentDetails.getHindi());
		students.setMaths(studentDetails.getMaths());
		students.setScience(studentDetails.getScience());
		students.setEnglish(studentDetails.getEnglish());
		students.setSocial(studentDetails.getSocial());
		students.setTotal(students.getTelugu()+students.getHindi()+students.getMaths()+students.getScience()+
				students.getEnglish()+students.getSocial());
		  students.setProffessor(studentDetails.getProffessor());
		Student updatedStudent = stdRepository.save(students);
		return ResponseEntity.ok(updatedStudent);
	}

	// delete student rest api
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
		Student students = stdRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		stdRepository.delete(students);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
