package com.doshin.lambda.lambdaexamples.parttwo;

import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * Making generically-typed interfaces for which lambdas can be used. Use
 * generics to replace your String-specific solutions to pr oblem 3 with
 * generically typed so lutions. That is, replace better- String with
 * betterEntry and TwoStringPredicate with TwoElementPredicate. Make sure your
 * previ- ous examples still work when you only change be tterString to
 * betterEleme nt. But, now you should also be able to supply two Cars and a Car
 * pred icate, two Employees and an Employee predicate, etc.
 * 
 * 
 * For example: • ElementUtils.betterElement(string1, string2, (s1, s2) ->
 * s1.length() > s2.length()) • ElementUtils.betterElement(car1, car2, (c 1, c2)
 * -> c1.getPrice() > c2.getPrice()) • ElementUtils.betterElement(employee1,
 * employee 2, (e1, e2) -> e1.getSalary() > e2.getSalary())
 * 
 * @author gwills
 *
 */
public class ThreeBasicLambda {

	public static void main(String[] args) {
		String test1 = "Hello";
		String test2 = "Goodbye";
		String message = "Better of %s and %s based on %s is %s.%n";
		String result3 = ElementUtils.betterElement(test1, test2, (s1, s2) -> s1.length() > s2.length());
		System.out.printf(message, test1, test2, "length", result3);
		String result4 = ElementUtils.betterElement(test1, test2, (s1, s2) -> true);
		System.out.printf(message, test1, test2, "1st arg", result4);
		int result5 = ElementUtils.betterElement(1, 2, (n1, n2) -> n1 > n2);
		System.out.printf(message, 1, 2, "numeric size", result5);
		int result6 = ElementUtils.betterElement('a', 'b', (n1, n2) -> n1 > n2);
		System.out.printf(message, 'a', 'b', "order", result6);
	}

}

class ElementUtils {
	public static <T> T betterElement(T t1, T t2, TwoElementPredicate<T> betterElement) {
		return betterElement.betterElement(t1, t2) ? t1 : t2;
	}
}

interface TwoElementPredicate<T> {
	public boolean betterElement(T s1, T s2);
}
