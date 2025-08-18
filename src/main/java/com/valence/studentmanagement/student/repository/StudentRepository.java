/**
  * @ Author: Valence Mwigani
  * @ Role: Full Stack Dev
  * @ Create Time: 2025-08-18 19:04:44
  * @ Modified by: Valence Mwigani
  * @ Modified time: 2025-08-18 21:35:30
  * @ Description:
  */

package com.valence.studentmanagement.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valence.studentmanagement.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Optional<Student> findByUsername(String username);
	
	
	void deleteById(Integer id);
}
