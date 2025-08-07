/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 07, 2025
 */

package com.valence.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.valence.studentmanagement.model.Student;
import com.valence.studentmanagement.repository.StudentRepository;

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
	public boolean create(Student entity) {
		try {
			studentRepository.save(entity);
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
	public boolean delete(String username) {
		try {
			studentRepository.deleteByUsername(username);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

}
