/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 12, 2025
 */

package com.valence.studentmanagement.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/sample")
	public String index(Model model) {
		 model.addAttribute("title", "Sample Home Page Title");
		 model.addAttribute("name", "Samoebody");
		 model.addAttribute("studentInput", new StudentInput());
		return "list";
	}
	
	@PostMapping("/sample")
	public String post(Model model,@ModelAttribute("studentInput") StudentInput studentInput,
			RedirectAttributes ra) {
		log.info("# Data received from frontend : {}",studentInput);
		ra.addFlashAttribute("alert","Form was submitted "+studentInput);
		return "redirect:/sample";
	}
	
	@Data
	public static class StudentInput{
		private String name;
		private int age;
	}
}
