package de.hawhamburg.ton.P03;

import java.util.Arrays;

public class ArraysVergleichen {

	public static int[] arraylist1 = new int[1000];
	
	public static void main(String[] args) {
		

		arrayFüllen();
		System.out.println(Arrays.toString(arraylist1));
		
		System.out.println(timeSort(10000));
		System.out.println(timeParaSort(10000));
		
	}
	
	public static void arrayFüllen(){
		int zaehler = 0;
		for (int i = 1000; i > 0; i= i-1) {
			arraylist1[zaehler] = i;
			zaehler++;
		}
		
	}
	
	public static void sort(){
		
		int[] copyOfArrayList1 = arraylist1;
		Arrays.sort(copyOfArrayList1);
		
		
	}
	public static float timeSort(int times){
		float timeBeforeSort = System.nanoTime();
		
		for (int i = 0; i < times; i++) {
			sort();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		float timeAfterSort = System.nanoTime();
		return (timeAfterSort-timeBeforeSort);
	}
	
	public static void paraSort(){
		
		int[] copyOfArrayList1 = arraylist1;
		Arrays.parallelSort(copyOfArrayList1);
		
		
	}
	public static float timeParaSort(int times){
		float timeBeforeParaSort = System.nanoTime();
		
		for (int i = 0; i < times; i++) {
			paraSort();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		float timeAfterParaSort = System.nanoTime();
		return (timeAfterParaSort-timeBeforeParaSort);
	}
	
	
}
