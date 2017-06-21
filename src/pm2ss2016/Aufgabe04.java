/**
 * Aufgabe04.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2ss2016;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import List;

public class Aufgabe04 {

	public static void main(String[] args) {
		int startjahr 	= 2000;
		int endjahr 	= 2100;
		
		ArrayList<LocalDate> heilige_jahre = new ArrayList<LocalDate>();
		Stream.iterate(LocalDate.of(2000, 07, 25), heiliges_jahr -> heiliges_jahr.plusYears(1))
			.limit(endjahr-startjahr)
			.filter(heiliges_jahr ->{
	            	return heiliges_jahr.getDayOfWeek().equals(DayOfWeek.MONDAY);
	     })
		.forEach(h -> heilige_jahre.add(h));
		
		LocalDate kleinstesjahr =    
			heilige_jahre.stream()
//				.map(EmployeeSamples::findGoogler)               
				.min((e1, e2) -> e1.compareTo(e2) )              
				.get();
		
		LocalDate summe =    
				heilige_jahre.stream()
//					.map(EmployeeSamples::findGoogler)               
					.min((e1, e2) -> e1.compareTo(e2) )              
					.get();
		
		ArrayList<Integer> heilige_jahre_spanne;
				heilige_jahre.stream()             
//				.filter((LocalDate e1, LocalDate e2) ->{
//	            	return ((Integer)((Long)ChronoUnit.DAYS.between(e1, e2)).intValue());})
				.forEach((LocalDate e1,LocalDate e2) ->
            	heilige_jahre_spanne.add(((Integer)((Long)ChronoUnit.DAYS.between(e1, e2)).intValue())));
		
		
		System.out.println(heilige_jahre);
		System.out.println(kleinstesjahr);
		System.out.println(averageDays(heilige_jahre));

	}
	
	private static long averageDays(ArrayList<LocalDate> arry){
		long difference = 0;
		for(int i = 1; i < arry.size(); i++){
			difference += (ChronoUnit.DAYS.between(arry.get(i-1), arry.get(i)));
		}
		return difference;
	}
	
	private static ArrayList<Integer> differenceLD(ArrayList<LocalDate> arry){
		ArrayList<Integer> difference = new ArrayList<Integer>();
		
		for(int i = 1; i < arry.size(); i++){
			difference.add(((Long)ChronoUnit.DAYS.between(arry.get(i-1), arry.get(i))).intValue());
		}
		return difference;
	}
	
	
	

}
