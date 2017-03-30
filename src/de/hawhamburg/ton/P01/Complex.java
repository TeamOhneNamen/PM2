package de.hawhamburg.ton.P01;

/**
 * An immutable class for complex numbers, modeled after the corresponding
 * Ruby class Complex (Complex Ruby Stdlib 1.8.7).
 * 
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 *
 */

public final class Complex extends Number {

	private double realNumber; // a
	private double imaginaryNumber; // b
	//public static Complex imaginary_unit; // i
	private double[] polarCoordinates;

	public Complex(double re, double im) {
		realNumber = re;
		imaginaryNumber = im;
	}
	
	//public final static void i_erzeugen(){
	//	imaginary_unit = new Complex(0, 1);
	//}

	public static void main(String[] args) {
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
		return new Complex(realNumber + (double) other, imaginaryNumber);
	}

	public Complex mul(Complex other) {
		return new Complex(realNumber * other.getRealNumber() - imaginaryNumber * other.getImaginaryNumber(),
				realNumber * other.getImaginaryNumber() + imaginaryNumber * other.getRealNumber());

	}

	public Complex mul(double other) {
		return new Complex(realNumber * other, realNumber * other);
	}

	public Complex mul(int other) {
		return new Complex(realNumber * (double) other, realNumber * (double) other);
	}

	public Complex div(Complex other) {
		return this.mul(other.conjugate().div(other.abs()));
	}

	public Complex div(double other) {
		return new Complex(realNumber / other, imaginaryNumber / other);
	}

	public Complex div(int other) {
		return new Complex(realNumber / (double) other, imaginaryNumber / (double) other);
	}

	public Complex pow(Complex other) {
		polar();
		double r = polarCoordinates[0];
		double theta = polarCoordinates[1];

		double ore = other.getRealNumber();
		double oim = other.getImaginaryNumber();

		double nr = Math.exp(ore * Math.log(r) - oim * theta);
		double ntheta = theta * ore + oim * Math.log(r);

		return polar(nr, ntheta);
	}

	public Complex pow(double other) {
		polar();
		double r = polarCoordinates[0];
		double theta = polarCoordinates[1];

		return polar(Math.pow(r, other), theta * other);
	}

	// Absolute value (aka modulus): distance from the zero point on the complex
	// plane.
	public double abs() {
		return Math.hypot(realNumber, imaginaryNumber);
	}

	public double abs2() {
		return realNumber * realNumber + imaginaryNumber * imaginaryNumber;
	}

	public double arg() {
		return Math.atan2(imaginaryNumber, realNumber);
	}

	// Creates a Complex number in terms of r (radius) and theta (angle).
	public Complex polar(double r, double theta) {
		return new Complex(r * Math.cos(theta), r * Math.sin(theta));
	}

	// returns an array with the polar coordinates by using the methods abs()
	// and arg().
	public double[] polar() {
		polarCoordinates[0] = abs();
		polarCoordinates[1] = arg();
		return polarCoordinates;
	}

	public Complex conjugate() {
		return new Complex(realNumber, -imaginaryNumber);
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
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
