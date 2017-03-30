package de.hawhamburg.ton.P02;

public class Operatoren {

	public static void main(String[] args) {
		System.out.println(decFracToBase(123.0, 2, 45));
		System.out.println(decFracToBase(123.45, 8, 45));

	}
	
	//accuracy - defines how many decimal places you want to convert. A recommandable value is 45.
	public static String decFracToBase(double decimalFraction, int base, int accuracy){ 
		int vorKomma = (int) decimalFraction;
		double nachKomma = decimalFraction - vorKomma;
		if (nachKomma == 0.0){
			return decIntToBase(vorKomma, base);
		} else {
			return (decIntToBase(vorKomma, base) + "." + decPlaceToBase(nachKomma, base, accuracy) 
			+ "   - Präzise bis zur " + accuracy + ". Stelle nach dem Komma");
		}
	}
	
	public static String decPlaceToBase(double decPlace, int base, int accuracy){
		int count = 0;
		int vorKomma;
		String baseDecPlace = "";
		
		while (count != accuracy && decPlace > 0) {
			vorKomma = (int) (decPlace * (double) base);
			baseDecPlace = baseDecPlace + vorKomma;
			decPlace = decPlace * (double) base - vorKomma;
			
			count++;
		}
		return baseDecPlace;
		
	}
	
	public static String decIntToBase(int decimalInteger, int base){
		String baseInt = ""; 
		while (decimalInteger > 0){
			baseInt = (decimalInteger % base) + baseInt;
			decimalInteger = decimalInteger / base;
		}
		return baseInt;
	}

}
