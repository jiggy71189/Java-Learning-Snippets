package com.learn.snippets.numbers;

public class SwapTwoNumber {
	
	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		System.out.println(i +" " + j);
		i = i + j - (j=i);
		System.out.println("After Swap: "+ i +" " + j);
	}

}
