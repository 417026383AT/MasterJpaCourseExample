package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Review;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.ReviewRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;

	public List<Course> getAll() {
		return courseRepo.findAll();
	}

	public Optional<Course> findByI(String id) {
		return courseRepo.findById(id);
	}

	@Transactional
	public Course save(Course c) {
		return courseRepo.save(c);
	}

	@Transactional
	public void deleteById(String id) {
		Optional<Course> course = courseRepo.findById(id);
		if (course.isPresent()) {
			courseRepo.delete(course.get());
		} else {
			throw new RuntimeException("Could not delete. Course was not found.");
		}

	}

}
