package de.hawhamburg.ton.P01;
//import de.hawh.kahlbrandt.math.MathUtils;
/**
 * An immutable class for rational numbers, modeled after the corresponding
 * Ruby class Rational.
 * 
 * @author Bernd Kahlbrandt.
 *
 */
public class Rational implements Comparable<Rational> {
	public static final Rational ONE = new Rational(1, 1);
	public static final Rational ZERO = new Rational(0, 1);
	private int nominator;
	private int denominator;

	/**
	 * Default Constructor.
	 */
	public Rational() {
		this(0, 1);
	}

	/**
	 * Constructor that takes nominator and denominator as parameters.
	 * 
	 * @param denominator
	 * @param nominator
	 */
	public Rational(int nominator, int denominator) {
	    int gcd = MathUtils.gcd(nominator, denominator);
		this.nominator = nominator/gcd;
		this.denominator = denominator/gcd;
	}

	/**
	 * A copy constructor, that builds a copy of a Rational.
	 * 
	 * @param r
	 */
	public Rational(Rational r) {
		this(r.denominator, r.nominator);
	}

	/**
	 * @return The nominator.
	 */
	public int getNominator() {
		return nominator;
	}

	/**
	 * @return The denominator.
	 */
	public int getDenominator() {
		return denominator;
	}

	public Rational add(Rational b) {
		return new Rational();
	}

	public Rational add(int b) {
		return new Rational();
	}

	public Rational sub(Rational b) {
		return new Rational();
	}

	public Rational mult(Rational b) {
		return new Rational(this.denominator * b.denominator, this.nominator * b.nominator);
	}

	public Rational div(Rational b) {
		int newNenner = this.nominator * b.denominator;
		if(newNenner  == 0){
			throw new ArithmeticException("Divisor darf nicht 0 sein!");
		}
		return new Rational(this.denominator * b.nominator, newNenner);
	}

	public Rational inv(Rational b) {
		return new Rational(b.getDenominator(), b.getNominator());
	}

	public Rational abs() {
		return new Rational(Math.abs(nominator), Math.abs(denominator));
	}

	public double ceil() {
		return Math.ceil( this.denominator/this.nominator);
	}

	public double floor() {
		return Math.floor(this.denominator/this.nominator);
	}

	public double doubleValue() {
		return 0.0;
	}

	public int intValue() {
		return 0;
	}

	public double truncate() {
		return 0.0;
	}

	public double truncate(int precision) {
		return 0.0;
	}

	public boolean negative() {
		return false;
	}

	boolean positive() {
		return false;
	}
	@Override
	public String toString() {
		return "Rational [nenner=" + nominator + ", zaehler=" + denominator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nominator;
		result = prime * result + denominator;
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
		Rational other = (Rational) obj;
		if (nominator != other.nominator)
			return false;
		if (denominator != other.denominator)
			return false;
		return true;
	}

	@Override
	public int compareTo(Rational rat) {
		// TODO Auto-generated method stub
		return 0;
	}

}
