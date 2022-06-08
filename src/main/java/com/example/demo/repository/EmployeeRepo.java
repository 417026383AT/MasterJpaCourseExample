package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;
import com.example.demo.model.Employee;
import com.example.demo.model.Student;

@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
