/**
 * DatumsaufgabenStream.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 * 
 * return all 01.05.'s from 1889 to 2100, which where on a monday.
 * 
 */
package de.hawhamburg.ton.P04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

public class DatumsaufgabenStream {
	public static void main(String[] args){
	    Stream.iterate(LocalDate.of(1889 , 05, 01), actualdate  ->  actualdate.plusYears(1))
	            .limit(2100 - 1889)
	            .filter(actualdate -> {
	            	return actualdate.getDayOfWeek().equals(DayOfWeek.MONDAY);
	            })
	            .forEach(System.out::println);
	}

}
