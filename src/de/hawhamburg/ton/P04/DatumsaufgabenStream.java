/**
 * DatumsaufgabenStream.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;


public class DatumsaufgabenStream {
	public static void main(String[] args){
		ArrayList<Integer> allYears = new ArrayList<Integer>();
		for(LocalDate actualdate = LocalDate.of(1889 , 05, 01); actualdate.getYear() < 2100; actualdate = actualdate.plusYears(1)){
			if(actualdate.getDayOfWeek() == DayOfWeek.MONDAY){
			allYears.add(actualdate.getYear());}
		}
	System.out.println(allYears);
	}

}
