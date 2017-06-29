/**
 * Lectures.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2tutorium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Lectures {

	public Lectures(String filename) throws IOException {
		this.data = load(filename);
	}

	List<List<String>> data;

	public List<List<String>> load(String filename) throws IOException {
		List<List<String>> result = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(filename))) {

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				result.add(Arrays.asList(line.split(":")));
			}
		}
		return result;
	}

	public Set<String> workaholics() {
		Set<String> temp = new HashSet<String>();
		for (List<String> e : data) {
			if (count(e.get(2)) >= 2) {
				temp.add(e.get(2));
			}
		}
		return temp;

	}

	private int count(String str) {
		int sum = 0;
		for (List<String> e : data) {
			if (e.contains(str)) {
				sum++;
			}
		}
		return sum;
	}

	public List<String> titles() {
		return data.stream().map(e -> e.get(1)).sorted((e1, e2) -> e1.compareTo(e2))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public Map<String, List<String>> groupToTitles() {
		return data.stream().collect(Collectors.groupingBy(item -> item.get(0),
				Collectors.mapping(item -> item.get(1), Collectors.toList())));
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

	public static void main(String[] args) throws IOException {
		Lectures l = new Lectures("bin/pm2tutorium/lectures.txt");
		System.out.println(l);
		System.out.println(l.titles());
		System.out.println(l.count("Klauck"));
		System.out.println(l.workaholics());
		System.out.println(l.groupToTitles());
	}

}
