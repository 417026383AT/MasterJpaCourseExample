package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;
import com.example.demo.model.Passport;

@Transactional
public interface PassportRepo extends JpaRepository<Passport, String> {

}
