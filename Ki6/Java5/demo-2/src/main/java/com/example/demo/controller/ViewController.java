package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Controller
public class ViewController {

	@RequestMapping("/hello")
	public String Hello1() {
		return "index";
	}
	@RequestMapping("/a2")
	public String Hello11() {
		return "a2";
	}

}
