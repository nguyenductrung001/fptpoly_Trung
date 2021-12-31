package com.java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.Employee;

public class SumSalaryEmployee {

	public static void main(String[] args) {
		
		Employee employee3 = new Employee("Tung", 24, 24.5d);
		Employee employee4 = new Employee("Hung", 25, 25.5d);
		Employee employee5 = new Employee("Nam", 26, 26.5d);
		Employee employee1 = new Employee("Nhan", 22, 22.5d);
		Employee employee2 = new Employee("Tung", 23, 23.5d);
		List<Employee> list = Arrays.asList(employee4, employee5, employee2, employee1, employee3);
		
		// Tính tổng tiền mà phải trả nhân viên trong 1 tháng.
		double sumTotal = list
			.stream()
			.mapToDouble(e -> e.getSalary())
			.peek(System.out::println)
			.sum();
		
		// Lương trung bình trả cho nhân viên
		double avgSalary = list
				.stream()
				.mapToDouble(e -> e.getSalary())
				.peek(System.out::println)
				.average().getAsDouble();
		
		System.out.println("Tổng tiền trả nv: " + sumTotal);
		System.out.println("Trung bình lương toàn công ty: " + avgSalary);
	}
}
