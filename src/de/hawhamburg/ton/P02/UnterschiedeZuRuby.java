/* author: Thorben Schomacker
 * author: Ferdinand Trendelenburg
 * 
 * Diese Klasse ist eine Klasse, die zusammengew�rfelt ist mit den Aufgaben der Aufgabe 02
**/
package de.hawhamburg.ton.P02;

public class UnterschiedeZuRuby {

	public static int a1wert1 = -208374985;
	
	public static double wert4 = 1.0;
	
	public static String wort1 = "Wort";
	public static String wort2 = "Wort";
	public static String wort3 = wort2;
	public static String wort4 = wort2;
	
	public static UnterschiedeZuRuby uzr1 = new UnterschiedeZuRuby();
	public static UnterschiedeZuRuby uzr2 = new UnterschiedeZuRuby();
	
	
	//divmod -> array, % -> real
	public static void main(String[] args) {
		
		System.out.println("Aufgabe 1.1:");
		System.out.println("Ist "+ a1wert1+ " ungerade? - " + isOdd(-5));
		testeEqualsString();
		System.out.println("ErklÃ¤rung: Diese Methode funktioniert nur fÃ¼r werte, die im Integer-Bereich liegen");
		System.out.println("");
		System.out.println("Aufgabe 1.2:");
		System.out.println("Test mit Objekten: "+testeEqualsObjekt());
		System.out.println("Der Test mit Primitiven Datentypen wie zum besipel Integer ist nicht mÃ¶gleich.");
		System.out.println("ErklÃ¤rung: Es handelt sich um die methode, die in Ruby == genannt wird.");
		
		
		
	}
	
	
	//Diese Methode funktioniert nur fÃ¼r werte, die im Integer-Bereich liegen und positiv sind.
	private static boolean isOdd(int i) {
		
		return Math.abs(i % 2) == 1;
		
	}
	
	private static void testeEqualsString() {
		//reflexive
		System.out.println("wort1 ~ wort1 - " + wort1.equals(wort1));
		
		//symetric
		System.out.println("wort1 ~ wort2 => wort2 ~ wort1 " + (wort1.equals(wort2) && wort2.equals(wort1)));
		
		//transitive
		System.out.println("wort3 ~ wort2, wort4 ~ wort2 => wort3 ~ wort4? - " + (wort3.equals(wort2) && wort4.equals(wort2) && wort3.equals(wort4))); //fehlt noch was
		
	}
	
	private static boolean testeEqualsObjekt() {
	
		return(uzr1.equals(uzr2));
		
	}
	
}