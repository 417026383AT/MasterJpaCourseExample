package com.example.demo.api.v1;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping(value = "Courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/All")
	public List<Course> getAll() {
		return courseService.getAll();
	}

	@GetMapping("/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		Optional<Course> course = courseService.findByI(courseId);
		if (course.isPresent())
			return course.get();
		else
			throw new RuntimeException("Course with id: " + courseId + " was not found.");
	}

	@GetMapping("delete/{courseId}")
	public void deleteById(@PathVariable String courseId) {
		Optional<Course> course = courseService.findByI(courseId);
		if (course.isPresent())
			courseService.deleteById(courseId);
		else
			throw new RuntimeException("Course with id: " + courseId + " was not found.");
	}

	@GetMapping("Empty")
	public List<Course> getEmptyCourses() {
		return courseService.getAllEmptyCourses();
	}

}
