package tuli.A3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class TextTest {
	
	private Text testObject1;
	private Text testObject2;

	@Before
	public void setup() {
		try {
			testObject1 = new Text("picasso.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		File file = new File("picasso.txt");
		try {
			FileInputStream input = new FileInputStream(file);
			testObject2 = new Text(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	@Test
	public void testGetLastChange() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd \nH:m:s");
		assertEquals(LocalDateTime.now().format(formatter),(testObject1.getLastChange()));
		System.out.println("WAIT FOR DELAY");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		System.out.println("DELAY FINISHED");
		assertNotEquals(LocalDateTime.now().format(formatter),(testObject1.getLastChange()));
	}

	@Test
	public void testGetLine() {
		assertEquals(testObject1.getLine(15),("Sie schaffen nicht mal Tuben an."));
	}
	
	@Test
	public void testgetLastWordOfLine() {
		assertEquals(testObject1.getLine(26),("Mein Herr! Sie haben Braque bedacht,"));
		assertEquals(testObject1.getLastWordOfLine(26),"bedacht");
		
		assertEquals(testObject1.getLine(27),("und der hat nichts als Quack gebracht."));
		assertEquals(testObject1.getLastWordOfLine(27),"gebracht");
	}

	@Test
	public void testGetLineNumber(){
		assertEquals("Wie wenig ein Verriss bewegt,",(testObject1.getLine(44)));
		assertEquals("Sie schaffen nicht mal Tuben an.",(testObject2.getLine(15)));
		
		assertEquals(44,testObject1.getLineNumber("Wie wenig ein Verriss bewegt,"));
		assertEquals(15,testObject2.getLineNumber("Sie schaffen nicht mal Tuben an."));
	}

	@Test
	public void testRestore() {
		String testString = testObject1.toString();
		//verï¿½ndert testObject1
		testObject1.sortLines();
		assertNotEquals(testString,(testObject1.toString()));
		// stellt testObject1 wieder her
		testObject1.restore();
		assertEquals(testString,(testObject1.toString()));	
	}

	@Test
	public void testSortLines() {
		testObject1.sortLines();
		assertEquals(testObject1.getLine(1),("Da jeder, sofern Bares lacht,"));		
	}

	@Test
	public void testSortLinesByLastWord() {
		testObject1.sortLinesByLastWord();
		assertEquals(testObject1.getLine(1),("doch lässt mich unser Blätterwald"));	
	}
}
