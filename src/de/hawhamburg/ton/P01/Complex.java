package de.hawhamburg.ton.P01;

public final class Complex extends Number{

	private double real_number; // a
	private double imaginary_number; //b
	public final Complex imaginary_unit = new Complex(0,1); // i
	
	public Complex(double re, double im) {
		real_number = re;
		imaginary_number = im;
	}
	
	public static void main(String[] args) {
	}
	
	public double getReal_number(){
		return real_number;
	}
	
	public double getImaginary_number(){
		return imaginary_number;
	}
	
	public void add(Complex other){
		real_number = real_number + other.getReal_number();
		imaginary_number = imaginary_number + other.getImaginary_number();
	}
	
	public void add(double other){
		real_number = real_number + other;
		imaginary_number = imaginary_number + other;
	}
	
	public void add(int other){
		real_number = real_number + (double) other;
		imaginary_number = imaginary_number + (double) other;
	}
	
	public void multiply(double other){
		real_number = real_number * other;
		imaginary_number = imaginary_number * other;
	}
	
	public void divide(double other){
		real_number = real_number / other;
		imaginary_number = imaginary_number / other;
	}
	
	public void pow(double other){
		real_number = Math.pow(real_number, other);
		imaginary_number = Math.pow(imaginary_number, other);
	}
	
	//Absolute value (aka modulus): distance from the zero point on the complex plane. 
	public double abs(){
	  return Math.hypot(real_number, imaginary_number);
	}
	
	public double arg(){
	  return Math.atan2(imaginary_number, real_number);
	}
	
	public String toString(){
		return(""+ real_number + " + " + imaginary_number + " * " + imaginary_unit); 
	}
	
	//Creates a Complex number in terms of r (radius) and theta (angle).
	public Complex polar(double r, double theta){
		return new Complex(r*Math.cos(theta), r*Math.sin(theta));
	}
	
	public double polar(){
	  return real_number; 
	  return imaginary_number;
	}
	
	public Complex conjugate(){
	  return new Complex(real_number, - imaginary_number);
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
}
