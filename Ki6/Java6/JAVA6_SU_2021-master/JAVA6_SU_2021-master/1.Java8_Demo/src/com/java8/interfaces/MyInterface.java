package com.java8.interfaces;

@FunctionalInterface
public interface MyInterface {
	
	void getName();

	default String getLastName() {
		return "Pham";
	}
	
	static String getFirstName() {
		return "Huy";
	}
	
}
