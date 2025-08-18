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

@Controller
public class LayoutViewController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home Page");
		model.addAttribute("message", "Welcome to the Management System, you will be able to manage the Courses, Students and Parents details");
		
		return "layout";
	}
	
	@GetMapping("/home")
	public String homes(Model model) {
		model.addAttribute("title", "Home Page");
		return "layout";
	}

}
