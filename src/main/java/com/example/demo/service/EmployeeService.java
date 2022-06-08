package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.FullTimeEmployee;
import com.example.demo.model.PartTimeEmployee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	public Optional<Employee> findByI(String id) {
		return employeeRepo.findById(id);
	}

	@Transactional
	public Employee save(Employee e) {
		return employeeRepo.save(e);
	}

	@Transactional
	public Employee save(PartTimeEmployee e) {
		return employeeRepo.save(e);
	}

	@Transactional
	public Employee save(FullTimeEmployee e) {
		return employeeRepo.save(e);
	}

	@Transactional
	public PartTimeEmployee savePartTimeEmployee(PartTimeEmployee e) {
		return employeeRepo.save(e);
	}

	@Transactional
	public FullTimeEmployee saveFullTimeEmployee(FullTimeEmployee e) {
		return employeeRepo.save(e);
	}

	@Transactional
	public void deleteById(String id) {
		Optional<Employee> e = employeeRepo.findById(id);
		if (e.isPresent()) {
			employeeRepo.delete(e.get());
		} else {
			throw new RuntimeException("Could not delete. Employee was not found.");
		}

	}
}
