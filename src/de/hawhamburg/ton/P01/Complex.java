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

	private double real_number; // a
	private double imaginary_number; // b
	//public static Complex imaginary_unit; // i
	private double[] polar_coordinates;

	public Complex(double re, double im) {
		real_number = re;
		imaginary_number = im;
	}
	
	//public final static void i_erzeugen(){
	//	imaginary_unit = new Complex(0, 1);
	//}

	public static void main(String[] args) {
	}

	public double getReal_number() {
		return real_number;
	}

	public double getImaginary_number() {
		return imaginary_number;
	}

	public Complex add(Complex other) {
		return new Complex(real_number + other.getReal_number(), imaginary_number + other.getImaginary_number());
	}

	public Complex add(double other) {
		return new Complex(real_number + other, imaginary_number);
	}

	public Complex add(int other) {
		return new Complex(real_number + (double) other, imaginary_number);
	}

	public Complex mul(Complex other) {
		return new Complex(real_number * other.getReal_number() - imaginary_number * other.getImaginary_number(),
				real_number * other.getImaginary_number() + imaginary_number * other.getReal_number());

	}

	public Complex mul(double other) {
		return new Complex(real_number * other, real_number * other);
	}

	public Complex mul(int other) {
		return new Complex(real_number * (double) other, real_number * (double) other);
	}

	public Complex div(Complex other) {
		return this.mul(other.conjugate().div(other.abs()));
	}

	public Complex div(double other) {
		return new Complex(real_number / other, imaginary_number / other);
	}

	public Complex div(int other) {
		return new Complex(real_number / (double) other, imaginary_number / (double) other);
	}

	public Complex pow(Complex other) {
		polar();
		double r = polar_coordinates[0];
		double theta = polar_coordinates[1];

		double ore = other.getReal_number();
		double oim = other.getImaginary_number();

		double nr = Math.exp(ore * Math.log(r) - oim * theta);
		double ntheta = theta * ore + oim * Math.log(r);

		return polar(nr, ntheta);
	}

	public Complex pow(double other) {
		polar();
		double r = polar_coordinates[0];
		double theta = polar_coordinates[1];

		return polar(Math.pow(r, other), theta * other);
	}

	// Absolute value (aka modulus): distance from the zero point on the complex
	// plane.
	public double abs() {
		return Math.hypot(real_number, imaginary_number);
	}

	public double abs2() {
		return real_number * real_number + imaginary_number * imaginary_number;
	}

	public double arg() {
		return Math.atan2(imaginary_number, real_number);
	}

	// Creates a Complex number in terms of r (radius) and theta (angle).
	public Complex polar(double r, double theta) {
		return new Complex(r * Math.cos(theta), r * Math.sin(theta));
	}

	// returns an array with the polar coordinates by using the methods abs()
	// and arg().
	public double[] polar() {
		polar_coordinates[0] = abs();
		polar_coordinates[1] = arg();
		return polar_coordinates;
	}

	public Complex conjugate() {
		return new Complex(real_number, -imaginary_number);
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
		if (real_number != 0) {

			if (imaginary_number >= 0) {
				return ("" + real_number + "+(" + imaginary_number + ")i");
			} else {
				return ("" + real_number + "-(" + (-imaginary_number) + ")i");
			}

		} else {
			return ("" + imaginary_number + "i");
		}
	}
}
