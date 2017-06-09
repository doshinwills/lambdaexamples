package com.doshin.lambda.lambdaexamples.partone;

import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * Problem 1 is easy. Once you get used to lambda synta x, the first three
 * pieces of problem 1 can be solved in one line each. Problems 2 and 3 are
 * hard; significantly more so than mo st of the exercise problems. It will take
 * some time re-reading the problems just to understand what I am asking for,
 * much less to do it. Notes on the sorting problems: • The compare method of
 * Comparator should return a negative number if the first entry is “less” than
 * the second, a positive number if the first entr y is “greater” than the
 * second, and 0 if they are the same. For details, see http://docs.oracle.co
 * m/javase/8/docs/api/java /util/Comparator.html. • To print out an array after
 * sorting, do System.out.println(Arrays.asList(yourArray)) The point of this is
 * that if you just print an array directly , you do not see anything useful
 * (just the memory address), but if you print a List, it show s the individual
 * elements separated by commas. So, the above trick is simp ler than making a
 * loop to traverse the array and print out the elements. Note for future
 * reference that this trick only work s if yourArray is an Object array (e.g.,
 * String[] or Integer[]); this trick fails if yourArra y is an array of
 * primitives (e.g., int[]).
 * 
 * 
 * 1. Basic lambdas. Make an array containing a few Strings. Sort it by • length
 * (i.e., shortest to longest) (Hint: this exact solution was shown in the
 * lecture) • reverse length (i.e., longest to shortest) (Hint: minor variation
 * of the first bullet) • alphabetically by the first character only (Hint:
 * charAt(0) returns the numeric code for the first character) • Strings that
 * contain “e” first, everything else s econd. For now, put the code directly in
 * the lambda. (Hint: remember that the body of a lambda is allowed to have
 * curly braces and a return state- ment. See the first two lam bda examples in
 * the notes.) • Redo the previous problem, but use a static he lper method so
 * that your lambda looks like this: Arrays.sort(words, (s1,s2) ->
 * Utils.yourMethod(s1,s2))
 * 
 * @author gwills
 *
 */
public class OneBasicLambda {

	public static void main(String[] args) {

		String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };
		
		Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
		System.out.println(Arrays.asList(words));
		
		Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
		System.out.println(Arrays.asList(words));
		
		Arrays.sort(words, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
		System.out.println(Arrays.asList(words));

		Arrays.sort(words, (s1, s2) -> {
			if (s1.indexOf("e") == -1 && s2.indexOf("e") == -1)
				return 0;
			else if (s1.indexOf("e") == -1)
				return 1;
			else if (s2.indexOf("e") == -1)
				return -1;
			else
				return s1.indexOf("e") - s2.indexOf("e");

		});
		System.out.println(Arrays.asList(words));
		
		//Changing to method referance
		Arrays.sort(words, Utils::compMeth);
		System.out.println(Arrays.asList(words));

	}

}

class Utils {
	public static int compMeth(String s1, String s2) {
		if (s1.indexOf("e") == -1 && s2.indexOf("e") == -1)
			return 0;
		else if (s1.indexOf("e") == -1)
			return 1;
		else if (s2.indexOf("e") == -1)
			return -1;
		else
			return s1.indexOf("e") - s2.indexOf("e");
	}
}
