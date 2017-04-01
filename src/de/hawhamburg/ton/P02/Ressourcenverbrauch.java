package de.hawhamburg.ton.P02;

/**
 * @author Thorben Schomacker
 * @author Ferdinand Trendelenburg
 */
public class Ressourcenverbrauch {

	public static void main(String[] args) {
		leftShift();

	}
	
	public static void leftShift(){
		//nanoTime(); like currentTimeMillis() but in nanoseconds
		//currentTimeMillis();
		//System.currentTimeMillis()
		//String strLong = Long.toString(longNumber);
		int places = 5;
		
		final int oneDec = 1;
		final int twoDec = 2;
		int resultDec;
		
		final byte oneBin = 00000001;
		final byte twoBin = 00000010;
		byte resultBin;
		
		long beforeDec;
		long afterDec;
		
		long beforeBin;
		long afterBin;
		
		// Addition compared in milliseconds.
		beforeDec = System.currentTimeMillis();
		resultDec = oneDec + twoDec;
		afterDec = System.currentTimeMillis();
		System.out.println(Long.toString(afterDec - beforeDec));
		
		beforeBin = System.currentTimeMillis();
		resultBin = oneBin + twoBin;
		afterBin = System.currentTimeMillis();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		// Addition compared in nanoseconds.
		beforeDec = System.nanoTime();
		resultDec = oneDec + twoDec;
		afterDec = System.nanoTime();
		System.out.println(Long.toString(afterDec - beforeDec));
		
		beforeBin = System.nanoTime();
		resultBin = oneBin + twoBin;
		afterBin = System.nanoTime();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		// Multiplication compared in milliseconds.
		beforeDec = System.currentTimeMillis();
		resultDec = oneDec * twoDec;
		afterDec = System.currentTimeMillis();
		System.out.println(Long.toString(afterDec - beforeDec));
		
		beforeBin = System.currentTimeMillis();
		resultBin = oneBin * twoBin;
		afterBin = System.currentTimeMillis();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		// Multiplication compared in nanoseconds.
		beforeDec = System.nanoTime();
		resultDec = oneDec * twoDec;
		afterDec = System.nanoTime();
		System.out.println(Long.toString(afterDec - beforeDec));
		
		beforeBin = System.nanoTime();
		resultBin = oneBin * twoBin;
		afterBin = System.nanoTime();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		// Left shift / right shift  in milliseconds.
		
		beforeBin = System.currentTimeMillis();
		resultBin = oneBin << 5;
		afterBin = System.currentTimeMillis();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		beforeBin = System.currentTimeMillis();
		resultBin = oneBin >> 5;
		afterBin = System.currentTimeMillis();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		// Left shift / right shift in nanoseconds.
		
		beforeBin = System.nanoTime();
		resultBin = oneBin << 5;
		afterBin = System.nanoTime();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		beforeBin = System.nanoTime();
		resultBin = oneBin >> 5;
		afterBin = System.nanoTime();
		System.out.println(Long.toString(afterBin - beforeBin));
		
		//System.out.println(Long.toString(System.currentTimeMillis()));
		//System.out.println(Integer.toBinaryString(2)); 
		//System.out.println(Integer.toBinaryString(2 << 11)); 
	}


}
