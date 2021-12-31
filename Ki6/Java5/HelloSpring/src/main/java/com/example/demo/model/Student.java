package com.example.demo.model;

import lombok.Data;

@Data
public class Student {
private String name;
private Integer masv;
public Student (Integer masv,String name){
	this.masv = masv;
	this.name=name;
}
public Student() {}
public Integer getMa() {
	// TODO Auto-generated method stub
	return null;
}
public Object get(int i) {
	// TODO Auto-generated method stub
	return null;
}
}
