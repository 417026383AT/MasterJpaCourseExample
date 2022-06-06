package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Course {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String name;

	@OneToMany(targetEntity = Review.class, mappedBy = "course", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonManagedReference
	private List<Review> reviews;

	@ManyToMany
	private List<Student> students;

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudent(Student student) {
		this.students.add(student);
	}

	public void setReviews(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

}
