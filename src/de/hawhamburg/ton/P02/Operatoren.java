package de.hawhamburg.ton.P02;

public class Operatoren {

	public static void main(String[] args) {

		System.out.println(decFracToBin(Math.PI));
		System.out.println(decFracToBin(Math.E));
		System.out.println(decFracToBin(2.0));
		System.out.println(decFracToBin(2.1));
		System.out.println(decFracToBase(123.0, 2, 45));
		System.out.println(decFracToBase(123.45, 8, 45));

	}
	
	//accuracy - defines how many decimal places you want to convert. A recommandable value is 45.
	public static String decFracToBase(double decimalFraction, int base, int accuracy){ 
		int vorKomma = (int) decimalFraction;
		double nachKomma = decimalFraction - vorKomma;
		if (nachKomma == 0.0){
			return decIntToOct(vorKomma, base);
		} else {
			return (decIntToOct(vorKomma, base) + "." + decPlaceToBase(nachKomma, base, accuracy) 
			+ "   - Präzise bis zur " + accuracy + ". Stelle nach dem Komma");
		}
	}
	
	public static String decPlaceToBase(double decPlace, int base, int accuracy){
		int count = 0;
		int vorKomma;
		String octDecPlace = "";
		
		while (count != accuracy && decPlace > 0) {
			vorKomma = (int) (decPlace * (double) base);
			octDecPlace = octDecPlace + vorKomma;
			decPlace = decPlace * (double) base - vorKomma;
			
			count++;
		}
		return octDecPlace;
		
	}
	
	public static String decIntToOct(int decimalInteger, int base){
		String octInt = ""; 
		while (decimalInteger > 0){
			octInt = (decimalInteger % base) + octInt;
			decimalInteger = decimalInteger / base;
		}
		return octInt;
	}
	
	
	//converts decimal fractions (given as double) to binary.
	public static String decFracToBin(double eingang) {
		//defines how many decimal places you want to convert. A recommandable value is 45.
		int accuracy = 45;
		int vorKomma = (int) eingang;
		double nachKomma = eingang - vorKomma;
		
		if (nachKomma == 0.0){
			return decIntToBinInt(vorKomma);
		} else {
			return (decIntToBinInt(vorKomma) + "." + decPlaceToBin(nachKomma, accuracy) 
			+ "   - Präzise bis zur " + accuracy + ". Stelle nach dem Komma");
		}
	}
	
	//converts decimal integers to binary integers
	public static String decIntToBinInt(int decInt) {
		String binInt = "";
		while (decInt != 0) {
			if (decInt % 2 == 1.0) {
				binInt = ("1" + binInt);
				
			} else if (decInt % 2 == 0.0) {
				binInt = ("0" + binInt);
			}
			
			decInt = decInt / 2;

		}
		return binInt;
	}
	
	//converts only the decimal place of floating point numbers to binary
	public static String decPlaceToBin(double inputDecPlace, int accuracy){
		int count = 0;
		String outputBinDecPlace = "";
		
		while (count != accuracy && inputDecPlace > 0) {
			if (inputDecPlace * 2 >= 1.0) {
				outputBinDecPlace = (outputBinDecPlace + "1");
				inputDecPlace = inputDecPlace * 2 -1;
				
			} else if (inputDecPlace * 2 < 1.0) {
				outputBinDecPlace = (outputBinDecPlace + "0");
				inputDecPlace = inputDecPlace * 2;
			}
			
			count++;
		}
		return(outputBinDecPlace);
	}
	

}
