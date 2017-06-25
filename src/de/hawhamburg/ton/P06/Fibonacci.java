/**
 * Fibonacci.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;



/**
 * @author Thorben
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		int startyear = 1900;
		int progressionLimit = 25;
		
		ArrayList<Integer> fibonacciFolge = 
		Stream.iterate(1, i->i+1).limit(progressionLimit).map(f -> fibonacci(f)).collect(Collectors.toCollection(ArrayList::new));
//		System.out.println(fibonacciFolge);
		
		ArrayList<Integer> collatzFolge =
		Stream.iterate(1, i->i+1).limit(progressionLimit).map(f -> collatz(f)).collect(Collectors.toCollection(ArrayList::new));		
//		System.out.println(collatzFolge);
		
		ArrayList<LocalDate> fridaythirteen =
		Stream.iterate(LocalDate.of(1900 , 01, 13), date -> date.plusMonths(1)).
		limit(12* (2020-1970)).
		filter(date -> {return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);}).
		collect(Collectors.toCollection(ArrayList::new));
		
//		System.out.println(fridaythirteen);
		
		ArrayList<LocalDate> weekend =
		Stream.iterate(LocalDate.of(startyear , 12, 24), date -> date.plusYears(1)).
		limit((2020-startyear)).
		filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY).
		collect(Collectors.toCollection(ArrayList::new)); 
		
		System.out.println(weekend);
//		System.out.println(difference(weekend));
//		System.out.println(min(weekend));
//		System.out.println(max(weekend));
//		System.out.println(averageLD(weekend));
		
//		System.out.println(differenceLD(fridaythirteen));
//		System.out.println(minLD(fridaythirteen));
//		System.out.println(maxLD(fridaythirteen));
//		System.out.println(averageLD(fridaythirteen));

	}

	private static int fibonacci(int n) {
		int x = 0, y = 1, z = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}
		return x;
	}
	
	private static int collatz(int c) {
		if(c == 0){
			c = 0;
		}else if (c % 2 == 0) {
			c = c / 2;
		} else {
			c = 3 * c + 1;
		}

		return c;
	}
	
	private static int min(ArrayList<Integer> arrylist){
		ArrayList<Integer> difference = difference(arrylist);
		Collections.sort(difference);
		return difference.get(0);
	}
	
	private static int max(ArrayList<Integer> arrylist){
		ArrayList<Integer> difference = difference(arrylist);
		Collections.sort(difference);
		return difference.get(difference.size()-1);
	}
	
	private static double average(ArrayList<Integer> arrylist){
		ArrayList<Integer> difference = difference(arrylist);
		return difference.stream().mapToInt(Integer::intValue).average().getAsDouble();
	}
	
	private static ArrayList<Integer> difference(ArrayList<Integer> arry){
		ArrayList<Integer> difference = new ArrayList<Integer>();
//		arry.stream().mapToInt(i, e -> triangularNumberIterative(i));
		for(int i = 1; i < arry.size(); i++){
			int temp = arry.get(i) - arry.get(i-1);
			difference.add(temp);
		}
		return difference;
	}
	
	private static int minLD(ArrayList<LocalDate> arrylist){
		ArrayList<Integer> difference = differenceLD(arrylist);
		Collections.sort(difference);
		return difference.get(0);
	}
	
	private static int maxLD(ArrayList<LocalDate> arrylist){
		ArrayList<Integer> difference = differenceLD(arrylist);
		Collections.sort(difference);
		return difference.get(difference.size()-1);
	}
	
	private static Period averageLD(ArrayList<LocalDate> arrylist){
		return Period.between(arrylist.stream().max((e1, e2) -> e1.compareTo(e2)).get(), arrylist.stream().min((e1, e2) -> e1.compareTo(e2)).get());
//		ArrayList<Integer> difference = differenceLD(arrylist);
//		return difference.stream().mapToInt(Integer::intValue).average().getAsDouble();
	}
	
//	private static void averageLD(ArrayList<LocalDate> arrylist){
//		 arrylist.stream().map((e1, e2) -> Period.between(e1, e2) );
////		ArrayList<Integer> difference = differenceLD(arrylist);
////		return difference.stream().mapToInt(Integer::intValue).average().getAsDouble();
//	}
	
	private static ArrayList<Integer> differenceLD(ArrayList<LocalDate> arry){
		ArrayList<Integer> difference = new ArrayList<Integer>();
		System.out.println(arry.stream().max((e1, e2) -> e1.compareTo(e2)));
		System.out.println(arry.stream().min((e1, e2) -> e1.compareTo(e2)));
		for(int i = 1; i < arry.size(); i++){
			Period temp = Period.between(arry.get(i-1), arry.get(i));
			difference.add(temp.getMonths());
		}
		return difference;
	}

}
