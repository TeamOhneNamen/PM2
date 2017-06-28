package tuli.Complex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import tuli.Complex.MathUtils;

public class MathUtilsTest {

	private Complex c1;
	private Complex c2;
	private Complex c3;
	private Complex c4;
	private Complex c5;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Complex(1,2);
		c2 = new Complex(2,2);
		c3 = new Complex(5);
		c4 = new Complex();
		c5 = new Complex(3,7);
	}

	@Test
	public final void testExponential_e() {
		assertEquals(MathUtils.exponential_e(c1), MathUtils.exponential_e((c1)));
		assertNotEquals(MathUtils.exponential_e(c2), MathUtils.exponential_e((c3)));
		assertEquals(MathUtils.exponential_e(c5).getReal(), 15.143, 0.001 );
		assertEquals(MathUtils.exponential_e(c5).getImag(), 13.196, 0.001 );
	}

	@Test
	public final void testExponential() {
		assertEquals(MathUtils.exponential(c1, 10.8), MathUtils.exponential(c1, 10.8));
		assertNotEquals(MathUtils.exponential(c1, 4), MathUtils.exponential(c1, 3));
		assertEquals(MathUtils.exponential_e(c2), MathUtils.exponential(c2, Math.E) );
		
	}

	@Test
	public final void testSinus() {
		assertEquals(MathUtils.sinus(c4), MathUtils.sinus(c4));		
		assertNotEquals(MathUtils.sinus(c2), MathUtils.sinus(c3));
		assertEquals(MathUtils.sinus(c5).getReal(), 77.379, 0.001);
		assertEquals(MathUtils.sinus(c5).getImag(), -542.829, 0.001);
	}

	@Test
	public final void testCosinus() {
		assertEquals(MathUtils.cosinus(c3), MathUtils.cosinus(c3));	
		assertNotEquals(MathUtils.cosinus(c2), MathUtils.cosinus(c3));	
		assertEquals(MathUtils.cosinus(c5).getReal(), -542.830, 0.001);
		assertEquals(MathUtils.cosinus(c5).getImag(), -77.378, 0.001);

	}

	@Test
	public final void testLogarithm() {
		assertEquals(MathUtils.logarithm(c2), MathUtils.logarithm(c2));
		assertNotEquals(MathUtils.logarithm(c1), MathUtils.logarithm(c3));
		assertEquals(MathUtils.logarithm(c5).getReal(), 2.030, 0.001);
		assertEquals(MathUtils.logarithm(c5).getImag(), 1.166, 0.001);
	}

}
