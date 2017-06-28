package tuli.Complex;
import tuli.Complex.Complex; //unnötiger Import?

/**
 * Eine Utility-Klasse für Complex für das Rechnen mit komplexen Zahlen
 * @author Laura Westfalen, Marcel Tuleweit
 * Quellen:
 * http://elsenaju.info/Rechner/Komplexe-Zahlen.htm
 * Exponentialfunktion:http://www.math-kit.de/2002/demo2/CN-PB-XML-MD/organization/doc/Komplex2_5_3/Komplex2_5_3.html 
 * Sinus und Cosinus: https://de.wikipedia.org/wiki/Sinus_und_Kosinus#Komplexes_Argument
 *
 */
public class MathUtils {

	private MathUtils(){
	}
	
	/**
	 * die Exponentialfunktion für komplexe Zahlen mit der eulerschen Zahl zur Basis
	 * e^z = e^x(cos y + i*sin y), für komplexe Zahl z = (x + i*y)
	 * @param Complex z
	 * @return Complex (ein neues Complex-Objekt als Ergebniswert)
	 */
	public static Complex exponential_e(Complex z)
	{
		double e = Math.E;
		double real = (Math.pow(e, z.getReal())) * Math.cos(z.getImag());
		double imag = (Math.pow(e, z.getReal())) * Math.sin(z.getImag());
		return new Complex(real, imag);	
	}
	
	/**
	 * die allgemeine Exponentialfunktion für komplexe Zahlen
	 * in der Form f(x) = a^x, unter der Annahme: a^x = e^(x*ln(a))
	 * @param Complex x
	 * @param double a (die Basis)
	 * @throws NumberFormatException (wenn a < 0 oder gleich 1 ist)
	 * @return (ein neues Complex-Objekt als Ergebniswert)
	 */
	public static Complex exponential(Complex x, double a)
	{
		if ((a < 0) || (a == 1)) {
			throw new NumberFormatException("Die Basis muss größer 0 & ungleich 1 sein.");
		}
		Complex x_copy = new Complex(x);
		return (exponential_e(x_copy.mult(new Complex(Math.log(a)))));
	}
	
	/**
	 * die Sinusfunktion für komplexe Zahlen
	 * sin z = sin(x + i*y) = sin(x)*cosh(y) + i*cos(x)*sinh(y)
	 * @param Complex z
	 * @return Complex (ein neues Complex-Objekt als Ergebniswert)
	 */
	public static Complex sinus(Complex z)
	{
		double real = ( Math.sin(z.getReal()) * (Math.cosh(z.getImag())) );
		double imag = ( Math.cos(z.getReal()) * (Math.sinh(z.getImag())) );
		return (new Complex(real, imag));
	}

	/**
	 * die Coinusfunktion für komplexe Zahlen
	 * cos z = cos(x + i*y) = cos(x)*cosh(y) + -(i*sin(x)*sinh(y))
	 * @param Complex z
	 * @return Complex (ein neues Complex-Objekt als Ergebniswert)
	 */
	public static Complex cosinus(Complex z)
	{
		double real = ( Math.cos(z.getReal()) * (Math.cosh(z.getImag())) );
		double imag = -( Math.sin(z.getReal()) * (Math.sinh(z.getImag())) );
		return (new Complex(real, imag));
	}
	
	
	/**
	 * die Logarithmusfunktion (Logarithmus naturalis)
	 * ln z = (1/2)*ln(x^2+y^2) + i*atan(y/x), für komplexe Zahl z = (x + i*y)
	 * @param double a (die Basis)
	 * @return Complex (ein neues Complex-Objekt als Ergebniswert)
	 */
	public static Complex logarithm(Complex z){
		Complex z_copy = new Complex(z);
		double real = (Math.log((z_copy.getReal() * z_copy.getReal()) + (z_copy.getImag() * z_copy.getImag()))) / 2;
		double imag = Math.atan(z_copy.getImag() / z_copy.getReal());
		return new Complex(real, imag);
	}
	
	
}
