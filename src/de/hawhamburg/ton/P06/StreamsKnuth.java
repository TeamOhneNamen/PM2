/**
 * StreamsKnuth.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsKnuth {

	public static void main(String[] args) throws IOException {
		ArrayList<String> all_3_16 = new ArrayList<String>();
		String source = "src/de/hawhamburg/ton/P06/bible.txt";

		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(source))));) {
			all_3_16 = bufferedReader.lines().filter(str -> {
				return str.contains("3:16");
			}).collect(Collectors.toCollection(ArrayList::new));
		}

		String test = all_3_16.get(1);
		Map<Object, Long> wordQuantity = Arrays.stream(test.split(" "))
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		System.out.println(all_3_16);
		System.out.println(wordQuantity);
	}

}
