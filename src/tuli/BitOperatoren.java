package tuli;
/**
 * 
 * @author Laura Westfalen
 * @author Marcel Tuleweit
 * 
 * Eine Klasse zum Experimentieren mit Javas Bitweisen Operatoren
 *
 */
public class BitOperatoren {
	
	public static void umrechnen(double zahl, int basis){
		
//		long vorzeichen = vorzeichen(Double.doubleToLongBits(zahl));
		long exponent = exponent(Double.doubleToLongBits(zahl));
		int exponentClear = (int) exponent - 1023;
		long mantisse = mantisse(Double.doubleToLongBits(zahl));
//		long clear_mant = (mantisse & 0b01111111111111111111111111111111111111111111111111111L);
		
		String mant = Long.toString(mantisse, basis);
		char[] erg = mant.toCharArray();
		
		if (basis == 2) {
			erg = BitOperatoren.addPos(erg, ++exponentClear, '.');
			System.out.println(erg);
			
		} else if (basis == 16) {
			String mantStr = Long.toHexString(mantisse*2);
			char[] ergStr = mantStr.toCharArray();
						
			ergStr = BitOperatoren.addPos(ergStr, exponentClear, '.');
			System.out.println(ergStr);

		} else {
			erg = BitOperatoren.addPos(erg, exponentClear, '.');
			System.out.println(erg);

		}
	}
	
	//Vorzeichen, Bit 63, Maske: 0x8000000000000000L 
	public static long vorzeichen(long bits){
		return (((bits&0x8000000000000000L) == 0)?1:-1); // Ist die Zahl positiv, ergibt die Methode 1, negativ -1
	}
	
	//Exponent, Bits 62-52, Maske: 0x7ff0000000000000L 
	public static long exponent(long bits){
		return (bits>>52)&(0xffff); // Vorzeichen rausschneiden mit &(0xffff)
	}
	
	//Mantisse, Bits 51-0, Maske: 0x000fffffffffffffL 
	public static long mantisse(long bits){
		return (exponent(bits) == 0) ? 
				(bits & 0x000fffffffffffffL) << 1 :
					(bits & 0x000fffffffffffffL) | 0x10000000000000L;
	}
	
	public static char[] addPos(char[] a, int pos, char num) {
	    char[] result = new char[a.length];
	    for(int i = 0; i < pos; i++)
	        result[i] = a[i];
	    result[pos] = num;
	    for(int i = pos + 1; i < a.length; i++)
	        result[i] = a[i - 1];
	    return result;
	}
	
//-------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
	long v1 = BitOperatoren.vorzeichen(Double.doubleToLongBits(Math.PI));
	long exp1 = BitOperatoren.exponent(Double.doubleToLongBits(Math.PI));
	long m1 = BitOperatoren.mantisse(Double.doubleToLongBits(Math.PI));
	
	long v2 = BitOperatoren.vorzeichen(Double.doubleToLongBits(Math.E));
	long exp2 = BitOperatoren.exponent(Double.doubleToLongBits(Math.E));
	long m2 = BitOperatoren.mantisse(Double.doubleToLongBits(Math.E));
	
	String v1b = Long.toBinaryString(vorzeichen(Double.doubleToLongBits(Math.PI)));
	String exp1b = Long.toBinaryString(exponent(Double.doubleToLongBits(Math.PI)));
	String m1b = Long.toBinaryString(mantisse(Double.doubleToLongBits(Math.PI)));
	
	String v2b = Long.toBinaryString(vorzeichen(Double.doubleToLongBits(Math.E)));
	String exp2b = Long.toBinaryString(exponent(Double.doubleToLongBits(Math.E)));
	String m2b = Long.toBinaryString(mantisse(Double.doubleToLongBits(Math.E)));
	

	System.out.print("PI:\t\t");
	System.out.println(Math.PI);
	System.out.print("Vorzeichen:\t");
	System.out.println(v1);
	System.out.print("Exponent:\t");
	System.out.println(exp1);
	System.out.print("Mantisse:\t");
	System.out.println(m1 + "\n");
	System.out.print("Insgesamt ergibt Pi" + 
		"(Vorzeichen * Mantisse * 2^(Exponent - 1075)): ");
	System.out.println(v1*m1*(Math.pow(2, (exp1 - 1075))));
	
	System.out.println("");
	System.out.print("PI binär:\t");
	System.out.println(Long.toBinaryString(Double.doubleToLongBits(Math.PI)));
	System.out.print("Vorzeichen:\t");
	System.out.println(v1b);
	System.out.print("Exponent:\t");
	System.out.println(exp1b);
	System.out.print("Mantisse:\t");
	System.out.println(m1b);
	System.out.println("");
	System.out.print("Insgesamt binär: ");
	BitOperatoren.umrechnen(Math.PI, 2);
	System.out.print("Insgesamt oktal: ");
	BitOperatoren.umrechnen(Math.PI, 8);
	System.out.print("Insgesamt hex: \t");
	BitOperatoren.umrechnen(Math.PI, 16);
	
	System.out.println("");
	System.out.println("----------------------------------------------------------------------------------- ");
	System.out.println("");
	System.out.print("E:\t\t");
	System.out.println(Math.E);
	System.out.print("Vorzeichen:\t");
	System.out.println(v2);
	System.out.print("Exponent:\t");
	System.out.println(exp2);
	System.out.print("Mantisse:\t");
	System.out.println(m2 + "\n");
	System.out.print("Insgesamt ergibt E" + 
		"(Vorzeichen * Mantisse * 2^(Exponent - 1075)): ");
	System.out.println(v2*m2*(Math.pow(2, (exp2 - 1075))));
	
	System.out.println("");
	System.out.print("E binär:\t");
	System.out.println(Long.toBinaryString(Double.doubleToLongBits(Math.E)));
	System.out.print("Vorzeichen:\t");
	System.out.println(v2b);
	System.out.print("Exponent:\t");
	System.out.println(exp2b);
	System.out.print("Mantisse:\t");
	System.out.println(m2b);
	System.out.println("");
	System.out.print("Insgesamt binär: ");
	BitOperatoren.umrechnen(Math.E, 2); 
	System.out.print("Insgesamt oktal: ");
	BitOperatoren.umrechnen(Math.E, 8);
	System.out.print("Insgesamt hex: \t");
	BitOperatoren.umrechnen(Math.E, 16);

	}

}
