package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Passport;
import com.example.demo.model.Review;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.PassportRepo;
import com.example.demo.repository.ReviewRepo;

@Service
public class PassportService {

	@Autowired
	private PassportRepo passportRepo;

	public List<Passport> getAll() {
		return passportRepo.findAll();
	}

	public Optional<Passport> findByI(String id) {
		return passportRepo.findById(id);
	}

	@Transactional
	public Passport save(Passport p) {
		return passportRepo.save(p);
	}

	@Transactional
	public void deleteById(String id) {
		Optional<Passport> passport = passportRepo.findById(id);
		if (passport.isPresent()) {
			passportRepo.delete(passport.get());
		} else {
			throw new RuntimeException("Could not delete. Passport was not found.");
		}

	}

}
