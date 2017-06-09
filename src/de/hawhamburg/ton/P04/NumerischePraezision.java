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

		System.out.println("--- p + r * p * (1 - p) ---");
		System.out.println(funktion1f(r, pf));
		System.out.println(funktion1d(r, p));
		System.out.println(funktion1bd(r, p));
		System.out.println();
		System.out.println();
		System.out.println("--- (r + 1) * p - r * p * 2 ---");
		System.out.println(funktion2f(r, pf));
		System.out.println(funktion2d(r, p));
		System.out.println(funktion2bd(r, p));
		System.out.println();
		System.out.println();
		System.out.println("--- p * (r + 1 - r*p) ---");
		System.out.println(funktion3f(r, pf));
		System.out.println(funktion3d(r, p));
		System.out.println(funktion3bd(r, p));
		System.out.println();
		System.out.println();
		System.out.println("--- p * (1 - r*p) + r*p ---");
		System.out.println(funktion4f(r, pf));
		System.out.println(funktion4d(r, p));
		System.out.println(funktion4bd(r, p));

		int mal = 20;

		funktionen(mal, r, pf, p);

		mal = 50;

		funktionen(mal, r, pf, p);

		mal = 100;

		funktionen(mal, r, pf, p);

		mal = 1000;

		funktionen(mal, r, pf, p);

		mal = 10000;

		funktionen(mal, r, pf, p);

	}

	public static void funktionen(int mal, int r, float pf, double p) {

		funktion1n(mal, r, pf, p);

		funktion2n(mal, r, pf, p);

		funktion3n(mal, r, pf, p);

		funktion4n(mal, r, pf, p);

	}

	public static void funktion1n(int n, int r, float p, double pd) {

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

			abd.add(funktion1bd(r, pd));

		}
		System.out.println("formal 1 BigDecimal beendet");
	}

	public static void funktion2n(int n, int r, float p, double pd) {

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

			abd.add(funktion2bd(r, pd));

		}
		System.out.println("formal 2 BigDecimal beendet");
	}

	public static void funktion3n(int n, int r, float p, double pd) {

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

			abd.add(funktion3bd(r, pd));

		}
		System.out.println("formal 3 BigDecimal beendet");
	}

	public static void funktion4n(int n, int r, float p, double pd) {

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

			abd.add(funktion4bd(r, pd));

		}
		System.out.println("formal 4 BigDecimal beendet");
	}

	public static float funktion1f(int r, float p) {
		return p + r * p * (1 - p);

	}

	public static double funktion1d(int r, double p) {
		return p + r * p * (1 - p);

	}

	public static BigDecimal funktion1bd(int r, double p) {
		BigDecimal bd = new BigDecimal(p + r * p * (1 - p));
		return bd;

	}

	public static float funktion2f(int r, float p) {
		return (r + 1) * p - r * p * 2;

	}

	public static double funktion2d(int r, double p) {
		return (r + 1) * p - r * p * 2;

	}

	public static BigDecimal funktion2bd(int r, double p) {

		BigDecimal bd = new BigDecimal((r + 1) * p - r * p * 2);
		return bd;

	}

	public static float funktion3f(int r, float p) {
		return (p * (r + 1 - r * p));

	}

	public static double funktion3d(int r, double p) {
		return (p * (r + 1 - r * p));

	}

	public static BigDecimal funktion3bd(int r, double p) {
		BigDecimal bd = new BigDecimal((p * (r + 1 - r * p)));
		return bd;

	}

	public static float funktion4f(int r, float p) {
		return p * (1 - r * p) + r * p;

	}

	public static double funktion4d(int r, double p) {
		return p * (1 - r * p) + r * p;

	}

	public static BigDecimal funktion4bd(int r, double p) {
		BigDecimal bd = new BigDecimal(p * (1 - r * p) + r * p);
		return bd;

	}

}
