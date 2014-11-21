package com.taters.bm.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * Title: TestController.java
 * </p>
 * <p>
 * Description:
 * 
 * </p>
 * <p>
 * Nov 18, 2010
 * </p>
 * 
 * @author RHOLLAND DRS Technologies Inc.
 * 
 * 
 */
@Controller
public class TestController {

	//Invoked at http://localhost:8080/TestBaristamaticSpring3Mvc/test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String main(Model model) {
		System.out.println("TestController>>main: called");
		Date today = new Date();
		model.addAttribute("today", today);
		return "welcome";
	}
}
