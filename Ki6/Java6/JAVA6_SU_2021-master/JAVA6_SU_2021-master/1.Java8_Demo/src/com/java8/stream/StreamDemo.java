package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamDemo {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(2, 1, 3, 7, 8, 4, 5); 
		
		OptionalDouble optional = list.stream()
			.filter(i -> i%2 ==0)
			.peek(System.out::println)
			.mapToDouble(i -> Math.sqrt(i))
			.average();
		System.out.println(optional.getAsDouble());
		
		System.out.println("Source: " + list);
			
	}

}
