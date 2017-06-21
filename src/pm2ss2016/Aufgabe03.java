/**
 * Aufgabe03.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2ss2016;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aufgabe03 {

	public static void main(String[] args) {
		int teilnehmer = 50;
		
		//Klausureinsicht: 01.07.2017 12:00
		LocalDateTime klausureinsicht = LocalDateTime.of(2016, 07, 01, 12, 00);
		
		//Korrektur: 28.06.2016 6:00
		LocalDateTime korrekturbeginn = LocalDateTime.of(2016, 06, 28, 6, 00);
		
		//Zeit zum korrigieren
		long zk = ChronoUnit.MINUTES.between(korrekturbeginn, klausureinsicht);
		
		//Zeit zum korrigieren pro Klausur
		long zkpk = zk / teilnehmer;
		
		
		long zkpk_pause = (zk - (ChronoUnit.DAYS.between(korrekturbeginn, klausureinsicht) * 8 * 60)) / teilnehmer;
		System.out.println(zk);
		System.out.println(zkpk);
		System.out.println(zkpk_pause);
	}

}
