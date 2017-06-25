/**
 * Aufgabe05.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2ss2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Aufgabe05 {
	

	public static void main(String[] args) throws IOException {
		Aufgabe05 a = new Aufgabe05("src/de/hawhamburg/ton/P03/picasso.txt");
		System.out.println(a);
		a.sortByFinalSyllable();
		System.out.println(a.copy);
		a.sortByLastWord();
		System.out.println(a.copy);
		System.out.println(a.lastword("An die split-Funktion wird ein regulärer Ausdruck übergeben werden."));
		System.out.println(a.prelastword("An die split-Funktion wird ein regulärer Ausdruck übergeben werden."));
		System.out.println(a.getFinalSyllable("werden"));
		System.out.println(a.isRhyme("dfgsdgfdgdsfdfswerden","sdfgsdfgdsdf sdfsdfdg sterben"));
		System.out.println(a.isDoppelreim("aß grad Salat ","die Saat zertrat"));
	}
	
	private ArrayList<String> textLinesAsStrings = new ArrayList<String>();
	public ArrayList<String> copy = new ArrayList<String>();
	
	public Aufgabe05(String path) throws FileNotFoundException {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				textLinesAsStrings.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isDoppelreim(String firstline, String secondline) {
		return (isRhyme(firstline,secondline) && getFinalSyllable(prelastword(firstline)).equals(getFinalSyllable(prelastword(secondline))));

	}
	
	private boolean isRhyme(String firstline, String secondline) {
		return getFinalSyllable(firstline).equals(getFinalSyllable(secondline));
	}


	public String lastword(String line) {
		String[] wordsofline = line.split(" ");
		return wordsofline[wordsofline.length-1];
	}
	
	public String prelastword(String line) {
		String[] wordsofline = line.split(" ");
		return wordsofline[wordsofline.length-2];
	}
	
	public String getFinalSyllable(String word) {
		char[] revword = new StringBuilder(word).reverse().toString().toCharArray();
		String revsyl = "";
		boolean vowelfound = false;
		for(int i = 0; !vowelfound && i < revword.length; i++){
			if("AEIOUaeiou".indexOf(revword[i]) != -1){
				revsyl += revword[i];
				vowelfound = true;
			}else if(!(".!,?".indexOf(revword[i]) != -1)){
				revsyl += revword[i];
			}
		}
		return new StringBuilder(revsyl).reverse().toString();
	}
	
	public String getLastWord(String word) {
		String[] wordsarray = word.split(" ");
		return wordsarray[wordsarray.length-1];
	}
	
	public void sortByFinalSyllable() {
		copy = textLinesAsStrings;
		copy.sort((e1, e2) -> getFinalSyllable(e1).compareTo(getFinalSyllable(e2)));
	} 
	
	public void sortByLastWord() {
		copy = textLinesAsStrings;
		copy.sort((e1, e2) -> getLastWord(e1).compareTo(getLastWord(e2)));
	} 
	
	
	public String toString() {
		return textLinesAsStrings.toString();
	} 
	
	
}
