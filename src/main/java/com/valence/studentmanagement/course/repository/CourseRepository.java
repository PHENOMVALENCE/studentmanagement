/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 11, 2025
 */

package com.valence.studentmanagement.course.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valence.studentmanagement.course.model.Course;



public interface CourseRepository extends JpaRepository<Course, Long> {
	Optional<Course> findById(Long id);

	void deleteById(Long id);

	

	
	

}
