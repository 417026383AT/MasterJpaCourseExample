package com.example.demo.api.v1;

import java.math.BigDecimal;
import java.util.List;
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
import com.example.demo.model.Employee;
import com.example.demo.model.FullTimeEmployee;
import com.example.demo.model.PartTimeEmployee;
import com.example.demo.model.Employee;
import com.example.demo.service.CourseService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public Employee fillWithMockEmployee() {
		PartTimeEmployee e = new PartTimeEmployee("Test", new BigDecimal("5"));
		return employeeService.save(e);

	}

	@GetMapping("/{employeeId}")
	public Employee getById(@PathVariable String employeeId) {
		Optional<Employee> e = employeeService.findByI(employeeId);
		if (e.isPresent())
			return e.get();
		else
			throw new RuntimeException("Employee with id: " + employeeId + " was not found.");
	}

	@GetMapping("delete/{employeeId}")
	public void deleteById(@PathVariable String employeeId) {
		Optional<Employee> stud = employeeService.findByI(employeeId);
		if (stud.isPresent())
			employeeService.deleteById(employeeId);
		else
			throw new RuntimeException("Employee with id: " + employeeId + " was not found.");
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee registerEmployee(@RequestBody Employee e) {
		return employeeService.save(e);
	}

	@GetMapping("All")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@PostMapping(value = "/PartTimeEmployees/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartTimeEmployee registerPartTimeEmployee(@RequestBody PartTimeEmployee e) {
		e.setHourlyWage(e.getHourlyWage());
		return employeeService.savePartTimeEmployee(e);
	}

	@PostMapping(value = "/FullTimeEmployees/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public FullTimeEmployee registerFullTimeEmployee(@RequestBody FullTimeEmployee e) {
		return employeeService.saveFullTimeEmployee(e);
	}
}
