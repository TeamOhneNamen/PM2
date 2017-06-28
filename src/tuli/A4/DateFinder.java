package tuli.A4;

/**
 * @author Marcel Tuleweit, Laura Westfalen
 * 
 * Eine Klasse zur Z�hlung von Wochentagen �ber mehrere Jahre an einem festgelegten Datum.
 * 
 */
import java.text.DateFormat;
import java.util.Calendar;

public class DateFinder {
//	public static int getDay(int y, int m, int d) {
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, y);
//		cal.set(Calendar.MONTH, m);
//		cal.set(Calendar.DATE, d);
//		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
//
//		// the following output is just for validation
//		System.out.println(df.format(cal.getTime()));
//		return cal.get(Calendar.DAY_OF_WEEK);
//	}

	public static void main(String[] args) {
		// getWeekdays(first year, last year, month -1, day, day of week)
		// months are zero based, so january = 0, february = 1, and so on..
		// day of week starts with sunday = 1, monday = 2, and so on..

		getWeekdays(1889, 2100, 4, 1, 2);
	}

	public static int getWeekdays(int y, int ly, int m, int d, int wd) {
		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		int count = 0;
		int fy = y; // first year

		while (y < ly) {
			cal.set(Calendar.YEAR, y);
			cal.set(Calendar.MONTH, m);
			cal.set(Calendar.DATE, d);
			if (cal.get(Calendar.DAY_OF_WEEK) == wd) {
				System.out.println(df.format(cal.getTime()));
				count += 1;
			}
			y += 1;
		}
		System.out.println("\nDie Anzahl der gesuchten Wochentage am " + d + "." + (m + 1) + ". von " + fy + " bis "
				+ ly + " umfasst " + count + " Tage");
		return count;
	}
}
