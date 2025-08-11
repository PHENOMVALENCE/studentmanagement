/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 11, 2025
 */

package com.valence.studentmanagement.parent.controller;

import java.util.List;
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

import com.valence.studentmanagement.parent.model.Parent;
import com.valence.studentmanagement.parent.service.ParentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parent")
public class ParentController {
	private final ParentService service;
	
	@GetMapping("/list")
	ResponseEntity<List<Parent>> list() {
		List<Parent> res = service.list();
		if(!res.isEmpty()) {
			return ResponseEntity.ok(res);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/select/{email}")
	ResponseEntity<Parent> select(@PathVariable String email) {
		Optional<Parent> res = service.select(email);
		if(res.isPresent()) {
			return ResponseEntity.ok(res.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value = "/create",consumes = "application/json")
	ResponseEntity<Void> create(@RequestBody Parent entity) {
		boolean res = service.create(entity);
		if(res) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	 
	@PutMapping(value="/update",consumes = "application/json")
	ResponseEntity<Void> update(@RequestBody Parent entity) {
		boolean res = service.update(entity);
		if(res) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete/{email}")
	ResponseEntity<Void> delete(@PathVariable String email) {
		boolean res= service.delete(email);
		if(res) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
