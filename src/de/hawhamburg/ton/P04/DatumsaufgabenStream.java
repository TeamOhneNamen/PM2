/**
 * DatumsaufgabenStream.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import de.hawhamburg.ton.P06.Fibonacci;


public class DatumsaufgabenStream {
	public static void main(String[] args){
		Stream.iterate((int x)− > x + 1).
		limit(25).
		forEach(if(actualdate.getDayOfWeek() == DayOfWeek.MONDAY){
			allYears.add(actualdate.getYear());});
		
		
		ArrayList<Integer> allYears = new ArrayList<Integer>();
		for(LocalDate actualdate = LocalDate.of(1889 , 05, 01); actualdate.getYear() < 2100; actualdate = actualdate.plusYears(1)){
			if(actualdate.getDayOfWeek() == DayOfWeek.MONDAY){
			allYears.add(actualdate.getYear());}
		}
	System.out.println(allYears);
	}

}
