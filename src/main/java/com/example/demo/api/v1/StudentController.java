package com.example.demo.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value = "Student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/{studentId}")
	public Student getById(@PathVariable String studentId) {
		Optional<Student> stud = studentService.findByI(studentId);
		if (stud.isPresent())
			return stud.get();
		else
			throw new RuntimeException("Student with id: " + studentId + " was not found.");
	}

	@GetMapping("delete/{studentId}")
	public void deleteById(@PathVariable String studentId) {
		Optional<Student> stud = studentService.findByI(studentId);
		if (stud.isPresent())
			studentService.deleteById(studentId);
		else
			throw new RuntimeException("Student with id: " + studentId + " was not found.");
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student register(@RequestBody Student s) {
		return studentService.save(s);
	}

}
