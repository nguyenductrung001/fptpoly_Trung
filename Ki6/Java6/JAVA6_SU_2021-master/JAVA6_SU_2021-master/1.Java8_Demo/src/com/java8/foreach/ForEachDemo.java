package com.java8.foreach;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.java8.Employee;

public class ForEachDemo {

	public static void main(String[] args) {
		
		Employee employee3 = new Employee("Tung", 24, 24.5d);
		Employee employee4 = new Employee("Hung", 25, 25.5d);
		Employee employee5 = new Employee("Nam", 26, 26.5d);
		Employee employee1 = new Employee("Nhan", 22, 22.5d);
		Employee employee2 = new Employee("Tung", 23, 23.5d);
		List<Employee> list = Arrays.asList(employee4, employee5, employee2, employee1, employee3);
		
		list.forEach(e -> {
//			String name = e.getName();
//			Integer age = e.getAge();
//			Double salary = e.getSalary();
//			System.out.println();
//			System.out.println(name);
//			System.out.println(age);
//			System.out.println(salary);
			System.out.println(e);
		});
		
		list.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});
		
		list.sort((o1, o2) -> {
			return o1.getSalary().compareTo(o1.getSalary());
		});
		
	}
}
