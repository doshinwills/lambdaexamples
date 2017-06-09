package com.doshin.lambda.lambdaexamples.parthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TwoStringFunction {

	public static void main(String[] args) {
		
		String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };

		System.out.println(StringFUtils.applyFunction(Arrays.asList(words), (t1) -> t1 + "!"));
		System.out.println(StringFUtils.applyFunction(Arrays.asList(words), (t1) -> t1.replace("i", "[eye]")));
		System.out.println(StringFUtils.applyFunction(Arrays.asList(words), String::toUpperCase));

	}

}

class StringFUtils {
	public static List<String> applyFunction(List<String> words, Function<String, String> function) {
		List<String> rArr = new ArrayList<String>();
		for (String st : words) {
			rArr.add(function.apply(st));
		}
		return rArr;
	}
}
