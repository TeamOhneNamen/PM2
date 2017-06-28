/**
 * Fibonacci.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dates {

	public static void main(String[] args) {
		int startyear = 1900;

		ArrayList<LocalDate> fridaythirteen = Stream.iterate(LocalDate.of(1900, 01, 13), date -> date.plusMonths(1))
				.limit(12 * (2020 - 1970)).filter(date -> {
					return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
				}).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(fridaythirteen);

		ArrayList<LocalDate> weekend = Stream.iterate(LocalDate.of(startyear, 12, 24), date -> date.plusYears(1))
				.limit((2020 - startyear))
				.filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
				.collect(Collectors.toCollection(ArrayList::new));

		System.out.println(weekend);

	}
}
