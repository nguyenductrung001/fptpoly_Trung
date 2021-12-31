package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
@RestController()
@RequestMapping("/student")
public class StudentRestController {
@GetMapping()
public List<Student> getAll(){
	return StudentService.getAll();
	
}
@GetMapping("/get")
public Student getByMa2(@RequestParam Integer masv) {
	return StudentService.getByMasv(masv);
}
@GetMapping("/{masv}")
public Student getByMa(@PathVariable Integer masv) {
	return StudentService.getByMasv(masv);
}
	
@PostMapping
public int add(@RequestBody Student student) {
	return StudentService.add(student);
}
@PutMapping
public int update (Student student) {
	return StudentService.updateByMasv(student);
}
public int delete(@PathVariable Integer id) {
	return StudentService.deleteByMa(id);
}
}
