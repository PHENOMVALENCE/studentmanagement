/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 11, 2025
 */

package com.valence.studentmanagement.course.service;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valence.studentmanagement.course.model.Course;
import com.valence.studentmanagement.course.repository.CourseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor

public class CourseServiceImpl  implements CourseService{
	private final CourseRepository courseservice;

	@Override
	public Optional<Course> list() {
		try {
			return courseservice.findById(null);
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Course> select(Long id) {
		try {
			return courseservice.findById(id);
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return Optional.empty();
		}
	}

	@Override
	public boolean create(Course entity) {
		try {
			 courseservice.save(entity);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

	@Override
	public boolean update(Course entity) {
		try {
			 courseservice.save(entity);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		try {
			 courseservice.deleteById(id);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}
	}




