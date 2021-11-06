package com.learn.snippets.stream.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeTestIMPL {
	
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
	
		list.add(new Employee(101, "Jignesh", 101, "active", 5000));
		list.add(new Employee(102, "Jayesh", 101, "inactive", 1000));
		list.add(new Employee(103, "Bharat", 102, "inactive", 6000));
		list.add(new Employee(104, "Yogesh", 102, "active", 8000));
		list.add(new Employee(105, "Ketan", 103, "active", 4000));
		list.add(new Employee(106, "Teju", 103, "inactive", 500));
		list.add(new Employee(107, "Vishal", 104, "active", 6500));
	
		Map<Integer, List<Employee>> deptEmpl = list.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));
		deptEmpl.entrySet().forEach(ent->System.out.println(ent.getKey() + " "+ ent.getValue()));;
	
		Map<Integer, Long> deptEmplCount = list.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
		deptEmplCount.entrySet().forEach(ent ->System.out.println(ent.getKey() + " " + ent.getValue()));

		list.stream().filter(e-> "active".equals(e.getStatus())).forEach(System.out::println);
		System.out.println();
		
		list.stream().filter(e-> "inactive".equals(e.getStatus())).forEach(System.out::println);
		
		Optional<Employee> maxSalary = list.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println("\nMax Salary: " + maxSalary.get());
		
		Optional<Employee> minSalary = list.stream().min(Comparator.comparing(Employee::getSalary));
		System.out.println("\nMin Salary: " + minSalary.get());
		
		System.out.println();
		
		 Map<Integer, Optional<Employee>> result = list.stream().collect(Collectors.groupingBy(Employee::getDeptId, 
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		
		 result.entrySet().forEach(e->System.out.println(e.getKey() + " " + e.getValue()));
		
		
	}
	

}
