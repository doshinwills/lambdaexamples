package com.doshin.lambda.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * For all the exercises, start with a List of Strings similar to this: • List
 * <String> words = Arrays.asList("hi", "hello", ...);
 * 
 * 1. Loop down the words and print each on a separate line, with two spaces in
 * front of each word. Don’t use map.
 * 
 * 2. Repeat the previous problem, but without the two spaces in front. This is
 * trivial if you use the same approach as in #1, so the point is to use a
 * method reference here, as opposed to an explicit lambda in problem 1.
 * 
 * 3. In the previous exercise, we produced transformed lists like this: • List
 * <String> excitingWords = StringUtils.transformedList(words, s -> s + "!"); •
 * List<String> eyeWords = StringUtils.transformedList(words, s ->
 * s.replace("i", "eye")); • List<String> upperCaseWords =
 * StringUtils.transformedList(words, String::toUpperCase); Produce the same
 * lists as above, but this time use streams and the builtin “map” method.
 * 
 * 4. In the previous exercise, we produced filtered lists like this: • List
 * <String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4); •
 * List<String> wordsWithB = StringUtils.allMatches(words, s ->
 * s.contains("b")); • List<String> evenLengthWords =
 * StringUtils.allMatches(words, s -> (s.length() % 2) == 0); Produce the same
 * lists as above, but this time use “filter”.
 * 
 * 5. Turn the strings into uppercase, keep only the ones that are shorter than
 * 4 characters, of what is remaining, keep only the ones that contain “E”, and
 * print the first result. Repeat the process, except checking for a “Q” instead
 * of an “E”. When checking for the “Q”, try to avoid repeating all the code
 * from when you checked for an “E”.
 * 
 * 6. The above example uses lazy evaluation, but it is not easy to see that it
 * is doing so. Make a variation of the above example that proves that it is
 * doing lazy evaluation. One way to do this is to track which entries are
 * turned into upper case.
 * 
 * 7. Take one of the previous examples where you produced a List, but this time
 * output the final result as an array instead of a List. This is super-easy
 * once you know how, and the class notes show this. But, the syntax looks very
 * odd when you first see it.
 * 
 * @author gwills
 *
 */
public class OneBasicStream {

	public static void main(String[] args) {

		String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };
		
		System.out.println();
		Arrays.stream(words).forEach(e -> System.out.println("  " + e));
		
		System.out.println();
		Arrays.stream(words).forEach(System.out::println);
		
		System.out.println();
		List<String> excitingWords = Arrays.stream(words).map(s -> s + "!").collect(Collectors.toList());
		System.out.println("excitingWords " + excitingWords);
		
		System.out.println();
		List<String> eyeWords = Arrays.stream(words).map(s -> s.replace("i", "eye"))
				.collect(Collectors.toList());
		System.out.println("excitingWords " + eyeWords);

		
		System.out.println();		
		List<String> upperWords = Arrays.stream(words).map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println("upperWords " + upperWords);

		
		System.out.println();
		List<String> longWords = Arrays.stream(words).filter(s -> s.length() < 4)
				.collect(Collectors.toList());
		System.out.println("longWords " + longWords);

		
		System.out.println();
		List<String> bWords = Arrays.stream(words).filter(s -> s.contains("b"))
				.collect(Collectors.toList());
		System.out.println("bWords " + bWords);

		System.out.println();
		List<String> evenLengthWords = Arrays.stream(words).filter(s -> s.length() %2 == 0)
				.collect(Collectors.toList());
		System.out.println("evenLengthWords " + evenLengthWords);

		
		
		System.out.println();
		System.out.println("firstFunnyString " + firstFunnyString(words, "E"));
		
		System.out.println();
		System.out.println("firstFunnyString " + firstFunnyString(words, "I"));		
		
		System.out.println();
		System.out.println("firstFunnyStringWithLazyProof " + firstFunnyStringWithLazyProof(words, "E"));
		
		System.out.println();
		System.out.println("firstFunnyStringWithLazyProof " + firstFunnyStringWithLazyProof(words, "I"));
		

	}
	
	  public static String firstFunnyString(String[] words,  String containedTest) {
		  return Arrays.stream(words).map(s -> s.toUpperCase()).
			filter(s -> s.length() < 4).filter(s -> s.contains(containedTest)).findFirst().orElse("");
	  }
	  
	  public static String firstFunnyStringWithLazyProof(String[] words,  String containedTest) {
		  return Arrays.stream(words).map(s -> {
			  System.out.println("Chnaging to Uppercase " + s);
			  return s.toUpperCase();			  
		  }).
			filter(s -> {
				 System.out.println("Checking string length less than 4 " + s);
				return s.length() < 4;
			}).filter(s -> {
				System.out.println("Checking string" + s + " have  " + containedTest);
				return s.contains(containedTest);
			}).findFirst().orElse("");
	  }

}
