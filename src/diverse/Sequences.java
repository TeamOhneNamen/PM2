/**
 * MathemathischeFolgen.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package diverse;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sequences {

	public static void main(String[] args) {
		int progressionLimit = 25;

		ArrayList<Integer> fibonacciFolge = Stream.iterate(1, i -> i + 1).limit(progressionLimit).map(f -> fibonacci(f))
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(fibonacciFolge);

		ArrayList<Integer> triangularNumberList = Stream.iterate(1, i -> i + 1).limit(20)
				.map(i -> triangularNumberIterative(i)).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(triangularNumberList);

		Stream<Integer> collatzStream = Stream.iterate(progressionLimit, (cn) -> {
			if ((cn & 1) == 0) {
				return cn >> 1;
			} else {
				return 3 * cn + 1;
			}
		});
		collatzStream.forEach(c -> {
			System.out.println(c);
			if (c == 1) {
				System.exit(0);
			} else {
			}
		});

	}

	static int triangularNumber(int i) {
		if (i == 1) {
			return 1;
		}
		return i + triangularNumber(i - 1);
	}

	static int triangularNumberIterative(int n) {
		int result = n;
		while (n > 0) {
			result += (n - 1);
			n--;
		}
		return result;
	}

	private static int fibonacci(int n) {
		int x = 0, y = 1, z = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}
		return x;
	}

}
