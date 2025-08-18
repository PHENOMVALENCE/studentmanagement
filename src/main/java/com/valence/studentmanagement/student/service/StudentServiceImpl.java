/**
  * @ Author: Valence Mwigani
  * @ Role: Full Stack Dev
  * @ Create Time: 2025-08-18 19:04:44
  * @ Modified by: Valence Mwigani
  * @ Modified time: 2025-08-18 21:34:11
  * @ Description:
  */



package com.valence.studentmanagement.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.valence.studentmanagement.student.model.Student;
import com.valence.studentmanagement.student.repository.StudentRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	private final StudentRepository studentRepository;
	
	
	@Override
	public List<Student> list() {
		try {
			return studentRepository.findAll();
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Student> select(String username) {
		try {
			return studentRepository.findByUsername(username);
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return Optional.empty();
		}
	}

	@Override
	public boolean create(Student student) {
		try {
			studentRepository.save(student);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

	@Override
	public boolean update(Student entity) {
		try {
			studentRepository.save(entity);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

	@Override
	public boolean deleteById(Integer id) {
		try {
			studentRepository.deleteById(id);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

}
