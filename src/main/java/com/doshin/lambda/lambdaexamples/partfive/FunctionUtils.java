package com.doshin.lambda.lambdaexamples.partfive;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionUtils {

	public static <T> Predicate<T> anyPassPredicate(Predicate<T>... predicates) {
		Predicate<T> result = e -> false;
		for (Predicate<T> p : predicates) {
			result = result.or(p);
		}
		return result;
	}

	public static <T> Predicate<T> allPassPredicate(Predicate<T>... predicates) {
		Predicate<T> result = e -> true;
		for (Predicate<T> p : predicates) {
			result = result.and(p);
		}
		return result;
	}

	@SafeVarargs
	public static <T> T firstAllMatch(Stream<T> stream, Predicate<T>... tests) {
		Predicate<T> predicate = allPassPredicate(tests);
		return stream.filter(predicate).findFirst().orElse(null);
	}

	@SafeVarargs
	public static <T> T firstAnyMatch(Stream<T> stream, Predicate<T>... tests) {
		Predicate<T> predicate = anyPassPredicate(tests);
		return stream.filter(predicate).findFirst().orElse(null);
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");

		String st = FunctionUtils.firstAllMatch(words.stream(), word -> word.contains("o"), word -> word.length() > 5);
		System.out.println(st);

		String st1 = FunctionUtils.firstAnyMatch(words.stream(), word -> word.contains("o"));
		System.out.println(st1);
	}

}
