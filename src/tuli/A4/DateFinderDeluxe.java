package tuli.A4;

/**
 * @author Marcel Tuleweit, Laura Westfalen
 * 
 * A class which counts the occurrence of a given day of week at a given date over an amount of years.
 * 
 */

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateFinderDeluxe {
	
	public static void main(String[] args) {
		// getWeekdays(first year, last year, month -1, day, day of week)
        getWeekdays(1889, 2100, 5, 1, 1);
    }
	
	public static int getWeekdays(int y, int ly, int m, int d, int wd) {
		LocalDate cal = LocalDate.of(y, m, d);
		String weekday = new String();
        int count = 0;
        int fy = y;
        
		while(cal.getYear() < ly){
			if(cal.getDayOfWeek().getValue() == wd){
				weekday = cal.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CANADA);
				System.out.println(weekday + ", " + cal);
				count+=1;
			}
			cal = cal.plusYears(1);
		}
		System.out.println("\nThe number of " + weekday.toLowerCase() + "s at date " + d + "." + m + ". from " + fy +" to " + ly + " is " + count + " days");
		return count;
	}
	
}