package com.learn.snippets.numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceOfNumberCount {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,2,3,1,3,1,2,1,4,2); 
		
		Object obj = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.print("Welcome Again: " + obj);
	}
}
