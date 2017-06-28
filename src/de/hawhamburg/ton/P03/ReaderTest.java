package de.hawhamburg.ton.P03;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;

public class ReaderTest {
	
	String text1source 				= "bin/de/hawhamburg/ton/P03/testtext.txt";
	String text2source 				= "bin/de/hawhamburg/ton/P03/testtext2.txt";
	
	String[] text1arry 				= {"Die Ordnung des Tages,", "liegt noch im Schlaf.", "Das unaufger�umte Gestern,", "k�nnte sich zum Konjuktiv erheben."};
	String[] text2arry 				= {"Wird ich nicht nach Tarif bezahlt,", "wird ab sofort naiv gemalt.", "asdf."};
	
	String[] text1arrysorted 		= {"Das unaufger�umte Gestern,", "Die Ordnung des Tages,", "liegt noch im Schlaf.", "k�nnte sich zum Konjuktiv erheben."};
	String[] text1arrysortedlast 	= {"k�nnte sich zum Konjuktiv erheben.", "Das unaufger�umte Gestern,", "liegt noch im Schlaf.", "Die Ordnung des Tages,"};
	
	String text1arry1 				= "Die Ordnung des Tages,";
	String text1arry1last 			= "Tages,";
	
	String blank 					= "";
	String lineEndMinus 			= "Nun also w�ren Kuben dran -";
	String lineEndComma 			= "Sehr geehrter Kunsth�ndler Kahnweiler,";
	
	List<String> readText1 = Reader.readByLines(text1source);

	@Test
	public void testGibZeileInt() {
		Reader.readByLines(text1source);
		assertEquals(Reader.gibZeile(1) , text1arry1);
	}
	
	@Test
	public void testReadByLines() {
		assertEquals((Reader.readByLines(text1source)).toString(), text1arry);
	}

	@Test
	public void testGibZeileString() {
		Reader.readByLines(text1source);
		assertEquals(Reader.gibZeile(text1arry1) , 1);
	}

	@Test
	public void testLastInt() {
		Reader.readByLines(text1source);
		assertEquals(Reader.last(1) , text1arry1last);
	}

	@Test
	public void testLastString() {
		Reader.readByLines(text1source);
		assertEquals(Reader.last(text1arry1last) , "0");
	}

	@Test
	public void testReimChecker() {
		Reader.readByLines(text2source);
		assertTrue(Reader.reimChecker(1,2));
		assertFalse(Reader.reimChecker(2,3));
	}

	@Test
	public void testSortieren() {
		Reader.readByLines(text1source);
		assertEquals(Reader.sortieren(readText1), text1arrysorted);
	}

	@Test
	public void testInWelcherZeile() {
		Reader.readByLines(text1source);
		assertEquals(Reader.inWelcherZeile("Ordnung"), 1);	
	}

	@Test
	public void testNachLetztesWortSortieren() {
		Reader.readByLines(text1source);
		assertEquals(Reader.sortieren(readText1), text1arrysortedlast);
	}

}
