/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 07, 2025
 */

package com.valence.studentmanagement.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valence.studentmanagement.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Optional<Student> findByUsername(String username);
	
	
	void deleteByUsername(String username);
}
