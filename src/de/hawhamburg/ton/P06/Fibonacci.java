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
import java.util.stream.Stream;



/**
 * @author Thorben
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		int startyear = 1900;
		
		ArrayList<Integer> fibonacciFolge = new ArrayList<Integer>();
		Stream.generate(Fibonacci::fibonacci).
		limit(25).
		forEach(n -> fibonacciFolge.add(n));
		
		System.out.println(fibonacciFolge);
		
		ArrayList<Integer> collatzFolge = new ArrayList<Integer>();
		Stream.generate(Fibonacci::collatz).
		limit(25).
		forEach(c -> collatzFolge.add(c));
		
		System.out.println(collatzFolge);
		
		ArrayList<LocalDate> fridaythirteen = new ArrayList<LocalDate>();
		Stream.iterate(LocalDate.of(startyear , 01, 13), date -> date.plusMonths(1)).
		limit(12* (2020-1970)).
		filter(date -> {return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);}).
		forEach(d -> fridaythirteen.add(d));
		
		System.out.println(fridaythirteen);
		
		ArrayList<Integer> weekend = new ArrayList<Integer>();
		Stream.iterate(LocalDate.of(startyear , 12, 24), date -> date.plusYears(1)).
		limit((2020-startyear)).
		filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY).
		forEach(d -> weekend.add(d.getYear()));
		
		System.out.println(weekend);
		System.out.println(difference(weekend));
		System.out.println(min(weekend));
		System.out.println(max(weekend));
		System.out.println(average(weekend));
		
		System.out.println(differenceLD(fridaythirteen));
		System.out.println(minLD(fridaythirteen));
		System.out.println(maxLD(fridaythirteen));
		System.out.println(averageLD(fridaythirteen));

	}

	static int n = 0;

	private static int fibonacci() {
		int x = 0, y = 1, z = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}

		n++;
		return x;
	}

	static int c = 1;

	private static int collatz() {
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
	
	private static int average(ArrayList<Integer> arrylist){
		ArrayList<Integer> difference = difference(arrylist);
		return difference.stream().mapToInt(Integer::intValue).sum() / difference.size();
	}
	
	private static ArrayList<Integer> difference(ArrayList<Integer> arry){
		ArrayList<Integer> difference = new ArrayList<Integer>();
		
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
	
	private static int averageLD(ArrayList<LocalDate> arrylist){
		ArrayList<Integer> difference = differenceLD(arrylist);
		return difference.stream().mapToInt(Integer::intValue).sum() / difference.size();
	}
	
	private static ArrayList<Integer> differenceLD(ArrayList<LocalDate> arry){
		ArrayList<Integer> difference = new ArrayList<Integer>();
		
		for(int i = 1; i < arry.size(); i++){
			Period temp = Period.between(arry.get(i-1), arry.get(i));
			difference.add(temp.getMonths());
		}
		return difference;
	}

}
