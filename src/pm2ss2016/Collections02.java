/**
 * Collections02.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2ss2016;

import java.util.Collection;
import java.util.Collections;

public class Collections02 {

	private Collections02() {
	}
	
	//Exception schreiben
	public static int sumExact01(Collection<Integer> coll) {
		return coll.stream().mapToInt(Integer::intValue).sum();
	}

	public static <T extends Object & Comparable<? super T>> T getBiggest(Collection<? extends T> coll) {
		return Collections.max(coll);
	}
	
	public static <T> int averageSize(Collection<Collection<T>> coll) {
		return 5;
//		return coll.stream().forEach(action);;

	}

	public static void main(String[] args) {
	}

}
