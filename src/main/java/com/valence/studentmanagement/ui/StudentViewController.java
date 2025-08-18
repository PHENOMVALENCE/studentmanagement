/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 13, 2025
 */

package com.valence.studentmanagement.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valence.studentmanagement.student.model.Student;
import com.valence.studentmanagement.student.service.StudentService;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Controller
public class StudentViewController {
	
	@Autowired
	private  final StudentService studentservice;
	
	@GetMapping("/student")
public String home(Model model) {
		studentservice.list();
		 model.addAttribute("title", "Student Management System Home Page ");
		 model.addAttribute("name", "Valence Mwigani");
         model.addAttribute("students", studentservice.list());
         model.addAttribute("student", new Student());
		return "student/list";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute ("student") Student student) {
		
		studentservice.create(student);
		return "redirect:/student";
	}
	
	}
