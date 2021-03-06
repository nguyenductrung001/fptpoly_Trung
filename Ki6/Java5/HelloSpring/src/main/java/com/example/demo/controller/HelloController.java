package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class HelloController {
	@ResponseBody
	@RequestMapping("/hello/message")
	private String helloSpringMessage() {
		return "Nguyen Duc Trung-PH10309";
	}

	@RequestMapping("/hello/view")
	private String helloView() {
		return "hello";
	}
	//redirect 
	@RequestMapping("/hello/redirect")
	public String get() {
		return "redirect:/about.html";
	}
	//forward
	@RequestMapping("/hello/forward")
	public String get2() {
		return "forward:/about.html";
	}
}
