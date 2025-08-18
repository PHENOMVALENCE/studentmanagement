/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 07, 2025
 */

package com.valence.studentmanagement.student.service;

import java.util.List;
import java.util.Optional;

import com.valence.studentmanagement.student.model.Student;

public interface StudentService {
	List<Student> list();
	Optional<Student> select(String username);
	boolean update(Student entity);
	boolean delete(String username);
	boolean create(Student entity);
}
