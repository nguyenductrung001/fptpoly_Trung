package com.example.demo.model;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class Book {
private Integer id;
private String name;
private Integer quantity;
private BigDecimal price;
public Book (Integer id,String name,Integer quantity,BigDecimal price) {
	this.id = id;
	this.name=name;
	this.price = price;
	this.quantity = quantity;
}
public Book() {}
public Integer getId() {
	// TODO Auto-generated method stub
	return null;
}
public Book get(int i) {
	// TODO Auto-generated method stub
	return null;
}
}
