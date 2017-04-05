/**
 * ComplexTest.java tests if the Class has the same attributes as 
 * the corresponding Ruby class Complex (Complex Ruby Stdlib 1.8.7).
 * 
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P01;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest {
	
	public Complex comp1 = Complex.ofCart(0.0, 1.0);

	@Test
	public void testOfCartOfPolar() {
		assertEquals(Complex.ofCart(0.0, 1.0), Complex.ofPolar(1.0, 1.5707963267948966));
	}
	
	@Test
	public void abs() {
		assertEquals(Complex.ofCart(0.0, 1.0).abs(), 1.0, 0.0);
		
	}
	
	@Test
	public void equals() {
		assertTrue(comp1.equals(1.0));
		assertFalse(comp1.equals("Hallo"));
		
	}


}
