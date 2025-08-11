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

import com.valence.studentmanagement.course.model.Course;


public interface CourseService {
	

	Optional<Course> list();
	Optional<Course> select(Long id);
	boolean create(Course entity);
	boolean update(Course entity);
	boolean delete(Long id);


}
