package com.doshin.lambda.lambdaexamples.parthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class OneAllPredicate {

	public static void main(String[] args) {

		String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };

		System.out.println(ElementUtils.allMatches(Arrays.asList(words), (st) -> st.length() > 4));

		List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
		System.out.println(ElementUtils.allMatches(nums, n -> n > 500));

	}

}

class ElementUtils {
	public static <T> List<T> allMatches(List<T> words, Predicate<T> predicate) {
		List<T> rArr = new ArrayList<T>();
		for (T st : words) {
			if (predicate.test(st))
				rArr.add(st);
		}

		return rArr;
	}
}
