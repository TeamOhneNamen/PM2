/**
 * Aufgabe1.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package Probeklausur;

public class Aufgabe1 {
	
	public static int summe(int n){
		if(n <= 1){
			return 1;
		}else{
			return n + summe(n-1);
		}
	}
	
	public static int fibonacci(int n){
		if(n == 0){
			return 1;
		}else if(n == 1){
			return 1;
		}else{
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(summe(5));
		System.out.println(fibonacci(5));
	}

}
