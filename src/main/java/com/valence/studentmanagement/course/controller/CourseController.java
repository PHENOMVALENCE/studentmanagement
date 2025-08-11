/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 11, 2025
 */

package com.valence.studentmanagement.course.controller;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import com.valence.studentmanagement.course.model.Course;
import com.valence.studentmanagement.course.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/course")
@Tag(name = "CourseAPI", description = "Course details")

public class CourseController {
	private final CourseService service;


@GetMapping("/list")
ResponseEntity<Optional<Course>> list() {
	Optional<Course> res = service.list();
	if(!res.isEmpty()) {
		return ResponseEntity.ok(res);
	}else {
		return ResponseEntity.notFound().build();
	}
}
@GetMapping("/select/{id}")
ResponseEntity<Course> select(@PathVariable Long id) {
	Optional<Course> res = service.select(id);
	if(res.isPresent()) {
		return ResponseEntity.ok(res.get());
	}else {
		return ResponseEntity.notFound().build();
	}
}
@PostMapping(value = "/create",consumes = "application/json")
ResponseEntity<Void> create(@RequestBody Course entity) {
	boolean res = service.create(entity);
	if(res) {
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}else {
		return ResponseEntity.notFound().build();
	}
}
 
@PutMapping(value="/update",consumes = "application/json")
ResponseEntity<Void> update(@RequestBody Course entity) {
	boolean res = service.update(entity);
	if(res) {
		return ResponseEntity.ok().build();
	}else {
		return ResponseEntity.notFound().build();
	}
}

@DeleteMapping("/delete/{id}")
ResponseEntity<Void> delete(@PathVariable Long id) {
	boolean res= service.delete(id);
	if(res) {
		return ResponseEntity.ok().build();
	}else {
		return ResponseEntity.notFound().build();
	}
}

}
