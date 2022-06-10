package com.example.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Course;
import com.example.demo.model.Student;

@Transactional
public interface CourseRepo extends JpaRepository<Course, String> {

	@Query("SELECT c FROM Course c WHERE size(c.students)  <= 0")
	Collection<Course> findAllCoursesWithoutStudents();

}
