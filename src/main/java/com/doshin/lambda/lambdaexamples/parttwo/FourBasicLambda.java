package com.doshin.lambda.lambdaexamples.parttwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourBasicLambda {
	public static void main(String[] args) {
		double result = method1(1, 2, Math::cos);
		System.out.println(result);

		String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };
		Arrays.asList(words).forEach(System.out::println);

		result = method2(5, 2, Math::pow);
		System.out.println(result);
		
		Integer[] ints = {1, 2, 3, 4, 5}; 
		result = Arrays.asList(ints).stream().reduce(0, Integer::sum);
		System.out.println(result);

	}

	private static double method1(int i, int j, DoubleFunction object) {
		return object.cos(i) + object.cos(j);
	}

	private static double method2(int d1, int d2, PowerFunction object) {
		return object.power(d1, d2);
	}
	


}

interface DoubleFunction {
	public double cos(double angle);
}

interface PowerFunction {
	public double power(double d1, double d2);
}
