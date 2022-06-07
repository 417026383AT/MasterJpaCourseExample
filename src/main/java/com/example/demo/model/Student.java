package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String name;

	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "passport_id", referencedColumnName = "id")
	private Passport passport;

	@ManyToMany
	@JsonManagedReference
	@JoinTable(name = "courses_students", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> enrolledCourses;

	protected Student() {
	}

	public Student(String name) {
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourse(Course course) {
		this.enrolledCourses.add(course);
	}

	public Student(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

}
