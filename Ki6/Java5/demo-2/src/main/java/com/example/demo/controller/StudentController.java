package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/student")

public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/get")
	public List<Student> get() {
		return studentRepository.findAll();
	}
	@PutMapping()
	public String update() {
		return"Update";
	}
	@DeleteMapping("/delete")
	public String delete() {
		return"Delete";
	}
	@PostMapping("/add")
	public String add() {
		return"add";
	}
}
