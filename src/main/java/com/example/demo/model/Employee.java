package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//@MappedSuperclass
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//CREATES ONE TABLE FOR ALL TYPES OF EMPLOYEE, best performance
@DiscriminatorColumn(name = "EmployeeType")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//CREATES TABLES FOR EACH TYPE OF EMPLOYEE
@Inheritance(strategy = InheritanceType.JOINED)//CREATES MULTIPLE TABLES, BEST DESIGN best data integrity
public abstract class Employee {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String name;

	protected Employee() {
	}

	public Employee(String name) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
