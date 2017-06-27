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
	
	//throws no exception
	public static int sumExact01(Collection<Integer> coll) {
		return coll.stream().mapToInt(Integer::intValue).sum();
	}
	
	//throws direct a exception also if the final result could be correct
	public static int sumExact02(List<Integer> coll) {
		int sum = 0;
		for(Integer value : coll){
			sum = Math.addExact(sum, value);
		}
		return sum;
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
