/**
 * NumerischePraezision.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P04;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NumerischePraezision {

	public static void main(String[] args) {
		int r = 3;
		double p = 0.01;
		Double pD = p;
		float pf = pD.floatValue();
		BigDecimal bdp = new BigDecimal(0.01);

		System.out.println("--- p + r * p * (1 - p) ---");
		System.out.println(funktion1f(r, pf));
		System.out.println(funktion1d(r, p));
		System.out.println(funktion1bd(r, bdp));
		System.out.println();
		System.out.println();
		System.out.println("--- (r + 1) * p - r * p * 2 ---");
		System.out.println(funktion2f(r, pf));
		System.out.println(funktion2d(r, p));
		System.out.println(funktion2bd(r, bdp));
		System.out.println();
		System.out.println();
		System.out.println("--- p * (r + 1 - r*p) ---");
		System.out.println(funktion3f(r, pf));
		System.out.println(funktion3d(r, p));
		System.out.println(funktion3bd(r, bdp));
		System.out.println();
		System.out.println();
		System.out.println("--- p * (1 - r*p) + r*p ---");
		System.out.println(funktion4f(r, pf));
		System.out.println(funktion4d(r, p));
		System.out.println(funktion4bd(r, bdp));

		int mal = 20;

		funktionen(mal, r, pf, p, bdp);

		mal = 50;

		funktionen(mal, r, pf, p, bdp);

		mal = 100;

		funktionen(mal, r, pf, p, bdp);

		mal = 1000;

		funktionen(mal, r, pf, p, bdp);

		mal = 10000;

		funktionen(mal, r, pf, p, bdp);

	}

	public static void funktionen(int mal, int r, float pf, double p, BigDecimal pbd) {

		funktion1n(mal, r, pf, p, pbd);

		funktion2n(mal, r, pf, p, pbd);

		funktion3n(mal, r, pf, p, pbd);

		funktion4n(mal, r, pf, p, pbd);

	}

	public static void funktion1n(int n, int r, float p, double pd, BigDecimal pbd) {

		ArrayList<Float> af = new ArrayList<Float>();

		System.out.println("starte formal 1 float mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			af.add(funktion1f(r, p));

		}
		System.out.println("formal 1 float beendet");

		ArrayList<Double> ad = new ArrayList<Double>();

		System.out.println("starte formal 1 double mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			ad.add(funktion1d(r, pd));

		}
		System.out.println("formal 1 double beendet");

		ArrayList<BigDecimal> abd = new ArrayList<BigDecimal>();

		System.out.println("starte formal 1 BigDecimal mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			abd.add(funktion1bd(r, pbd));

		}
		System.out.println("formal 1 BigDecimal beendet");
	}

	public static void funktion2n(int n, int r, float p, double pd, BigDecimal pbd) {

		ArrayList<Float> af = new ArrayList<Float>();

		System.out.println("starte formal 2 float mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			af.add(funktion2f(r, p));

		}
		System.out.println("formal 2 float beendet");

		ArrayList<Double> ad = new ArrayList<Double>();

		System.out.println("starte formal 2 double mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			ad.add(funktion2d(r, pd));

		}
		System.out.println("formal 2 double beendet");

		ArrayList<BigDecimal> abd = new ArrayList<BigDecimal>();

		System.out.println("starte formal 2 BigDecimal mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			abd.add(funktion2bd(r, pbd));

		}
		System.out.println("formal 2 BigDecimal beendet");
	}

	public static void funktion3n(int n, int r, float p, double pd, BigDecimal pbd) {

		ArrayList<Float> af = new ArrayList<Float>();

		System.out.println("starte formal 3 float mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			af.add(funktion3f(r, p));

		}
		System.out.println("formal 3 float beendet");

		ArrayList<Double> ad = new ArrayList<Double>();

		System.out.println("starte formal 3 double mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			ad.add(funktion3d(r, pd));

		}
		System.out.println("formal 3 double beendet");

		ArrayList<BigDecimal> abd = new ArrayList<BigDecimal>();

		System.out.println("starte formal 3 BigDecimal mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			abd.add(funktion3bd(r, pbd));

		}
		System.out.println("formal 3 BigDecimal beendet");
	}

	public static void funktion4n(int n, int r, float p, double pd, BigDecimal pbd) {

		ArrayList<Float> af = new ArrayList<Float>();

		System.out.println("starte formal 4 float mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			af.add(funktion4f(r, p));

		}
		System.out.println("formal 4 float beendet");

		ArrayList<Double> ad = new ArrayList<Double>();

		System.out.println("starte formal 4 double mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			ad.add(funktion4d(r, pd));

		}
		System.out.println("formal 4 double beendet");

		ArrayList<BigDecimal> abd = new ArrayList<BigDecimal>();

		System.out.println("starte formal 4 BigDecimal mit " + n + " durchläufen");
		for (int i = 0; i < n; i++) {

			abd.add(funktion4bd(r, pbd));

		}
		System.out.println("formal 4 BigDecimal beendet");
	}

	public static float funktion1f(int r, float p) {
		return p + r * p * (1 - p);

	}

	public static double funktion1d(int r, double p) {
		return p + p * r * (1 - p);

	}

	public static BigDecimal funktion1bd(int r, BigDecimal p) {
//		(1 - p)
		BigDecimal t1 = new BigDecimal(1).subtract(p);
//		r * (1 - p)
		BigDecimal t2 = new BigDecimal(r).multiply(t1);
//		p * r * (1 - p)
		BigDecimal t3 = p.multiply(t2);
//		p + p * r * (1 - p)
		BigDecimal t4 = p.add(t3);
		
		return t4;

	}

	public static float funktion2f(int r, float p) {
		return (r + 1) * p - r * p * 2;

	}

	public static double funktion2d(int r, double p) {
		return (r + 1) * p - r * p * 2;

	}

	public static BigDecimal funktion2bd(int r, BigDecimal p) {

		
//		(1 + r)
		int t1 = 1+r;
//		(1 + r) * p
		BigDecimal t2 = new BigDecimal(t1).multiply(p);
//		r * p
		BigDecimal t3 = p.multiply(new BigDecimal(r));
//		r * p * 2
		BigDecimal t4 = t3.multiply(new BigDecimal(2));
//		(r + 1) * p - r * p * 2
		BigDecimal t5 = t2.subtract(t4);
		
		return t5;
		

	}

	public static float funktion3f(int r, float p) {
		return (p * (r + 1 - r * p));

	}

	public static double funktion3d(int r, double p) {
		return (p * (r + 1 - r * p));

	}

	public static BigDecimal funktion3bd(int r, BigDecimal p) {
		
		
//		r * p
		BigDecimal t1 = p.multiply(new BigDecimal(r));
//		r + 1
		int t2 = 1+r;
//		(r + 1 - r * p)		
		BigDecimal t3 = t1.subtract(new BigDecimal(t2));
//		p * (r + 1 - r * p)
		BigDecimal t4 = t3.multiply(p);

		return t4;

	}

	public static float funktion4f(int r, float p) {
		return p * (1 - r * p) + r * p;

	}

	public static double funktion4d(int r, double p) {
		return p * (1 - r * p) + r * p;

	}

	public static BigDecimal funktion4bd(int r, BigDecimal p) {
		
//		1
		BigDecimal one = new BigDecimal(1);
//		r * p
		BigDecimal t1 = p.multiply(new BigDecimal(r));
//		(1 - r * p)
		BigDecimal t2 = one.subtract(t1);
//		p * (1 - r * p)
		BigDecimal t3 = p.multiply(t2);
//		p * (1 - r * p) + r * p
		BigDecimal t4 = t3.add(t1);
		
		return t4;

	}

}
