package tuli;
/**
 * 
 * @authors Laura Westfalen, Marcel Tuleweit
 * 
 * Eine Klasse zum Experimentieren mit den Methoden nanoTime() und currentTimeMillis()
 * und um den Ressourcenverbrauch der bitweisen Operatoren zu ermitteln.
 * nanoTime()
 *         Returns the current value of the most precise available system timer, in nanoseconds.
 * 
 * currentTimeMillis()
 *         Returns the current time in milliseconds.
 *         
 * Thread.sleep causes the current thread to suspend execution for a specified period.        
 */
public class RessVerbrauch {

	public static void main(String[] args) throws InterruptedException {

//------------------allgemeine Tests für currentTimeMillis() & nanoTime()--------------------------------------------------
		
		System.out.println("Allgemeine Tests:");
		// die aktuelle Zeit in Millisekunden wird unter a gespeichert
		long a = System.currentTimeMillis();
		// 2 Sekunden pausieren - 2000 Millisekunden 
		Thread.sleep(2000);
		// danach wird erneut die aktuelle Zeit gemessen
		long b = System.currentTimeMillis();
		// der Unterschied beträgt (etwa) 2000 Millisekunden
		System.out.print(b - a);
		System.out.println(" Millisekunden");
		
		
		// hier dasselbe mit der aktuellen Zeit in Nanosekunden
		long c = System.nanoTime();
		Thread.sleep(1000);
		long d = System.nanoTime();
		// das Ergebnis ergibt (etwa) 1.000.000.000 Nanosekunden - also 1000 Millisekunden
		System.out.print(d-c);
		System.out.println(" Nanosekunden");
		System.out.println("");
		
// -------------- Tests für Bitweise Operatoren -------------------------------------------------------------
		int zahl1 = 1234;
		int zahl2 = 5678;
		int zahl3 = 155;
		int zahl4 = 7;
		
		System.out.println("Bitweise Shift-Operatoren:");
		long start1 = System.nanoTime();
		zahl1 = zahl1 << 1;		// entspricht der Multiplikation mit 2
		long ende1 = System.nanoTime();
		long dauer1 = ende1 - start1;
		System.out.print(dauer1);
		System.out.println(" Nanosekunden hat ein Linksshift gebraucht."
				+ " Dies entspricht der Multiplikation mit 2.");
		
		long start1_2 = System.nanoTime();
		zahl1 = zahl1 * 2;
		long ende1_2 = System.nanoTime();
		long dauer1_2 = ende1_2 - start1_2;
		System.out.print(dauer1_2);
		System.out.println(" Nanosekunden hat die arithmetische Multiplikation mit 2 gebraucht.");
		// die arithmetische Multiplikation hat in etwa so lange wie der Shoft gebraucht
		
		
		long start2 = System.nanoTime();
		zahl2 = zahl2 << 20;	// entspricht der Multiplikation mit 2^(20)
		long ende2 = System.nanoTime();
		long dauer2 = ende2 - start2;
		System.out.print(dauer2);
		System.out.println(" Nanosekunden hat ein zweiter Linksshift gebraucht.");
		
		long start3 = System.nanoTime();
		zahl3 = zahl3 >> 1;		// entspricht der Division durch 2
		long ende3 = System.nanoTime();
		long dauer3 = ende3 - start3;
		System.out.print(dauer3);
		System.out.println(" Nanosekunden hat ein Rechtsshift gebraucht."
				+ " Dies entspricht der Division durch 2.");
		
		long start3_2 = System.nanoTime();
		zahl3 = zahl3 / 2;
		long ende3_2 = System.nanoTime();
		long dauer3_2 = ende3_2 - start3_2;
		System.out.print(dauer3_2);
		System.out.println(" Nanosekunden hat eine arithmetische Division durch 2.");	
		//die arithemtische Division braucht in etwa so lange wie der Shift
		
		long start4 = System.nanoTime();
		zahl4 = zahl4 >> 330;	// entspricht der Division durch 2^(330)
		long ende4 = System.nanoTime();
		long dauer4 = ende4 - start4;
		System.out.print(dauer4);
		System.out.println(" Nanosekunden hat ein weiterer Rechtsshift gebraucht.");
		System.out.println("");
		
		// meistens brauchen sowohl Rechts- als auch Linksshifts etwa 467 Nanosekunden
		// manchmal ergibt es aber auch 0 oder 982 Nanosekunden
		
//-----------------arithmetische Bitweise-Operatoren----------------------------------------------------------------------
		System.out.println("Bitweise arithmetische Operatoren:");
		long start5 = System.nanoTime();
		zahl1 = zahl1 & zahl2;	// bitweises AND verknüpft Bits mit UND
		long ende5 = System.nanoTime();
		long dauer5 = ende5 - start5;
		System.out.print(dauer5);
		System.out.println(" Nanosekunden hat eine Und-Operation gebraucht.");
		// meist ca 467	Nanosekunden
		
		long start6 = System.nanoTime();
		zahl3 = zahl3 | zahl4;	// bitweises OR verknüpft Bits mit ODER
		long ende6 = System.nanoTime();
		long dauer6 = ende6 - start6;
		System.out.print(dauer6);
		System.out.println(" Nanosekunden hat eine Oder-Operation gebraucht.");
		// meist ca 467	Nanosekunden
		
		long start7 = System.nanoTime();
		zahl3 = zahl3 ^ zahl4;	// bitweises XOR verknüpft Bits mit exklusivem ODER
		long ende7 = System.nanoTime();
		long dauer7 = ende7 - start7;
		System.out.print(dauer7);
		System.out.println(" Nanosekunden hat eine XOR-Operation gebraucht.");
		// meist ca 467	Nanosekunden
		
	}

}
