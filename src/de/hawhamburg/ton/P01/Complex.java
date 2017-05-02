package de.hawhamburg.ton.P01;

/**
 * An immutable class for complex numbers, modeled after the corresponding Ruby
 * class Complex (Complex Ruby Stdlib 1.8.7).
 * 
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 *
 * Das ist eine Klasse die in wesentlichen teilen eine Complexe Zahl repräsentiert
 */

public final class Complex {

	public static final Complex I = new Complex(0, 1);
	private double realNumber; // a
	private double imaginaryNumber; // b

	public static Complex ofCart(double re, double im) {
		return new Complex(re, im);
	}

	// Creates a Complex number in terms of r (radius) and theta (angle).
	// raus
	public static Complex ofPolar(double r, double theta) {
		return new Complex(r * Math.cos(theta), r * Math.sin(theta));
	}

	private Complex(double re, double im) {
		realNumber = re;
		imaginaryNumber = im;
	}

	public static void main(String[] args) { // raus
		//System.out.println(Complex.ofCart(0.0, 1.0).polar());
		//System.out.println(Complex.ofCart(0.0, 1.0).hashCode());
		System.out.println(Complex.ofCart(1.0, 1.0).abs());
		//System.out.println(Math.abs(1.23 - 2.3));
		
		
	}

	public double getRealNumber() {
		return realNumber;
	}

	public double getImaginaryNumber() {
		return imaginaryNumber;
	}

	public Complex add(Complex other) {
		return new Complex(realNumber + other.getRealNumber(), imaginaryNumber + other.getImaginaryNumber());
	}

	public Complex add(double other) {
		return new Complex(realNumber + other, imaginaryNumber);
	}

	public Complex add(int other) {
		return new Complex(realNumber + ((Integer)other).doubleValue(), imaginaryNumber);
	}

	public Complex mul(Complex other) {
		return new Complex(realNumber * other.getRealNumber() - imaginaryNumber * other.getImaginaryNumber(),
				realNumber * other.getImaginaryNumber() + imaginaryNumber * other.getRealNumber());
	}

	public Complex mul(double other) {
		return new Complex(realNumber * other, realNumber * other);
	}
	
	public Complex mul(int other) {
		return new Complex(realNumber * ((Integer)other).doubleValue(), realNumber * ((Integer)other).doubleValue());
	}

	public Complex div(Complex other) {
		return this.mul(other.conjugate().div(other.abs()));
	}

	public Complex div(double other) {
		return new Complex(realNumber / other, imaginaryNumber / other);
	}

	public Complex div(int other) {
		return new Complex(realNumber / ((Integer)other).doubleValue(), imaginaryNumber / ((Integer)other).doubleValue());
	}

	public Complex pow(Complex other) { // in die Utility
		double[] temp = polar();
		double r = temp[0];
		double theta = temp[1];

		double ore = other.getRealNumber();
		double oim = other.getImaginaryNumber();

		double nr = Math.exp(ore * Math.log(r) - oim * theta);
		double ntheta = theta * ore + oim * Math.log(r);

		return ofPolar(nr, ntheta);
	}

	public Complex pow(double other) {
		double[] temp = polar();
		double r = temp[0];
		double theta = temp[1];

		return ofPolar(Math.pow(r, other), theta * other);
	}

	public Complex mod(Complex other){
		return new Complex(realNumber % other.getRealNumber(), imaginaryNumber % other.getImaginaryNumber());
	}
	
	public Complex mod(double other){
		return new Complex(realNumber % other, imaginaryNumber % other);
	}
	
	//remove casts!!
	public Complex mod(int other){
		return new Complex(realNumber % (double) other, imaginaryNumber % (double) other);
	}
	
	// Absolute value (aka modulus): distance from the zero point on the complex
	// plane.
	// hypot returns sqrt(x**2 + y**2), the hypotenuse of a right-angled
	// triangle with sides x and y.
	public double abs() {
		return Math.hypot(realNumber, imaginaryNumber);
	}

	public double abs2() {
		return realNumber * realNumber + imaginaryNumber * imaginaryNumber;
	}

	public double arg() {
		return Math.atan2(imaginaryNumber, realNumber);
	}

	// returns an array with the polar coordinates by using the methods abs()
	// and arg().
	public double[] polar() {
		double[] result = new double[2];
		result[0] = abs();
		result[1] = arg();
		return result;
	}

	public Complex conjugate() {
		return new Complex(realNumber, -imaginaryNumber);
	}

	public boolean equals(Object other) {
		  if (other.getClass() == Double.class) {
			return (imaginaryNumber == 0 && realNumber == (double)other);
		}else if (other.getClass() == Integer.class) {
			return (imaginaryNumber == 0 && realNumber == (double)((int)other));
		}else if (other.getClass() == Complex.class){
			return (realNumber == ((Complex)other).getRealNumber() && imaginaryNumber == ((Complex)other).getImaginaryNumber());
		}else {
			return false;
		}
	}
	
	//does this method works without boxing?
	public int hashCode() {
		Double re = (Double) realNumber;
		Double im = (Double) imaginaryNumber;
		return Math.abs((re.hashCode() - im.hashCode())); 
	}

	public String toString() {
		if (realNumber != 0) {

			if (imaginaryNumber >= 0) {
				return ("" + realNumber + "+(" + imaginaryNumber + ")i");
			} else {
				return ("" + realNumber + "-(" + (-imaginaryNumber) + ")i");
			}

		} else {
			return ("" + imaginaryNumber + "i");
		}
	}
}
