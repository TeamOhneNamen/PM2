/**
 * StreamsKnuth.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.sun.xml.internal.ws.util.StringUtils;

public class StreamsKnuth {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(new FileInputStream (new File("src/de/hawhamburg/ton/P06/bible.txt"))));
		
		ArrayList<String> all_3_16 = new ArrayList<String>();
		
		bufferedReader
		.lines()
		.filter(str -> {return str.contains("3:16");})
		.forEach(str -> StringUtils.countMatches(StringUtils.lowerCase(str), "the"));
		
		System.out.println(all_3_16);
		System.out.println(all_3_16.size());
	}

}
