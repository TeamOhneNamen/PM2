/**
 * An immutable class for complex numbers, modeled after the corresponding Ruby
 * class Complex (Complex Ruby Stdlib 1.8.7).
 * 
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 *

 */

package de.hawhamburg.ton.P03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader {

	public static ArrayList<String> eineListeVonZeilen = new ArrayList<String>();
	private static Scanner newSc;
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {

		readByLines("bin/de/hawhamburg/ton/P03/picasso.txt");

		// System.out.println(last(5));
		// System.out.println(last(6));
		//
		// System.out.println(reimChecker(5, 6));
		// System.out.println(gibZeile(15));
		// System.out.println(gibZeile("Sie schaffen nicht mal Tuben an."));
		//
		// System.out.println(sortieren(eineListeVonZeilen));
		// System.out.println(eineListeVonZeilen);

		System.out.println(inWelcherZeile("Bares"));
		System.out.println(contains("Bares"));

		List<String> ergebnis = sortByLast(eineListeVonZeilen);
		System.out.println(ergebnis);
		//
		// System.out.println(ausgabe(ergebnis));

	}

	// reads text from source


	public static List<String> readByLines(String source) throws FileNotFoundException {

		File file = new File(source);
		
		try (Scanner sc = new Scanner(file)) {
	    	
			while (sc.hasNextLine()) {
				eineListeVonZeilen.add(sc.nextLine());
			}
	    }
		
		return eineListeVonZeilen;
	}



	// return a concatenated string of all elements of the given string array
	public static String ausgabe(String[] str) {

		String erg = "";

		for (int i = 0; i < str.length; i++) {
			erg = erg + str[i];
		}

		return erg;
	}

	public static String gibZeile(int zeilennummer) {
		String zeileninhalt = eineListeVonZeilen.get((zeilennummer - 1));
		return zeileninhalt;

	}

	public static int gibZeile(String zeileninhalt) {
		int zeile = (eineListeVonZeilen.indexOf(zeileninhalt)) + 1;

		// eineListeVonZeilen.forEach((a)->System.out.println(a));
		// int zeilennummer = eineListeVonZeilen.get((zeilennummer-1));
		// return zeilennummer;
		return zeile;
	}

	// returns the last word of the line which has the given number
	public static String last(int zeile) {

		ArrayList<String> eineListeVonWoertern = new ArrayList<String>();

		String ergebnis = null;

		newSc = new Scanner(eineListeVonZeilen.get((zeile - 1)));

		while (newSc.hasNext()) {

			eineListeVonWoertern.add(newSc.next());

		}

		int laenge = eineListeVonWoertern.size();
		ergebnis = eineListeVonWoertern.get(laenge - 1);
		return ergebnis;
	}

	// returns the number of the line which has the given word at the end
	public static String last(String str) {

		List<String> eineListeVonWoertern = new ArrayList<String>();

		String ergebnis = "nichts vorhanden";

		newSc = new Scanner(str);

		while (newSc.hasNext()) {

			eineListeVonWoertern.add(newSc.next());

		}

		int laenge = eineListeVonWoertern.size();
		if (laenge > 1) {
			ergebnis = eineListeVonWoertern.get(laenge - 1);
		} else {
			ergebnis = "0";
		}

		return ergebnis;
	}

	public static boolean reimChecker(int ersteZeile, int zweiteZeile) {

		String[] paare = { "gemacht, gebracht.", "gebracht. gemacht,", "gemalt, gezahlt.", "gezahlt. gemalt,",
				"versucht, verbucht.", "verbucht. versucht,", "dran, an.", "an. dran,", "bezahlt, gemalt.",
				"gemalt. bezahlt,", "ab, hab.", "hab. ab,", "ein, ein.", "ein. ein,", "bedacht, gebracht.",
				"gebracht. bedacht,", "bezahlt, gemalt.", "gemalt. bezahlt,", "Pressewelt, hält.", "hält. Pressewelt,",
				"Blätterwald, kalt.", "kalt. Blätterwald,", "bedacht, gelacht.", "gelacht. bedacht,",
				"versehrt, verehrt.", "verehrt. versehrt,", "bewegt, belegt.", "belegt. bewegt,", "gekriegt, besiegt.",
				"besiegt. gekriegt,", "zahl'n, mal'n.", "mal'n. zahl'n,", "lacht, macht.", "macht. lacht," };

		String wort1 = last(ersteZeile);
		String wort2 = last(zweiteZeile);

		String wortKombi = wort1 + " " + wort2;

		int zaehler = 0;

		while (zaehler != paare.length) {
			if (wortKombi.equals(paare[zaehler])) {
				return true;
			}
			zaehler++;
		}

		return false;
	}
	// Aufgabe 2

	public static List<String> sortieren(List<String> list) {

		List<String> listcopy = list;

		Collections.sort(listcopy.subList(0, listcopy.size()));

		return listcopy;
	}

	public static int inWelcherZeile(String str) {

		ArrayList<String> woerterEinerZeile = new ArrayList<>();

		for (int i = 0; i < eineListeVonZeilen.size(); i++) {

			String zeile = (eineListeVonZeilen.get(i));

			sc = new Scanner(zeile);

			while (sc.hasNext()) {

				woerterEinerZeile.add(sc.next());

			}

		}

		Collections.sort(woerterEinerZeile.subList(0, woerterEinerZeile.size()));

		System.out.println(woerterEinerZeile.toString());
		// System.out.println(Arrays.binarySearch(arrayInArrayList(woerterEinerZeile),
		// str));

		return Arrays.binarySearch(arrayInArrayList(woerterEinerZeile), str);
	}

	public static ArrayList<String> contains(String str) {

		ArrayList<String> found = new ArrayList<>();

		for (int i = 0; i < eineListeVonZeilen.size(); i++) {

			String zeile = (eineListeVonZeilen.get(i));
			if (zeile.contains(str)) {
				found.add(zeile);
			}

		}

		return found;
	}

	public static String[] arrayInArrayList(ArrayList<String> woerterEinerZeile) {

		String[] strArray = new String[woerterEinerZeile.size()];

		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = woerterEinerZeile.get(i);

		}

		return strArray;

	}

//	public static String[] nachLetztesWortSortieren(ArrayList<String> altZuSortieren) {
//
//		String[] zusortieren = arrayInArrayList(altZuSortieren);
//
//		zusortieren = removeMinus(zusortieren);
//
//		String temp;
//		for (int i = 1; i < zusortieren.length; i++) {
//			for (int j = 0; j < zusortieren.length - i; j++) {
//				if (last(zusortieren[j]).substring(0, 1).toCharArray()[0] >= last(zusortieren[j + 1]).substring(0, 1)
//						.toCharArray()[0]) {
//					System.out.println("so: " + last(zusortieren[j]));
//					temp = zusortieren[j];
//					zusortieren[j] = zusortieren[j + 1];
//					zusortieren[j + 1] = temp;
//
//				}
//			}
//		}
//
//		return zusortieren;
//	}

	public static List<String> sortByLast(List<String> zuSortieren){
		
		List<String> zuSortierenCopy = new ArrayList<String>( zuSortieren);
		
		zuSortierenCopy = removeMinus(zuSortierenCopy);
		
		Collections.sort(zuSortierenCopy, new Comparator<String>(){
			
			@Override
			public int compare(String o1, String o2){
				return last(o1).compareTo(last(o2));
			}
		});
	
		return zuSortierenCopy;
	}

	private static List<String> removeMinus(List<String> altZuSortieren) {

		ArrayList<String> listeOhneMinus = new ArrayList<String>();

		for (int i = 0; i < altZuSortieren.size(); i++) {

			if (last(altZuSortieren.get(i)).equals("-")) {

				listeOhneMinus.add(altZuSortieren.get(i).replaceAll("-", ""));

			} else {

				listeOhneMinus.add(altZuSortieren.get(i));

			}

		}

		return listeOhneMinus;

	}

}
