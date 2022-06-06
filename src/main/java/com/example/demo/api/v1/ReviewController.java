package com.example.demo.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;

@RestController
@RequestMapping(value = "Review", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping(value = "All")
	public List<Review> getAllReviews() {
		return reviewService.getAll();
	}

	@GetMapping("/{reviewId}")
	public Review getAllReviews(@PathVariable String reviewId) {
		return reviewService.findById(reviewId);
	}

	@PostMapping("register")
	public Review publishReview(Review r) {
		return reviewService.saveReview(r);
	}

}
