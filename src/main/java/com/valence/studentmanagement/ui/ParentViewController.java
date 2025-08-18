package com.valence.studentmanagement.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParentViewController {
	
	@GetMapping("/parent")
	
public String home(Model model) {
		model.addAttribute("title1", "Parent Management System");
		
		return "parent/index";
	}
	
	
	
}

