/**
 * ChristianHolidays.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package diverse;

import java.time.LocalDate;

public class ChristianHolidays {
	public static LocalDate getEaster(int year) {
		
		int day;

		if (((19 * (year % 19) + ((15 + (year / 100) - ((8 * (year / 100) + 13) / 25) - ((year / 100) / 4)) % 30)) % 30)
				+ ((2 * (year % 4) + 4 * (year % 7)
						+ 6 * ((19 * (year % 19)
								+ ((15 + (year / 100) - ((8 * (year / 100) + 13) / 25) - ((year / 100) / 4)) % 30))
								% 30)
						+ ((4 + (year / 100) - ((year / 100) / 4)) % 7)) % 7) == 35)
			day = 50;
		else if (((19 * (year % 19) + ((15 + (year / 100) - ((8 * (year / 100) + 13) / 25) - ((year / 100) / 4)) % 30))
				% 30) == 28
				&& ((2 * (year % 4) + 4 * (year % 7)
						+ 6 * ((19 * (year % 19)
								+ ((15 + (year / 100) - ((8 * (year / 100) + 13) / 25) - ((year / 100) / 4)) % 30))
								% 30)
						+ ((4 + (year / 100) - ((year / 100) / 4)) % 7)) % 7) == 6
				&& (11 * ((15 + (year / 100) - ((8 * (year / 100) + 13) / 25) - ((year / 100) / 4)) % 30) + 11)
						% 30 < 19)
			day = 49;
		else
			day = 22
					+ ((19 * (year % 19)
							+ ((15 + (year / 100) - ((8 * (year / 100) + 13) / 25) - ((year / 100) / 4)) % 30)) % 30)
					+ ((2 * (year % 4) + 4 * (year % 7)
							+ 6 * ((19 * (year % 19)
									+ ((15 + (year / 100) - ((8 * (year / 100) + 13) / 25) - ((year / 100) / 4)) % 30))
									% 30)
							+ ((4 + (year / 100) - ((year / 100) / 4)) % 7)) % 7);
		if (day <= 31) {
			return LocalDate.parse(year + "-03-" + day);
		} else {
			if (day - 31 < 10) {
				return LocalDate.parse(year + "-04-" + "0" + (day - 31));
			} else {
				return LocalDate.parse(year + "-04-" + (day - 31));
			}
		}
		

	}
	
	public static LocalDate getAshWednesday (int year) {
		return getEaster(year).plusDays(-46);
	}

	public static void main(String[] argv) {
		System.out.println(getEaster(2031));
	}

}
