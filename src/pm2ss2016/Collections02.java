/**
 * Collections02.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2ss2016;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Collections02 {

	private Collections02() {
	}
	
	//throws direct a exception also if the final result could be correct
	public static int sumExact01(List<Integer> coll) {
		int sum = 0;
		for(Integer value : coll){
			sum = Math.addExact(sum, value);
		}
		return sum;
	}
	
	//throws only a exception if the final result over- or underflows the integer value range
	public static int sumExact02(List<Integer> coll) throws Exception {
		long sum = 0;
		for(Integer value : coll){
			sum += value;
		}
		if(sum < Integer.MIN_VALUE|| sum > Integer.MAX_VALUE){
			throw new ArithmeticException("Value out of range" + sum);
		}
		return ((Long)sum).intValue();
	}

	//throws no exception
	public static int sumExact03(Collection<Integer> coll) {
		return coll.stream().mapToInt(Integer::intValue).sum();
	}

	public static <T extends Object & Comparable<? super T>> T getBiggest(Collection<? extends T> coll) {
		return Collections.max(coll);
	}
	
	public static <T> double averageSize(Collection<Collection<T>> coll) {
		return coll.stream().mapToInt(e -> e.size()).average().getAsDouble();
	}

	public static void main(String[] args) {
	}

}
