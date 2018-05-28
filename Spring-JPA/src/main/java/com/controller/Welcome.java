package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {

	@RequestMapping("/welcome")
	public String hello() {
		return "hello";
	}
	
}
