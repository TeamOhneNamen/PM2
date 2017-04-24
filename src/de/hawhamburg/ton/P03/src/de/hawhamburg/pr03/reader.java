package de.hawhamburg.pr03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class reader {

	public static void main(String[] args) {

		File file = new File("C:/picasso.txt");

		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (sc != null) {

			while (sc.hasNextLine()) {

				untersuchen(sc.nextLine());

			}

		} else {

			throw new NullPointerException();

		}
	}
	
	public static void untersuchen(String line) {
	
		System.out.println(line);
		
	}
	

}
