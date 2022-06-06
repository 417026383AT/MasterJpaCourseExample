package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Passport {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String number;

	@OneToOne(mappedBy = "passport")
	private Student student;

	protected Passport() {
	}

	public Passport(String number) {
		this.number = number;
	}

	public String getName() {
		return number;
	}

	public void setName(String number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
