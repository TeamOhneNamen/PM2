/**
 * NumerischePraezision.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P04;

import java.math.BigDecimal;

public class NumerischePraezision {
	
	public static void main(String[] args) {
		int r = 3;
		double p = 0.01;
		
		
		
	}
	
	public float funktion1f(int r, double p){
		float f = p + r * p * (1-p);
		return f;
		
	}

	public double funktion1d(int r, double p){
		double d = p + r * p * (1-p);
		return d;
		
	}

	public  BigDecimal funktion1bd(int r, double p){
		BigDecimal bd = p + r * p * (1-p);
		return bd;
		
	}
	
public float funktion2(int r, double p){
	return f;
	
}

public double funktion2(int r, double p){
	return d;
	
}

public  BigDecimal funktion2(int r, double p){
	return bd;
	
}

public float funktion3(int r, double p){
	return f;
	
}

public double funktion3(int r, double p){
	return d;
	
}

public  BigDecimal funktion3(int r, double p){
	return bd;
	
}

public float funktion4(int r, double p){
	return f;
	
}

public double funktion4(int r, double p){
	return d;
	
}

public  BigDecimal funktion4(int r, double p){
	return bd;
	
}


}
