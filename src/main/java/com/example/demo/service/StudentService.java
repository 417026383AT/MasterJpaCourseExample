package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	public Optional<Student> findByI(String id) {
		return studentRepo.findById(id);
	}

	@Transactional
	public Student save(Student s) {
		return studentRepo.save(s);
	}

	@Transactional
	public void deleteById(String id) {
		Optional<Student> stud = studentRepo.findById(id);
		if (stud.isPresent()) {
			studentRepo.delete(stud.get());
		} else {
			throw new RuntimeException("Could not delete. Student was not found.");
		}

	}
}
