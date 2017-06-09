package com.doshin.lambda.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Random;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * 1. Make a very large array of random doubles, each of wh ich ranges from 0 to
 * 1. A quick and easy way to do this is with “new
 * Random().doubles(size).toArray()”.
 * 
 * 2. Compute the sum of the square ro ots of the numbers in the array. Find a
 * shorter and simpler way than making a loop to tally the sum. Hint: review the
 * notes on number-speci alized streams, espe- cially the fact that you make a
 * DoubleStream fro m a double[] with DoubleStream.of, not Stream.of.
 * 
 * 3. Repeat the process in parallel. Once you have #2 working, this should be
 * very simple.
 * 
 * 4. Verify that you get the “same” answer with the pa rallel approach as with
 * the sequential approach. Why do I have “same” in quote s in the previous
 * sentence?
 * 
 * 5. Test whether the parallel approach is faster than the sequential approach.
 * Doing the timing is a little bit tedious, but if you think it simplifies
 * things, you can steal th e Op interface from streams-3-exer- cises project,
 * then do something like this: Op.timeOp(() -> { double sum =
 * MathUtils.sqrtSumParallel(nums); System.out.printf("  Sum is %,.8f.%n", sum);
 * });
 * 
 * 6. Make an “infinite” stream that generates random doubles between 0 and 10.
 * Use it to • Print 5 random doubles • Make a List of 10 random doubles • Make
 * an array of 20 random doubles Note: in general, if you are dealing with
 * numbers, DoubleStream is preferred over Stream<Double> because DoubleStream
 * uses pr imitives and has more convenient methods (e.g., min, max, sum,
 * average). In this case, however, us e Stream<Double> because it is hard to
 * turn a DoubleStream into a List and becau se it is hard to print a double[]
 * but easy to print a Double[] (e.g., pass the array to Arrays.asList and print
 * the resultant List). So, for this part of the exercises, use Stream.generate,
 * not DoubleStream.generate
 * 
 * @author gwills
 *
 */
public class ThreeBasicStream {

	public static void main(String[] args) {
		double[] ds = randomArray(10000000);

		System.out.println(sumOfSqRt(ds));

		System.out.println(sumOfSqRtPar(ds));

		Op.timeOp(() -> {
			double d = sumOfSqRt(ds);
			System.out.println("Seq oputput " + d);
		});

		Op.timeOp(() -> {
			double d = sumOfSqRtPar(ds);
			System.out.println("Par oputput " + d);
		});
		
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
		List<Double> doubles = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
		System.out.println(doubles);
		
		Double[] doublesArr = Stream.generate(Math::random).limit(20).toArray(Double[]::new);
		System.out.println(Arrays.toString(doublesArr));
	}

	public static double[] randomArray(long size) {
		return new Random().doubles(size).toArray();
	}

	public static double sumOfSqRt(double[] ds) {
		return DoubleStream.of(ds).map(Math::sqrt).sum();
	}

	public static double sumOfSqRtPar(double[] ds) {
		return DoubleStream.of(ds).parallel().map(Math::sqrt).sum();
	}

}

@FunctionalInterface
interface Op {
	void runOp();

	static void timeOp(Op op) {
		long startTime = System.nanoTime();
		op.runOp();
		long endTime = System.nanoTime();
		double oneBillion = 1_000_000_000;
		double elapsedTime = (endTime - startTime) / oneBillion;
		System.out.printf("  Elapsed time: %.3f seconds.%n", elapsedTime);
	}
}
