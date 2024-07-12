package com.nitrkl.cse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nitrkl.cse.entity.Student;
import com.nitrkl.cse.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller
{
	@Autowired
	private StudentService studentService;
		
	@GetMapping("/students")
	public String getAllStudents(Model model)
	{
		model.addAttribute("students",studentService.getAllStudents());
		return "students"; //view
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		//to hold the student object
		Student student = new Student();
		model.addAttribute("student",student);
		return "create-student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model)
	{
		model.addAttribute("student",studentService.getById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student") Student student)
	{
		Student existingStudent = studentService.getById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.saveStudent(existingStudent);
		
		return "redirect:/students";
		
	}
	
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id)
	{
		studentService.deleteById(id);
		return "redirect:/students";
	}
}
