///*
// *  Author            : Salum Sinare
// *  Author id         : A243345
// *  Author email      : salum.sinare@stanbic.co.tz
// *  Organization      : Stanbic Bank Tanzania LTD
// *  Organization Unit : Software Engineering
// *  Copyright (C) 2025
// *  Created on Aug 07, 2025
// */
//
//package com.valence.studentmanagement.config;
//
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.valence.studentmanagement.student.model.Student;
//import com.valence.studentmanagement.student.service.StudentService;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class CustomCommandRunner implements CommandLineRunner {
//	private final StudentService studentService;
//
//	@Override
//	public void run(String... args) throws Exception {
//		log.info("# Argument count : " + args.length);
//		log.info("# Argument list");
//		for (String a : args) {
//			log.info(a);
//		}
//
//		int count = args.length;
//		if (count < 1) {
//			log.info("No operation detected !");
//		} else {
//			String operation = args[0];
//			switch (operation) {
//			case "list": {
//				List<Student> list = studentService.list();
//				log.info("# student list : {}",list);
//				break;
//			}
//			case "select": {
//				log.info("select operation");
//				String option = args[1];
//				String[] optionKeyValue = option.split("=");
//				String optionKey = optionKeyValue[0];
//				String optionValue = optionKeyValue[1];
//				if (optionKey.equalsIgnoreCase("username")) {
//					log.info("OptionKey : " + optionKey);
//					log.info("OptionValue : " + optionValue);
//				} else {
//					log.info("select operation neeeds username");
//				}
//				break;
//			}
//			case "create": {
//				log.info("create operation");
//				break;
//			}
//			case "delete": {
//				String option = args[1];
//				String[] optionKeyValue = option.split("=");
//				String optionKey = optionKeyValue[0];
//				String optionValue = optionKeyValue[1];
//				boolean res=false;
//				if (optionKey.equalsIgnoreCase("username")) {
//					res=studentService.delete(optionValue);
//				} else {
//					log.info("select operation neeeds username");
//				}
//				log.info("# student deleted : {}",res);
//				break;
//			}
//			case "update": {
//				log.info("update operation");
//				break;
//			}
//			}
//		}
//
//	}
//
//}
