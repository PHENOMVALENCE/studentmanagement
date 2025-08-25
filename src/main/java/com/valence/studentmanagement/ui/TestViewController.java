/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 18, 2025
 */

package com.valence.studentmanagement.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.valence.studentmanagement.student.service.StudentService;

import lombok.Data;

@Data
@Controller
public class TestViewController {
	private final StudentService studentService;

	@GetMapping("/dev")
	public String home(Model model) {
		model.addAttribute("title", "DASHBOARD TESTER");
		model.addAttribute("students", "studentService.list()");
		model.addAttribute("student", "new Student()");
		return "dashboard";
	}

}
