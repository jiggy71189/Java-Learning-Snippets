package com.learn.snippets.numbers;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestReducingFunction {
	
public static void main(String[] args) {
	Stream<Integer> s = Stream.of();
    Integer i = s.collect(Collectors.reducing((integer, integer2)
                        -> integer2 - integer))
                 .orElse(-1);

    System.out.println(i);
}

}
