package de.hawhamburg.ton.P02;

public class Operatoren {

	public static double pi = Math.PI;
	public static double e = Math.E;

	public static void main(String[] args) {

		System.out.println(longInBinaer(pi));
		System.out.println(longInBinaer(e));

	}
	private static String longInBinaer(double eingang) {

		
		
		String ergebniss = "";

		int vorKomma = (int) eingang;
		double nachKomma = eingang - vorKomma;
		
		while (vorKomma != 0.0) {
			if (vorKomma % 2 == 1.0) {
				ergebniss = ("1" + ergebniss);
				
			} else if (vorKomma % 2 == 0.0) {
				ergebniss = ("0" + ergebniss);
			}
			vorKomma = vorKomma / 2;

		}
		
		ergebniss = ergebniss+".";
		int zaehler = 0;
		
		while (nachKomma != 0.0 && zaehler!=45) {
		
			if(zaehler==44)
			
				return(ergebniss + "   - Nach dem Komma ist diese Zahl nicht korrekt darstellbar!");
				
			else if (nachKomma * 2 >= 1.0) {
				ergebniss = (ergebniss+"1");
				nachKomma = nachKomma * 2 -1;
				
				
			} else if (nachKomma * 2 < 1.0) {
				ergebniss = (ergebniss+"0");
				nachKomma = nachKomma * 2;
			}
			
			zaehler++;
		}
		
		
		return ergebniss;

	}

}
