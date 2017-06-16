/**
 * Fibonacci.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author Thorben
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		ArrayList<Integer> fibonacciFolge = new ArrayList<Integer>();
		Stream.generate(Fibonacci::fibonacci).
		limit(25).
		forEach(n -> fibonacciFolge.add(n));
		
		ArrayList<Integer> collatzFolge = new ArrayList<Integer>();
		Stream.generate(Fibonacci::collatz).
		limit(25).
		forEach(c -> collatzFolge.add(c));
		
		System.out.println(fibonacciFolge);
		System.out.println(collatzFolge);

	}

	static int n = 0;

	private static int fibonacci() {
		int x = 0, y = 1, z = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}

		n++;
		return x;
	}

	static int c = 1;

	private static int collatz() {
		if(c == 0){
			c = 0;
		}else if (c % 2 == 0) {
			c = c / 2;
		} else {
			c = 3 * c + 1;
		}

		return c;
	}

}
