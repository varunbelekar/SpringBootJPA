package com.varun.Spring_Boot_JPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varun.Spring_Boot_JPA.dao.StudentDAO;
import com.varun.Spring_Boot_JPA.model.Student;



@Controller
public class StudentController {
	@Autowired
	StudentDAO student;
	
	@RequestMapping("/index")
	public String indexPage(){
		return "index";
	}
	
	@RequestMapping("/show")
	public String showForm(){
		return "studentForm";
	}
	
	@RequestMapping("/process")
	public String processForm(Student s){
		student.save(s);
		return "studentForm";
	}
	
	@RequestMapping("/view")
	public String viewStudent(Model model){
		List<Student> list=student.findAll();
		model.addAttribute("studentList",list);
		return "viewStudent";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id){
		student.deleteById(id);
		return "redirect:/view";
	}
	
	@RequestMapping("/update/{id}")
	public String updateStudent(@PathVariable int id){
		return "";
	}
}
