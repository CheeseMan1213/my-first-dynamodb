package com.james2ch9developer.my_first_dynamodb.rest_controller;

import com.james2ch9developer.my_first_dynamodb.entity.Student;
import com.james2ch9developer.my_first_dynamodb.exceptions.ResourceNotFoundException;
import com.james2ch9developer.my_first_dynamodb.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@CrossOrigin
	@GetMapping(value = "getAllStudents", produces = "application/json")
	public Iterable<Student> getAllStudents() {
		return this.repository.findAll();
	}

	@GetMapping("/getStudent/{studentId}")
	public Optional<Student> findStudent(@PathVariable String studentId) {
		return repository.findById(studentId);
	}

	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		return repository.save(student);
	}

	@PutMapping("/editStudent")
	public Student updateStudent(@RequestBody Student student) {
		return repository.save(student);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") final String studentId) throws ResourceNotFoundException {
		final Student student = repository.findById(studentId)
		  .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id ::" + studentId));

		repository.delete(student);
		final Map<String, Boolean> response = new ConcurrentHashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
