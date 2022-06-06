package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;

@Transactional
public interface CourseRepo extends JpaRepository<Course, String> {

}
