package de.hawhamburg.ton.P02;

/**
 * @author Thorben Schomacker
 * @author Ferdinand Trendelenburg
 */

public class Operatoren {

	public static void main(String[] args) {
		System.out.println(decFracToBase(123.0, 2, 45));
		System.out.println(decFracToBase(123.45, 8, 45));
		System.out.println(decFracToBase(123.0, 16, 45));
		System.out.println(decFracToBase(123.45, 16, 45));
		System.out.println(decFracToBase(123.0, 32, 45));
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
		int prePoint;
		String baseDecPlace = "";
		
		while (count != accuracy && decPlace > 0) {
			prePoint = (int) (decPlace * (double) base);
			if (base > 10 && prePoint > 10){
				baseDecPlace = baseDecPlace + (prePoint + 55);
			}else {
				baseDecPlace = baseDecPlace + prePoint;
				}
			decPlace = decPlace * (double) base - prePoint;
			
			count++;
		}
		return baseDecPlace;
		
	}
	
	public static String decIntToBase(int decimalInteger, int base){
		String baseInt = ""; 
		while (decimalInteger > 0){
			if (base > 10 && (decimalInteger % base) > 10){
				baseInt = (char) ((decimalInteger % base) + 55) + baseInt;
			}else {
				baseInt = (decimalInteger % base) + baseInt;}
			decimalInteger = decimalInteger / base;
		}
		return baseInt;
	}

}
