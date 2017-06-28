package tuli.A3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Eine Klasse zum einlesen und bearbeiten von Textobjekten.<p>
 * Akzeptiert werden Textdateien und FileInputStreams.
 * @author Jan Möller
 * @author E-Z Dakowitz
 * @version 1.3
 */
public class Text {
	private ArrayList<String> originalContend = new ArrayList<String>();
	private ArrayList<String> contend = new ArrayList<String>();
	private LocalDateTime lastChange;

	
	//--------------------------------- Konstruktoren ---------------------------------------
	
	/**
	 * Erzeugt ein Textobjekt anhand des übergebenen Pfades. 
	 * @since 1.0
	 * 
	 * @param path / String der ein g�ltiger Pfad zu einer Textdatei Repr�sentiert
	 * @throws FileNotFoundException
	 */
	public Text(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			int i = 0;
			while (scanner.hasNextLine()) {
				originalContend.add(i, scanner.nextLine());
				i++;
			}
			scanner.close();
			contend = new ArrayList<String>(originalContend);
			this.update();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Erzeugt ein Textobjekt anhand eines {@link InputStreams}. 
	 * @since 1.0
	 * 
	 * @param path / String der einen g�ltigen Pfad zu einer Textdatei Repr�sentiert.
	 * @throws Err {@link FileNotFoundException}
	 */
	public Text(FileInputStream stream) {
		int i = 0;
		String line;
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(stream));
		try {
			while ((line = buffReader.readLine()) != null) {
				originalContend.add(i++, line);
			}
			contend = new ArrayList<String>(originalContend);
			this.update();
		} catch (IOException e) {
			System.err.println(
					"Fehler! Der InputStream ist fehlerhaft." );
			e.printStackTrace();
		}
	}

	//--------------------- GETTER ------------------------------------------
	
	/**
	 * Liefert einen {@link String} der das Datum des letzten Zugriffs enth�lt. <p>
	 * Beispiel:
	 * <p>2017 05 17 
	 * <p>12:44 
	 * 
	 * @since 1.0
	 * @return String 
	 */
	public String getLastChange() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd \nH:m:s");
		return lastChange.format(formatter);
	}

	/**
	 * Liefert einen {@link String} der das Datum des letzten Zugriffs enth�lt.
	 * @since 1.0
	 * 
	 * @param formatter / Ben�tigt einen formatter {@link DateTimeFormatter}
	 * @return String
	 */
	public String getLastChange(DateTimeFormatter formatter) {
		return lastChange.format(formatter);
	}
	
	/**
	 * Liefert einen String der eine bestimmte Zeile des Textes enth�lt. <p>
	 * Siehe auch {@link #toNumberedLineString()}, {@link #getLineNumber(String)}.
	 * @since 1.1
	 * 
	 * @param  Die Nummer der gew�nschten Zeile.
	 * @return String oder null falls lineNumber nicht existend(OutOfBounds)
	 */
	public String getLine(int lineNumber) {
		if (lineNumber < contend.size() - 1 && lineNumber > 0) {
			return contend.get(lineNumber - 1);
		} else {
			return null;
		}
	}

	/**
	 * Diese Methode liefert die Zeilenummer zu einer �bergebenen Zeile(String).<p>
	 * Siehe auch {@link #getLine(int)}.
	 * @since 1.1
	 * 
	 * @param lineText / eine Zeile(String) dessen Nummerierung ermittelt werden soll.
	 * @return int Zeilennummer
	 */
	public int getLineNumber(String lineText) {
		int lineNumber = 0;
		lineNumber = contend.indexOf(lineText) + 1;
		return lineNumber;
	}
	
	/**
	 * Ermittelt die Anzahl der Zeilen.
	 * @since 1.3
	 * @return int 
	 */
	public int getLinesAmount(){
		int result = contend.size();
		return result;
	}
	
	/**
	 * Ermittelt das letzte wort der Zeile mit der �bergebenen Zeilenummer.
	 * @since1.3
	 * @param lineNumber
	 * @return Das letzte wort der Zeile oder null sollte die Zeile nicht vorhanden sein(OutOfBounds)
	 */
	public String getLastWordOfLine(int lineNumber){
		if(lineNumber < 0 || lineNumber>this.getLinesAmount()-1){
			return null;
		}
		String lastWord = lastWord(this.getLine(lineNumber));
		return lastWord;
	}
	
	//-------------------------------- instanzMethoden ----------------------------------------------
	
	private void update(){
		lastChange = LocalDateTime.now();
	}
	
	/**
	 * Macht alle �nderungen am Textobjekt r�ckg�ngig und setzt es auf den erste Einlesezustandt.
	 * @since 1.2
	 */
	public void restore(){
		contend = new ArrayList<String>(originalContend);
		this.update();
	}
	
	/**
	 * Sortiert die Zeilen des Textes nach der n�turlichen Ordnung f�r Strings
	 * @since 1.1
	 * 
	 * @return this
	 */
	public Text sortLines() {		
		contend.sort(null);
		contend.removeIf(string -> string.equals(""));
		this.update();
		return this;
	}
	
	/**
	 * Sortiert die Zeilen des Textes nach dem �bergebenen comperator. <p>
	 * Siehe auch {@link Comparator}
	 * @since 1.1
	 * 
	 * @return this
	 */
	public Text sortLines(Comparator<String> c) {		
		contend.sort(c);
		contend.removeIf(string -> string.equals(""));
		this.update();
		return this;
	}

	/**
	 * Sortiert die Zeilen des Textes nach dem letzten Wort der Zeile.
	 * 
	 * @return this
	 */
	public Text sortLinesByLastWord() {		
		contend.sort(letztesWort);
		contend.removeIf(s -> s.isEmpty());
		this.update();
		return this;
	}
	
	//hilfe f�r sortLinesByLastWord()
	Comparator<String> letztesWort = Comparator.comparing(this::lastWord);
	//hilfe f�r sortLinesByLastWord()
	private String lastWord(String string) {
	    String[] words = string.split("[\\p{Punct}, \\s]");
	    return words[words.length - 1];
	}
	
	/**
	 * Splitted den text nach einem Regul�ren Ausdruck.<p>
	 * Siehe auch {@link String#split(String)}, {@link java.util.regex.Pattern}     
	 * 
	 * @param regExp
	 * @return String[]
	 * @throws PatternSyntaxException
	 */
	public String[] split(String regExp) throws PatternSyntaxException {
		String[] splitArray = toString().split(regExp);
		return splitArray;
	}

	/**
	 * Splitted den text nach einem Regul�ren Ausdruck.<p>
	 * Siehe auch {@link String#split(String, int)}, {@link java.util.regex.Pattern}     
	 * 
	 * @param regExp, int limit
	 * @return String[]
	 * @throws PatternSyntaxException
	 */
	public String[] split(String regExp, int limit) throws PatternSyntaxException {
		String[] splitArray = toString().split(regExp, limit);
		return splitArray;
	}
	//-------------------------------- toStrings ----------------------------------------------------
	
	/**
	 * Gibt den Text als String zur�ck.
	 * @since 1.0
	 * @return String
	 * 
	 */
	public String toString() {
		String output = "";
		for (String element : contend) {
			if (element != "\n") {
				output += element + "\n";
			}
		}
		return output;
	}
	
	/**
	 * Gibt einen String zur�ck bei dem jeder Zeile eine Nummerierung vorrangestellt ist.
	 * 
	 * @return String
	 */
	public String toNumberedLineString() {
		int i = 1;
		String output = "";
		for (String element : contend) {
			if (element != "\n") {
				output += i++ + "  " + element + "\n";
			}
		}
		return output;
	}
	public static void main(String[] args) throws FileNotFoundException{
		Text testObject1;
			testObject1 = new Text("picasso.txt");
	
		testObject1.sortLinesByLastWord();
		System.out.println(testObject1.toString());
	}
}

