package com.doshin.lambda.lambdaexamples.parttwo;

import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * Making your own interfaces for which lambdas can be used. Your eventual goal
 * is to make a method called betterString that takes two Strings and a lambda
 * that says whether the first of the two is “better”. The method should return
 * that better String; i.e., if the function given by the lambda returns true,
 * the betterString method should return the first String, otherw ise
 * betterString should return the second String. Here are two examples of how
 * your code should work when it is finished (the first lambda example returns
 * whichever of st ring1 and string2 is longer, and the second lambda example
 * always returns string1). • String string1 = ...; • String string2 = ...; •
 * String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s
 * 1.length() > s2.length()); • String first = StringUtils.betterStrin
 * g(string1, string2, (s1, s2) -> true);
 * 
 * 
 * Accomplishing all of this requires you to do three things: • Define the
 * TwoStringPredicate interface. It will sp ecify a method that takes 2 strings
 * and returns a boolean. This interface is normal Java 7 code . • Define the
 * static method bett erString. That method will take 2 st rings and an instance
 * of your interface. It returns string1 if the method in interface returns
 * true, string2 otherwise. This method is normal Java 7 code. • Call
 * betterString. You can now use lambdas for the 3rd argument, as in the
 * examples above.
 * 
 * @author gwills
 *
 */
public class TwoBasicLambda {

	public static void main(String[] args) {
		String test1 = "Hello";
		String test2 = "Goodbye";
		String message = "Better of %s and %s based on %s is %s.%n";
		String result1 = StringUtils.betterString(test1, test2, (s1, s2) -> s1.length() > s2.length());
		System.out.printf(message, test1, test2, "length", result1);
		String result2 = StringUtils.betterString(test1, test2, (s1, s2) -> true);
		System.out.printf(message, test1, test2, "1st arg", result2);
	}

}

class StringUtils {
	public static String betterString(String s1, String s2, TwoStringPredicate betterString) {
		return betterString.betterString(s1, s2) ? s1 : s2;
	}
}

@FunctionalInterface
//Can see error is thrown when we add two interfaces
interface TwoStringPredicate {
	public boolean betterString(String s1, String s2);
	//public boolean betterString2(String s1, String s2);
}
