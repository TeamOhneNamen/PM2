/**
 * ComplexTest.java tests if the Class has the same attributes as 
 * the corresponding Ruby class Complex (Complex Ruby Stdlib 1.8.7) and
 * has all demanded attributes .
 * 
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P01;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest {
	
	public Complex comp1 = Complex.ofCart(1.0, 0.0);
	public Complex comp2 = Complex.ofCart(1.0, 0.0);
	public Complex comp3 = Complex.ofCart(5.0, 0.0);
	public Complex comp4 = Complex.ofCart(1.0, 1.0);
	
	// all took from the equivalent method in ruby
	public double arg 	= 0.7853981633974483; 	//Complex(1.0,1.0).arg
	public double abs 	= 1.4142135623730951; 	//Complex(1.0,1.0).abs
	public double abs2 	= 2.0;					//Complex(1.0,1.0).abs2

	
	public double dou = 1.0;
	public double highdou = 1234.567;
	public double negdou = -1.0;
	
	public String str = "Hallo";
	public int inte = 1;

	@Test
	public void testOfCartOfPolar() {
		assertEquals(Complex.ofCart(0.0, 1.0).abs(), Complex.ofPolar(1.0, 1.5707963267948966).abs(), 0.0);
		assertNotEquals(Complex.ofCart(0.0, 1.0).abs(), Complex.ofPolar(1.0, 2.3).abs());
	}
	
	@Test
	public void abs() {
		// complex with imaginaryNumber = 0, realNumber > 0
		assertEquals(comp1.abs(), dou, Math.abs(dou - 1.0));
		assertEquals(comp1.abs(), highdou, Math.abs(highdou - 1.0));
		assertEquals(comp1.abs(), negdou, Math.abs(negdou - 1.0));
		
		assertNotEquals(comp1.abs(), highdou);
		
		// complex with imaginaryNumber > 0, realNumber > 0
		assertEquals(comp4.abs(), dou, Math.abs(dou - 1.4142135623730951));
		assertEquals(comp4.abs(), highdou, Math.abs(highdou - 1.4142135623730951));
		assertEquals(comp4.abs(), negdou, Math.abs(negdou - 1.4142135623730951));
		
		assertNotEquals(comp4.abs(), dou);
	}
	
	@Test
	public void equals() {
		assertTrue(comp1.equals(dou));
		assertTrue(comp1.equals(inte));
		assertFalse(comp1.equals(str));
		
		assertTrue(comp1.equals(comp1));
		assertTrue(comp1.equals(comp2));
		assertFalse(comp1.equals(comp3));
	}
	
	@Test
	public void sameValuesRuby(){
		assertEquals(comp4.arg(),arg, 0.00);
		assertEquals(comp4.abs(),abs, 0.00);
		assertEquals(comp4.abs2(),abs2, 0.00);
		//if arg and abs working, the method polar is also working
	}
}
