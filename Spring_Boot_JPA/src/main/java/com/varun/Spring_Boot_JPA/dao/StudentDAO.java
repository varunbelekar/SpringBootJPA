package com.varun.Spring_Boot_JPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.varun.Spring_Boot_JPA.model.Student;

public interface StudentDAO extends JpaRepository<Student,Integer>{
	
}
