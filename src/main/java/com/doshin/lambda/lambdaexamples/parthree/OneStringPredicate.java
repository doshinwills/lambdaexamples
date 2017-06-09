package com.doshin.lambda.lambdaexamples.parthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class OneStringPredicate {

	public static void main(String[] args) {
		
		String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };
		
		System.out.println(StringUtils.allMatches(Arrays.asList(words), (st) -> st.length() > 4));
		System.out.println(StringUtils.allMatches(Arrays.asList(words), (st) -> st.contains("e")));
		System.out.println(StringUtils.allMatches(Arrays.asList(words), (st) -> st.length() % 2 == 0));

	}

}

class StringUtils{
	public static List<String> allMatches(List<String> words, Predicate<String> predicate) {
		List<String> rArr = new ArrayList<String>();
		for(String st : words) {
			if(predicate.test(st)) rArr.add(st);
		}
		
		return rArr;
	}
}
