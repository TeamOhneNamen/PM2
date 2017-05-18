package de.hawhamburg.ton.P03;

public class ArraysVergleichen {

	public static int[] arraylist1 = new int[1000];
	
	public static void main(String[] args) {
		

		arrayFüllen();
		System.out.println(arraylist1);
		
	}
	
	public static void arrayFüllen(){
		int zaehler = 0;
		for (int i = 1000; i > 0; i--) {
			arraylist1[zaehler] = i;
			zaehler++;
		}
		
	}

}
