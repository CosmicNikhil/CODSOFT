package com.nitrkl.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitrkl.cse.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
