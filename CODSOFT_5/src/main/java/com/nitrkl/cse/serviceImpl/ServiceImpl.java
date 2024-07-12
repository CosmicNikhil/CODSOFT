package com.nitrkl.cse.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitrkl.cse.entity.Student;
import com.nitrkl.cse.repository.StudentRepository;
import com.nitrkl.cse.service.StudentService;

@Service
public class ServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> list = studentRepository.findAll();
		return list;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}

}
