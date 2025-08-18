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

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valence.studentmanagement.greeting.model.Greeting;

public class MessageViewController {

	@GetMapping("/message")
	public String message(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "message";
		
	}
	
	@PostMapping("/greeting")
	public String greeting(@ModelAttribute Greeting greeting, Model model) {
		model.addAttribute("greeting", greeting);
		return "message";
	}
}
