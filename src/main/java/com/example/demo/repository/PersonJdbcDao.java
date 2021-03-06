package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper(Person.class));

	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));

	}
}
