package tuli;

/**
 * @author Marcel Tuleweit, Laura Westfalen
 *
 */
import de.haw.marcel.logo.Logo;

public class UngeradeZahl {
	private int zahl;

	public UngeradeZahl(int zahl){
		
		this.zahl = zahl;
	}
	
	public int getZahl() {
		return zahl;
	}

	public void setZahl(int zahl) {
		this.zahl = zahl;
	}

	// 1. In Java gibt es den Modulo Operator %, in Ruby % und divmod.
	// Was sind die Unterschiede: Schreiben Sie dafür bitte Beispiel Code!
	
	// - Der Modulo Operator teilt eine Zahl (linker Operand) durch einen 
	//   Quotienten (rechter Operand) und gibt den Rest zurück.
	// - In Ruby ist % eine Methode, welche überschrieben werden könnte,
	//   In Java ist % wiederum ein Operator.
	// - Die divmod-Methode aus Ruby benötigt ebenfalls eine Zahl und einen 
	//   Quotienten, gibt jedoch Ergebnis und Rest als Array zurück.
	public static int modulo(int a, int b) {
		return a % b;
	}

	// Hier eine Anwendung: Die folgende Methode isOdd soll prüfen, ob eine ganze Zahl ungerade ist:
	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}
	// Was liefert dieser Code, liefert er das korrekte Ergebnis und wann? Begründen Sie bitte Ihre Antwort!
	
	// - Er liefert einen Wahrheitswert "true", wenn eine positive Zahl ungerade ist und "false", wenn nicht.
	// - Nein, er liefert nur teilweise das korrekte Ergebnis, nämlich immer dann, wenn das aufrufende Objekt
	//   ein Objekt der selben Klasse und die übergebene Zahl positiv und vom Typ Integer ist.
	// - Wird hier eine negative Zahl übergeben, gibt der %-Operator eine -1 zurück,
	//   hier würde die Methode "false" zurückgeben, obwohl -1 eine ungerade Zahl ist.
	// - Eine Methode, die sowohl positive, als auch negative Zahlen abdeckt, wäre beispielsweise folgende:
	public static boolean isOdd2(int i) {
		return i % 2 != 0;
	}
	
	public static void main(String[] args) {
		UngeradeZahl odd = new UngeradeZahl(1);
		UngeradeZahl nodd = new UngeradeZahl(2);
		UngeradeZahl bigodd = new UngeradeZahl(996326841);
		UngeradeZahl odd2 = new UngeradeZahl(1);
		UngeradeZahl odd_neg = new UngeradeZahl(-1);
		
	// Hier habe ich nochmal einige Proben aufgeführt,
	// mit deren Hilfe meine Antworten veranschaulicht werden können:
		
		System.out.println(UngeradeZahl.isOdd(odd.zahl)); // => true
		System.out.println(UngeradeZahl.isOdd(nodd.zahl)); // => false
		System.out.println(UngeradeZahl.isOdd(bigodd.zahl)); // => true
		System.out.println(UngeradeZahl.isOdd(odd_neg.zahl)); // => false | fehlerhafte Methode*
		System.out.println(UngeradeZahl.isOdd2(odd_neg.zahl)); // => true | korrigierte Methode**
		System.out.println(UngeradeZahl.modulo(11, 3)); // => 2
		System.out.println(odd.equals(odd)); // => true
		System.out.println(odd.equals(nodd)); // => false
		System.out.println(odd.equals(odd2)); // => true
		Logo.main(args);;
		
	// *  Die fehlerhafte Methode wertet die Zahl -1 falsch aus und gibt "false" zurück, obwohl -1 ungerade ist.
	// ** Die korrigierte Methode gibt auch bei der negativen Zahl -1 das korrekte Ergebnis "true" zurück.
	}
	
	// Untersuchen Sie bitte, ob die Methode equals in Java auf den Objekten einer Klasse
	// eine Äquivalenzrelation definiert! Geben Sie ggf. Gegenbeispiele an!
	// Wie sieht das für die entsprechende Methode in Ruby aus?
	
	// - Eine korrekte Implementierung der Methode equals() bildet keine Äquivalenzrelation.
	//   Die equals()-Methode ist nicht reflexiv, im Falle von NaN beispielsweise ist a != a.
	// - In Ruby entspricht equals() der Methode ==, welche ebenfalls überschrieben werden kann.
	//   Sie prüft ebenfalls auf objektspezifische Gleichheit.
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + zahl;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UngeradeZahl other = (UngeradeZahl) obj;
		if (zahl != other.zahl)
			return false;
		return true;
	}
}