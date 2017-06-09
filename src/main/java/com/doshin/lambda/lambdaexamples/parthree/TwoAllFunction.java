package com.doshin.lambda.lambdaexamples.parthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TwoAllFunction {

	public static void main(String[] args) {
		
		String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };

		System.out.println(StringFFUtils.applyFunction(Arrays.asList(words), (t1) -> t1 + "!"));

		System.out.println(StringFFUtils.applyFunction(Arrays.asList(words), (t1) -> t1.length()));

	}

}

class StringFFUtils {
	public static<T, R> List<R> applyFunction(List<T> words, Function<T, R> function) {
		List<R> rArr = new ArrayList<R>();
		for (T st : words) {
			rArr.add(function.apply(st));
		}
		return rArr;
	}
}
