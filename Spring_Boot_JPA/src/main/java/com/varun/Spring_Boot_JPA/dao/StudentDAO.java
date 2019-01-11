package com.varun.Spring_Boot_JPA.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.varun.Spring_Boot_JPA.model.Student;

public interface StudentDAO extends JpaRepository<Student,Integer>{
	
	@Transactional
	@Modifying
	@Query("update Student  set name=?1,tech=?2 where id=?3")
	public void updateStudent(String name,String tech,int id);
	
	
	@Query("from Student where name=?1 and password=?2")
	public Student checkLogin(String name,String pass);
}
