package tuli.Complex;

/**
 * Eine Klasse für komplexe Zahlen, deren Objekte mutable sind.
 * 
 * @author Marcel Tuleweit, Laura Westfalen
 *
 */

public class Complex {
	private double real;
	private double imag;
	public static Complex ZERO = new Complex();
	public static Complex ONE = new Complex(1);

// ---------------------------------Konstruktoren-----------------------------------------------------------------------

	/**
	 * Der Default-Konstruktor
	 */
	public Complex() {
		this(.0,.0);
	}
	
	/**
	 * Konstruktor für eine reele Zahl
	 * @param double real (der Realanteil der Zahl)
	 */
	public Complex(double real) {
		this(real, 0);
	}
	
	/**
	 * Der Konstruktor für eine komplexe Zahl mit Real- und Imaginäranteil
	 * @param double real (der Realanteil der Zahl)
	 * @param double imag (der Imaginäranteil der Zahl)
	 */
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	/**
	 * Der Copy Konstruktor
	 * @param Complex obj (das zu kopierende Objekt)
	 */
	public Complex(Complex obj) {
		this.real = obj.real;
		this.imag = obj.imag;
	}
	
	/**
	 * Ein Konstruktor für eine komplexe Zahl
	 * @param double real (der Realanteil der Zahl)
	 * @param double imag (der Imaginäranteil der Zahl)
	 * @return Complex  (eine neue komplexe Zahl)
	 */
	public static Complex of_Cartesian(double real, double imag) {
		return new Complex(real,imag);
	}
	
	/**
	 * Ein Konstruktor für eine komplexe Zahl, der die Polarkoordinaten übergeben bekommt
	 * @throws NumberFormatException falls alpha < 0
	 * @param double length (der Betrag der Zahl)
	 * @param double alpha (der Winkel der Zahl)
	 * @return Complex  (eine neue komplexe Zahl)
	 */
	public static Complex of_Polar(double length, double alpha) {
		if (alpha < 0) {
			throw new NumberFormatException("Alpha muss größer 0 sein!");
		}
		else {
			return new Complex(Math.cos(alpha)*length,Math.sin(alpha)*length);
		}
	}

// --------------------Getter-----------------------------------------------------------------------------------------------

		/**
		 * ein Getter für den Betrag (der Polardarstellung)
		 * @return double
		 */
		public double getLength() {
			return Math.sqrt(Math.pow(real, 2)+Math.pow(imag, 2));
		}
		
		/**
		 * ein Getter für den Winkel (der Polardarstellung)
		 * @return double
		 */
		public double getAlpha() {
			if (real < 0 && imag < 0) {
				return Math.atan(imag/real) + Math.PI;
			}
			else {
				return Math.atan(imag/real);
			}
		}
		
		/**
		 * ein Getter für den Realanteil
		 * @return double
		 */
		public double getReal() {
			return this.real;
		}

		/**
		 * ein Getter für den Imaginäranteil
		 * @return double
		 */
		public double getImag() {
			return this.imag;
		}
		
		
		/**
		 * Überprüft ob die komplexe Zahl rational ist (also der Imaginärteil = 0)
		 * @return boolean
		 */
		public boolean isRational() {
			return (imag == 0);
		}
		
// ------------------------Setter-----------------------------------------------------------------------------------------
	/**
	 * negiert eine komplexe Zahl
	 * @return Complex (gibt das Objekt selbst zurück)
	 */
	public Complex invert() {
			this.real = (-real);
			this.imag = (-imag);
			return this;
	}

	/**
	 * konjugiert eine komplexe Zahl
	 */
	public void conjugate() {
		if (imag != 0) {
			this.imag = -imag;
		}
	}
	
	/**
	 * Wandelt eine komplexe Zahl in eine rationale Zahl um (setzt den Imaginärwert auf 0)
	 * @return Complex (das Objekt selbst)
	 */
	public Complex setRational() {
		this.imag = 0;
		return this;
	}
	
//-------------------------Rechenmethoden----------------------------------------------------------------------------------
	
	/**
	 * addiert zwei komplexe Zahlen
	 * @param Complex other
	 * @return Complex (gibt das veränderte Objekt zurück)
	 */
	public Complex add(Complex other){
		this.real = (this.real + other.real);
		this.imag = (this.imag + other.imag);
		return this;
	}
	
	/**
	 * subtrahiert ein Complex vom Objekt
	 * @param Complex other (der Subtrahend)
	 * @return Complex (das veränderte Objekt)
	 */
	public Complex sub(Complex other){
		this.real = (this.real - other.real);
		this.imag = (this.imag - other.imag);
		return this;
	}
	
	/**
	 * multipliziert 2 komplexe Zahlen
	 * @param Complex other (der Faktor)
	 * @return Complex (das veränderte Objekt)
	 */
	public Complex mult(Complex other){
		double thisreal = this.real;
		this.real = ((this.real * other.real) - (this.imag * other.imag));
		this.imag = ((thisreal * other.imag) + (this.imag * other.real));
		return this;
	}
	
	/**
	 * dividiert 2 komplexe Zahlen
	 * @param Complex other (der Divisor)
	 * @return Complex this (das veränderte Objekt)
	 */
	public Complex div(Complex other){
		this.real = (this.real * other.real) / ((other.real*other.real) + (other.imag*other.imag));
		this.imag = (this.imag * other.real) / ((other.real*other.real) + (other.imag*other.imag));
		return this; 
	}
	
	/** 
	 * quadriert eine komplexe Zahl
	 * @return Complex this (das veränderte Objekt)
	 */
	public Complex square() {
		double thisreal = this.real;
		this.real = Math.pow(this.real, 2) - Math.pow(this.imag, 2);
		this.imag = 2 * thisreal * this.imag;
		return this;
	}
	
	/**
	 * potenziert ein Complex mit einer natürlichen Zahl
	 * @param int exp
	 * @return Complex this
	 */
	public Complex pow(int exp){
		Complex this_copy = new Complex(this.real, this.imag);
		for(int i = 0; i < (exp-1); i++){
			this.mult(this_copy);
		}
		return this;
	}
	
//----------------Override-Methoden-----------------------------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imag);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if ((!(obj instanceof Complex))){
			return false;	
		}
		
//		if (this == obj){
//			return true;
//			
//		}
		else if(obj instanceof Complex){
			return ( (this.real == ((Complex) obj).getReal()) && this.imag == ((Complex) obj).getImag() );
		
//		}else if((obj instanceof Number) && this.isRational() && ((double) obj == this.real) ){
//			return ( (this.real == ((Complex) obj).getReal()) && this.imag == ((Complex) obj).getImag() );
		
		}else{
			return false;	
		}		
	}

	@Override
	public String toString() {
		return "z = " + real + " + i * " + imag;
	}
}