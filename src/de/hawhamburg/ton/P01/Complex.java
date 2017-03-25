package de.hawhamburg.ton.P01;

public class Complex extends Number{

	private double real_number; // a
	private double imaginary_number; //b
	private String imaginary_unit = "i"; // i
	
	public Complex() { //double[] args
		//real_number = args[0];
		//imaginary_number = args[1];
	}
	
	public double getReal_number(){
		return real_number;
	}
	
	public double getImaginary_number(){
		return real_number;
	}
	
	public void add(Number other){
		if (other instanceof Complex){
			//real_number = real_number + other.getReal_number;
			//imaginary_number = imaginary_number + other.imaginary_number;
			}
		if (other instanceof double){
			real_number = real_number + other;
			}
		if (other instanceof int){
			real_number = real_number + (double) other;
			}
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
	
	public String toString(){
		return(""+ real_number + " + " + imaginary_number + " * " + imaginary_unit); 
	}
	
	public double betrag(){
		return Math.sqrt(Math.pow(real_number, 2.0) + Math.pow(imaginary_number, 2.0));
	}
	
	public String konjugation(){
		return(imaginary_unit = "-i");
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
