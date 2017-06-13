/**
 * JuliaSet.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P05;

import de.hawhamburg.ton.P01.*;

/**
 * 
 * @author Sandra Stankewitz
 * @author Hong Hai Le
 * @class This is a class Julia Set contains z0 and c.
 *
 */

public class JuliaSet  {
	//c is constant cannot change value after setting value
	private final Complex c;
	private Complex z0;

	public  final static int MAX_ITERATION = 100;
	//0.009, -0.685
	//-0.79, 0.156
	
	//default value
	public JuliaSet(){
		this(Complex.ofCart(0.5, 0.5),Complex.ofCart(-0.79, 0.156));
	}
	public JuliaSet(Complex z0, Complex c) {
		this.c = c;
		this.z0 = z0;
	}

	public Complex getZ0() {
		return Complex.ofCart(z0.getRealNumber(), z0.getImaginaryNumber());
	}


	public Complex getC() {
		return Complex.ofCart(c.getRealNumber(), c.getImaginaryNumber());
	}
	@Override
	public int hashCode() {
		return z0.hashCode() + c.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JuliaSet other = (JuliaSet) obj;
		return z0.equals(other.getZ0()) && c.equals(other.getC());
	}
}
