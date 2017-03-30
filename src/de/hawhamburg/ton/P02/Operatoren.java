package de.hawhamburg.ton.P02;

public class Operatoren {

	public static void main(String[] args) {

		System.out.println(decFracToBin(Math.PI));
		System.out.println(decFracToBin(Math.E));
		System.out.println(decFracToBin(2.0));
		System.out.println(decFracToBin(2.1));
		System.out.println(decFracToOct(123.0));

	}
	
	public static String decFracToOct(double decimalFraction){
		//defines how many decimal places you want to convert. A recommandable value is 45.
		int accuracy = 45;
		int vorKomma = (int) decimalFraction;
		double nachKomma = decimalFraction - vorKomma;
		if (nachKomma == 0.0){
			return decIntToOct(vorKomma);
		} else {
			return (decIntToBinInt(vorKomma) + "." + decPlaceToBin(nachKomma, accuracy) 
			+ "   - Präzise bis zur " + accuracy + ". Stelle nach dem Komma");
		}
	}
	
	public static String decPlaceToOct(int decPlace){
		decPlace 
		int accuracy = 45;
		int vorKomma = (int) decPlace;
		double nachKomma = decPlace - vorKomma;
		
	}
	
	public static String decIntToOct(int decimalInteger){
		String octInt = ""; 
		while (decimalInteger > 0){
			octInt = (decimalInteger % 8) + octInt;
			decimalInteger = decimalInteger / 8;
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
