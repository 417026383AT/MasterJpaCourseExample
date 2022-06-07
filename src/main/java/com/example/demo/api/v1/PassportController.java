package com.example.demo.api.v1;

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
import com.example.demo.model.Passport;
import com.example.demo.model.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.PassportService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value = "Passports")
public class PassportController {

	@Autowired
	private PassportService passportService;

	@GetMapping("/{passportId}")
	public Passport getById(@PathVariable String passportId) {
		Optional<Passport> pass = passportService.findByI(passportId);
		if (pass.isPresent())
			return pass.get();
		else
			throw new RuntimeException("Passport with id: " + passportId + " was not found.");
	}

	@GetMapping("delete/{passId}")
	public void deleteById(@PathVariable String passId) {
		Optional<Passport> pass = passportService.findByI(passId);
		if (pass.isPresent())
			passportService.deleteById(passId);
		else
			throw new RuntimeException("Passport with id: " + passId + " was not found.");
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Passport register(@RequestBody Passport p) {
		return passportService.save(p);
	}

	@GetMapping("All")
	public List<Passport> getAll() {
		return passportService.getAll();
	}
}
