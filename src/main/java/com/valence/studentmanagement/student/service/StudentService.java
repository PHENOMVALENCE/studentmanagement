package com.valence.studentmanagement.student.service;

import java.util.List;
import java.util.Optional;

import com.valence.studentmanagement.student.model.Student;

public interface StudentService {
	
	List<Student> list();
	Optional<Student> select(String username);
	boolean update(Student entity);
	boolean create(Student entity);
    boolean deleteById(Integer id);
	
}
