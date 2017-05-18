package de.hawhamburg.ton.P03;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Reader {

	public static ArrayList<String> eineListeVonZeilen = new ArrayList<String>();
	private static Scanner newSc;
	


	public static void main(String[] args) {

		
		File file = new File("bin/de/hawhamburg/ton/P03/picasso.txt");

		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// in Zeilen aufteilen
		if (sc.hasNextLine()) {

			while (sc.hasNextLine()) {
				
				inZeilenAufteilen(sc.nextLine());
			}
		} else {

			throw new NullPointerException();

		}

		System.out.println(last(5));
		System.out.println(last(6));
		
		System.out.println(reimChecker(5, 6));
		System.out.println(gibZeile(15));
		System.out.println(gibZeile("Sie schaffen nicht mal Tuben an."));
		
		System.out.println(sortieren(eineListeVonZeilen));
		System.out.println(eineListeVonZeilen);
	}

	public static void inZeilenAufteilen(String nextLine) {
		eineListeVonZeilen.add(nextLine);
	}
	
	public static String gibZeile(int zeilennummer){
		String zeileninhalt = eineListeVonZeilen.get((zeilennummer-1));
		return zeileninhalt;
		
	}
	
	public static int gibZeile(String zeileninhalt){
				int zeile = (eineListeVonZeilen.indexOf(zeileninhalt))+1;
		
		
		//eineListeVonZeilen.forEach((a)->System.out.println(a));
		//int zeilennummer = eineListeVonZeilen.get((zeilennummer-1));
		//return zeilennummer;
		return zeile;
	}
	
	public static String last(int zeile){
		
		String temp = eineListeVonZeilen.get((zeile-1));
		
		ArrayList<String> eineListeVonWoertern = new ArrayList<String>();
		
		String ergebnis = "nichts vorhanden";
		
		newSc = new Scanner(temp);
		
		while (newSc.hasNext()) {
			
			eineListeVonWoertern.add(newSc.next());
			
			
		}
		
		int laenge = eineListeVonWoertern.size();
		ergebnis = eineListeVonWoertern.get(laenge-1);
		return ergebnis;
	}

	public static boolean reimChecker(int ersteZeile, int zweiteZeile){
		
		String[] paare = {"gemacht, gebracht.", "gebracht. gemacht,", "gemalt, gezahlt.", "gezahlt. gemalt,", "versucht, verbucht.", "verbucht. versucht,", "dran, an.", "an. dran,", "bezahlt, gemalt.", "gemalt. bezahlt,", "ab, hab.", "hab. ab,", "ein, ein.", "ein. ein,", "bedacht, gebracht.", "gebracht. bedacht,", "bezahlt, gemalt.", "gemalt. bezahlt,", "Pressewelt, hält.", "hält. Pressewelt,", "Blätterwald, kalt.", "kalt. Blätterwald,", "bedacht, gelacht.", "gelacht. bedacht,", "versehrt, verehrt.", "verehrt. versehrt,", "bewegt, belegt.", "belegt. bewegt,", "gekriegt, besiegt.", "besiegt. gekriegt,", "zahl'n, mal'n.", "mal'n. zahl'n,", "lacht, macht.", "macht. lacht,"};
		
		String wort1 = last(ersteZeile);
		String wort2 = last(zweiteZeile);
		
		String wortKombi = wort1 + " " + wort2;
		
		int zaehler = 0;
		
		while (zaehler!=paare.length) {
			if (wortKombi.equals(paare[zaehler])) {
				return true;
			}
			zaehler++;
		}
		
		return false;
	}
	// Aufgabe 2
	
	public static ArrayList<String> sortieren(ArrayList<String> list){
		
		ArrayList<String> listcopy = (ArrayList<String>) list.clone();
		
		Collections.sort(listcopy.subList(0, listcopy.size()));
		
		return listcopy;
	}
	
}
