package de.hawh.ml.complex;

/**
 * @author Marcel Tuleweit, Laura Westfalen
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import de.hawh.ml.complex.Complex;

public class ComplexTest {
	private Complex com1;
	private Complex com2;
	private Complex com3;
	private Complex com_zero;
	private Complex rational;
	
	private static final double DELTA = 0.00000001;

	@Before
	public void setUp() throws Exception {
		com1 = new Complex(3,4);
		com2 = new Complex(3,4);
		com3 = new Complex(5,3);
		com_zero = new Complex(0,0);
		rational = new Complex(3,0);
	}

	@Test
	public final void testHashCode() {
		assertEquals(com2.hashCode(), com1.hashCode());
		assertNotEquals(com3.hashCode(), com1.hashCode());
	}

	@Test
	public final void testComplex() {
		assertEquals(com1, new Complex(3,4));
		assertNotEquals(com1, new Complex(4,4));
		assertEquals(com_zero, new Complex(0,0));
		assertEquals(rational, new Complex(3,0));
		assertNotEquals(com2, new Complex(-3,4));
		assertNotEquals(com3, new Complex(5,-3));
	}

	@Test
	public final void testOfCartesian() {
		Complex com1 = Complex.of_Cartesian(5,3);
		assertEquals(com1, com3);
		assertEquals(com1.getReal(), com3.getReal(), DELTA);
		assertEquals(com1.getImag(), com3.getImag(), DELTA);
	}

	@Test
	public final void testOfPolar() {
		Complex com1 = Complex.of_Polar(5,0.9272952180016122);
		Complex com2 = Complex.of_Polar(5,0.9272952180016122);
		assertEquals(com2, com1);
		assertEquals(3, com1.getReal(), DELTA);
		assertEquals(4, com1.getImag(), DELTA);
		assertNotEquals(-3, com2.getReal(), DELTA);
		assertNotEquals(5, com2.getImag(), DELTA);
	}
	
	@Test(expected = NumberFormatException.class)
	public final void testSetPolarException() {
		Complex.of_Polar(2,-4.5);
	}

	@Test
	public final void testInvert() {
		assertEquals(com1.invert(), new Complex(-3,-4));
		assertNotEquals(com1, new Complex(3,4));
		assertEquals(rational.invert(), new Complex(-3,0));
		assertEquals(com_zero.invert(), com_zero);
	}

	@Test
	public final void testConjugate() {
		com1.conjugate();
		com2.conjugate();
		com3.conjugate();
		rational.conjugate();
		com_zero.conjugate();
		assertEquals(com1, new Complex(3,-4));
		assertNotEquals(com2, new Complex(-3,4));
		assertNotEquals(com3, new Complex(-5,-3));
		assertEquals(rational, new Complex(3,0));
		assertEquals(com_zero, new Complex(0,0));
	}

	@Test
	public final void testIsRational() {
		assertTrue(rational.isRational());
		assertFalse(com1.isRational());
		assertTrue(com1.setRational().isRational());
	}
	
	@Test
	public final void testSetRational() {
		assertEquals(com1.setRational(), new Complex(3,0));
		assertEquals(com_zero.setRational(), new Complex(0,0));
		assertEquals(rational.setRational(), com1.setRational());
		assertNotEquals(com1.setRational(), new Complex(0,0));
		assertNotEquals(com2.setRational(), new Complex(3,4));
	}

	@Test
	public final void testGetLength() {
		assertEquals(5, com1.getLength(), DELTA);
		assertEquals(3, rational.getLength(), DELTA);
		assertNotEquals(5, com3.getLength(), DELTA);
	}

	@Test
	public final void testGetAlpha() {
		assertEquals(0.9272952180016122, com1.getAlpha(), DELTA);
		assertEquals(0.5404195002705842, com3.getAlpha(), DELTA);
		assertNotEquals(0.5404195002705842, com2.getAlpha(), DELTA);
	}

	@Test
	public final void testGetReal() {
		assertEquals(3, com1.getReal(), DELTA);
		assertEquals(5, com3.getReal(), DELTA);
		assertEquals(3, rational.getReal(), DELTA);
		assertEquals(0, com_zero.getReal(), DELTA);
		assertEquals(-3, com1.invert().getReal(), DELTA);
		assertNotEquals(3, com1.getReal(), DELTA);
		assertNotEquals(0, rational.getReal(), DELTA);
	}

	@Test
	public final void testGetImag() {
		assertEquals(4, com1.getImag(), DELTA);
		assertEquals(3, com3.getImag(), DELTA);
		assertEquals(0, rational.getImag(), DELTA);
		assertEquals(0, com_zero.getImag(), DELTA);
		assertEquals((-4), com1.invert().getImag(), DELTA);
		assertNotEquals(4, com1.getImag(), DELTA);
		assertNotEquals(3, rational.getImag(), DELTA);
	}

	@Test
	public final void testAdd() {
		Complex com_add1 = new Complex(2, 5);
		Complex com_add2 = new Complex(2.345, 5.4321);
		Complex c1 = new Complex(3,4);
		Complex c2 = new Complex(3,4);

		// com1 + com_add1
		assertEquals(5.0, com1.add(com_add1).getReal(), DELTA);
		assertEquals(9.0, com2.add(com_add1).getImag(), DELTA);

		// com1 + com_add2
		assertEquals(5.345, c1.add(com_add2).getReal(), DELTA);
		assertEquals(9.4321, c2.add(com_add2).getImag(), DELTA);
	}

	@Test
	public final void testSub() {
		Complex c1 = new Complex(3,4);
		Complex c2 = new Complex(3,4);
		
		Complex com_sub1 = new Complex(2, 8);
		Complex com_sub2 = new Complex(2.345, 8.4321);

		// com1 + com_sub1
		assertEquals(1.0, com1.sub(com_sub1).getReal(), DELTA);
		assertEquals(-4.0, com2.sub(com_sub1).getImag(), DELTA);

		// com1 + com_sub2
		assertEquals(0.655, c1.sub(com_sub2).getReal(), DELTA);
		assertEquals(-4.4321, c2.sub(com_sub2).getImag(), DELTA);
	}

	@Test
	public final void testMult() {
		Complex c1 = new Complex(3,4);
		Complex c2 = new Complex(3,4);
		Complex com_mult1 = new Complex(7, 3);
		Complex com_mult2 = new Complex(-7.5, 3.2);

		// com1 * com_mult1
		assertEquals(9, com1.mult(com_mult1).getReal(), DELTA);
		assertEquals(37, com1.getImag(), DELTA);
		assertEquals(37, com2.mult(com_mult1).getImag(), DELTA);

		// com1 * com_mult2
		assertEquals(-35.3, c1.mult(com_mult2).getReal(), DELTA);
		assertEquals(-20.4, c2.mult(com_mult2).getImag(), DELTA);
	}

	@Test
	public final void testDiv() {
		Complex c1 = new Complex(3,4);
		Complex c2 = new Complex(3,4);
		
		Complex com_div1 = new Complex(7, 3);
		Complex com_div2 = new Complex(-7.5, 3.2);

		// com1 * com_div1
		assertEquals(0.362, com1.div(com_div1).getReal(), 0.001);
		assertEquals(0.482, com2.div(com_div1).getImag(), 0.001);

		// com1 * com_div2
		assertEquals(-0.338, c1.div(com_div2).getReal(), 0.001);
		assertEquals(-0.451, c2.div(com_div2).getImag(), 0.001);
	}

	@Test
	public final void testSquare() {
		Complex c1 = new Complex(3,4);
		Complex c2 = new Complex(3,4);
		
		Complex com_square = new Complex(-527, -336);
		Complex com_square2 = new Complex(-527, -336);
		Complex com_doublesquare = new Complex(164833, 354144);

		assertEquals(-7, com1.square().getReal(), DELTA);
		assertEquals(24, com2.square().getImag(), DELTA);
		
		assertEquals(com_square, c1.square().square());
		assertEquals(com_square, c2.square().square());

		assertEquals(com_doublesquare.getReal(), com_square.square().getReal(), DELTA);
		assertEquals(com_doublesquare.getImag(), com_square2.square().getImag(), DELTA);
	}
	
	@Test
	public final void testPow() {
		assertEquals((com1.pow(2)), com2.square());
		assertEquals((new Complex(2,3)).pow(2), (new Complex (2,3)).mult((new Complex (2,3))));
		assertEquals((new Complex(5,6).mult(new Complex(5,6).square())), (new Complex(5,6)).mult((new Complex(5,6)).mult(new Complex(5,6))));
		assertEquals((new Complex(1,2)).pow(3), (new Complex(1,2)).mult(( (new Complex(1,2)).mult( new Complex(1,2) ))));
	}

	@Test
	public final void testEqualsObject() {
		assertEquals(com2, com1);
		assertEquals(com1.setRational(), rational);
		assertEquals(com2, new Complex(3,4));
		assertNotEquals(com3, com1);
		assertNotEquals(com3, new Complex(3,5));
	}

	@Test
	public final void testToString() {
		assertEquals(com1.toString(), "z = " + 3.0 + " + i * " + 4.0);
	}

}
