package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.DatabaseDemoApplication;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepo;

@SpringBootTest(classes = DatabaseDemoApplication.class)
class CourseServiceTest {

	@Autowired
	CourseService courseService;

	@Autowired
	CourseRepo courseRepo;

	@Test
	public void contextLoads() {
		Optional<Course> c = courseService.findByI("101");
		assertEquals("Jpa", c.get().getName());
	}

	@Test
	@DirtiesContext
	public void courseDeletionTest() {
		courseService.deleteById("101");
		assertEquals(Optional.empty(), courseRepo.findById("101"));

	}

}
