package de.hawhamburg.ton.P05;

public class Mandelbrot {
	private static double CREMIN;
	private static double CIMMIN;
	private static double ZBEREICH;
	private static double cre = CREMIN;
	private static double cim = CIMMIN;
	private static double x = 0;
	private static double y = 0;
	
    public static void main(String[] args) {
    	double xhoch2 = Math.pow(x, 2);
    	double yhoch2 = Math.pow(y, 2);
    	for( int i = 0; i <= 100 && ((Math.sqrt(xhoch2 + yhoch2) < 2)); i++){
    		
    	}
    }

}
