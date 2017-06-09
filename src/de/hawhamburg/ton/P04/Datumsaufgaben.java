/**
 * Datumsaufgaben.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 * 
 * Checks in which year 01.05.xxxx was a monday.
 */
package de.hawhamburg.ton.P04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Datumsaufgaben {
	
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		int year = 1889;
		while (year < 2100){
		String input ="01/05/" + year;
		LocalDate date = LocalDate.parse(input, formatter);
		// Extracts a `DayOfWeek` enum object.
		DayOfWeek dow = date.getDayOfWeek();  
		// String = Tue
		String output = dow.getDisplayName(TextStyle.SHORT, Locale.US); 
		if (output.contains("Mon")) {System.out.println(year);};
		year++;
		}
		
		
	}


}
