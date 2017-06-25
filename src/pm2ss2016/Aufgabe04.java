/**
 * Aufgabe04.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2ss2016;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Aufgabe04 {

	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		
		int startjahr 	= 2000;
		int endjahr 	= 2100;
		
		ArrayList<LocalDate> heilige_jahre =
		Stream.iterate(LocalDate.of(2000, 07, 25), heiliges_jahr -> heiliges_jahr.plusYears(1))
			.limit(endjahr-startjahr)
			.filter(heiliges_jahr ->{
	            	return heiliges_jahr.getDayOfWeek().equals(DayOfWeek.MONDAY);})
		.collect(Collectors.toCollection(ArrayList::new)); 
		
		System.out.println(heilige_jahre);
		System.out.println(averageDays(heilige_jahre));

	}
	
	
	private static long averageDays(ArrayList<LocalDate> list){
		LocalDate min =    
				list.stream()             
					.min((e1, e2) -> e1.compareTo(e2) )
					.get();
		LocalDate max =    
				list.stream()             
					.max((e1, e2) -> e1.compareTo(e2) )
					.get();
		
		long difference = (ChronoUnit.DAYS.between(min, max));
		return difference / list.size();
	}
	

}
