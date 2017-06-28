package tuli.A4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Laura Westfalen
 * @author  Marcel Tuleweit
 *
 */
public class NumPrecision {
	private static double r = 3;
	private static float rF = (float) r;
	private static BigDecimal rBD = new BigDecimal(r);
	
	private static List<Integer> nList = new ArrayList<Integer>(Arrays.asList(20, 50, 100, 1000, 10000));
	private static Integer nCurrent = nList.get(0);
	
	/*
	 * privater Konstrukter, keine Objekte der Klasse gebraucht
	 */
	private NumPrecision(){
	}
	
	public static void setR(double newR) {
		r = newR;
		rF = (float) newR;
		rBD = new BigDecimal(newR);
	}
	
	public static void setNextN() {
		Integer currentN = nList.indexOf(nCurrent);
		nCurrent = nList.get(currentN + 1);
	}
	
	public static boolean hasNextN() {
		return (nCurrent != nList.get(nList.size() - 1));  
	}
	
	public static void nCurrentRestore(){
		nCurrent = nList.get(0);
	}

	// -------------------------------------------------------------------------------------------------------------------------------
	/*
	 * Formel 1
	 */
	public static float f1(float p){
		return (p + rF*p*(1-p));
	}
	
	public static double f1(double p){
		return (p + r*p*(1-p));
	}
	
	public static BigDecimal f1(BigDecimal p){
		return (p.add(rBD.multiply(p.multiply(new BigDecimal(1).subtract(p)))));
	}
	
	/*
	 * Formel 2
	 */
	public static float f2(float p){
		return ((rF + 1)*p - rF * p * p);
	}
	
	public static double f2(double p){
		return ((r + 1)*p - r * p * p);
	}
	
	public static BigDecimal f2(BigDecimal p){
		return (((rBD.add(new BigDecimal(1))).multiply(p)).subtract(rBD.multiply(p).multiply(p)));
	}
	
	/*
	 * Formel 3
	 */
	public static float f3(float p){
		return (p*(rF + 1 - rF*p));
	}
	
	public static double f3(double p){
		return (p*(r + 1 - r*p));
	}
	
	public static BigDecimal f3(BigDecimal p){
		return (p.multiply(rBD.add(new BigDecimal(1)).subtract(rBD.multiply(p))));
	}
	
	/*
	 * Formel 4
	 */
	public static float f4(float p){
		return (p*(1 - rF*p) + rF*p);
	}
	
	public static double f4(double p){
		return (p*(1 - r*p) + r*p);
	}
	
	public static BigDecimal f4(BigDecimal p){
		return (p.multiply((new BigDecimal(1)).subtract(rBD.multiply(p))).add(rBD.multiply(p)));
	}
	
	// -------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * calcFloat berechnet die Formeln 1 - 4 10.000 mal
	 * Die Ergebnisse nach 20, 50, 100, 1000 und 10.000 Durchläufen werden jeweils ausgegeben 
	 * @param startWert
	 */
	public static void calcFloat(float startWert)
	{
		int n = 0;
		float wert1 = startWert;
		float wert2 = startWert;
		float wert3 = startWert;
		float wert4 = startWert;
		
		System.out.println("FLOAT\n");
		
		while(n <= nCurrent)
		{
			wert1 = f1(wert1);
			wert2 = f2(wert2);
			wert3 = f3(wert3);
			wert4 = f4(wert4);
			if(n == nCurrent)
			{
				System.out.println("Ergebnisse nach " + nCurrent + " Durchläufen:");
				System.out.println("Formel 1: " + wert1);
				System.out.println("Formel 2: " + wert2);
				System.out.println("Formel 3: " + wert3);
				System.out.println("Formel 4: " + wert4);
				System.out.println("");
				if (hasNextN()){
					setNextN(); 
				}
			}
			n++;
		}
		nCurrentRestore();
	}
	
	public static void calcDouble(double startWert)
	{
		int n = 0;
		double wert1 = startWert;
		double wert2 = startWert;
		double wert3 = startWert;
		double wert4 = startWert;
		
		System.out.println("DOUBLE\n");
		
		while(n <= nCurrent)
		{
			wert1 = f1(wert1);
			wert2 = f2(wert2);
			wert3 = f3(wert3);
			wert4 = f4(wert4);
			if(n == nCurrent)
			{
				System.out.println("Ergebnisse nach " + nCurrent + " Durchläufen:");
				System.out.println("Formel 1: " + wert1);
				System.out.println("Formel 2: " + wert2);
				System.out.println("Formel 3: " + wert3);
				System.out.println("Formel 4: " + wert4);
				System.out.println("");
				if (hasNextN()){
					setNextN(); 
				}
			}
			n++;
		}
		nCurrentRestore();
	}
	
	public static void calcBD(BigDecimal startWert)
	{
		int n = 0;
		BigDecimal wert1 = startWert;
		BigDecimal wert2 = startWert;
		BigDecimal wert3 = startWert;
		BigDecimal wert4 = startWert;
		
		System.out.println("BIGDECIMAL\n");
		
		while(n <= nCurrent)
		{
			wert1 = f1(wert1);
			wert2 = f2(wert2);
			wert3 = f3(wert3);
			wert4 = f4(wert4);
			if(n == nCurrent)
			{
				System.out.println("Ergebnisse nach " + nCurrent + " Durchläufen:");
				System.out.println("Formel 1: " + wert1);
				System.out.println("Formel 2: " + wert2);
				System.out.println("Formel 3: " + wert3);
				System.out.println("Formel 4: " + wert4);
				System.out.println("");
				if (hasNextN()){
					setNextN(); 
				}
			}
			n++;
		}
		nCurrentRestore();
	}	

	
	public static void main(String[] args) {
		calcFloat(0.01f);
		calcDouble(0.01);
		//calcBD(new BigDecimal(0.01)); // nicht aufrufbar ...
	}
}
