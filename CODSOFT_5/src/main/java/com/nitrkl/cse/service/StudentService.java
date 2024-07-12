package com.nitrkl.cse.service;

import java.util.List;

import com.nitrkl.cse.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student saveStudent(Student student);
	
	public Student getById(int id);
	
	public void deleteById(int id);
}
