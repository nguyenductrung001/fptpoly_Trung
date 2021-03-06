package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
public class StudentController {
	@GetMapping("/gppd")
	public String getString() {
		return "get Trung-PH10309";
	}

	@PostMapping("/gppd")
	public String addString() {
		return "add Trung-PH10309";
	}

	@PutMapping("/gppd")
	public String updateString() {
		return "update Trung-PH10309";
	}

	@DeleteMapping("/gppd")
	public String deleteString() {
		return "delete Trung-PH10309";
	}

	@GetMapping("/pathvariable/{id}")
	public String get(@PathVariable String id) {
		return id;
	}

	@GetMapping("/{id}/pathvariable")
	public String get2(@PathVariable String id) {
		return id;
	}
	
	@GetMapping("/requestparam")
	// RequestParam  truyền vào nhiều tham số và trả về ? tên biến = tham số truyền vào
	public String get3(@RequestParam String name) {
		return name;
	}

}
