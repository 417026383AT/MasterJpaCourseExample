package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;

	public List<Review> getAll() {
		return reviewRepo.findAll();
	}

	public Review saveReview(Review r) {
		return reviewRepo.save(r);
	}

	public Review findById(String reviewId) {
		Optional<Review> r = reviewRepo.findById(reviewId);
		if (r.isPresent())
			return r.get();
		else
			throw new RuntimeException("Review with id: " + reviewId + "  not found.");
	}
}
