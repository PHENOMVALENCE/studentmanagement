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
public class TestViewController {

	@GetMapping("/dev")
	public String home(Model model) {
		model.addAttribute("title", "DASHBOARD TESTER");
		return "test";
	}
	
}
