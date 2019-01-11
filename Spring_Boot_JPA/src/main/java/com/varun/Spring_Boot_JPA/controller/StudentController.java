package com.varun.Spring_Boot_JPA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		System.out.println("inside view");
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
	public String updateStudent(@PathVariable int id,Model model){
		model.addAttribute("udpateId", id);
		return "updateStudent";		
	}
	
	@RequestMapping("/update/updateStud")
	public String updateStud(Student s,HttpServletRequest request){
		student.updateStudent(s.getName(), s.getTech(),s.getId());
		System.out.println(s.getId()+" "+s.getName()+" "+s.getTech());
		return "redirect:/view";
	}
	
	@RequestMapping("/loginPage")
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String checkLogin(@RequestParam String name,@RequestParam String password,Model model){
		Student s=student.checkLogin(name, password);
		System.out.println("temp");
		if(s!=null){
			model.addAttribute("loggedInUser",s.getName());
		}
		if(s==null){
			return "redirect:/view";
		}
		
		
		return "loginSuccess";
	}
}
