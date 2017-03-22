package de.hawhamburg.ton.P01;

public class Complex {

	private double a;
	private double b;
	private double i;
	
	public Complex() {
		// TODO Auto-generated constructor stub
	}
	
	public double add(double other){
		return this.a + other; 
	}
	
	public String toString(){
		return(""+a + b * i); 
	}
}
