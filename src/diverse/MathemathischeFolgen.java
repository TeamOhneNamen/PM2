/**
 * MathemathischeFolgen.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package diverse;

import java.util.stream.IntStream;

public class MathemathischeFolgen {

	public static void main(String[] args) {
		IntStream fibs = IntStream.iterate(1, i->i+1).limit(20).map(i -> triangularNumberIterative(i));
		fibs.forEach(e -> {System.out.println(e);});
	}
	
	static int triangularNumber(int i){
		if(i == 1){
			return 1;
		}
		return i + triangularNumber(i-1);
	}
	
	static int triangularNumberIterative(int n){
        int result =n;
        while(n>0){
            result +=(n-1);
            n--;
        }
        return result;
    }
	
}
