/**
 * Julia.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P05;

import de.hawhamburg.ton.P01.*;

public class Julia  {
	private final Complex c;
	private Complex z0;

	public  final static int MAX_ITERATION = 100;
	public Julia(){
		this(Complex.ofCart(0.5, 0.5),Complex.ofCart(-0.79, 0.156));
	}
	public Julia(Complex z0, Complex c) {
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
		Julia other = (Julia) obj;
		return z0.equals(other.getZ0()) && c.equals(other.getC());
	}
}
