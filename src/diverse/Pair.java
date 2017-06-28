/**
 * Pair.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package diverse;

public class Pair <T, E>{
	
	private Object first;
	private Object second;
	
	public Pair(T first2, E second2) {
		this.first = first2;
		this.second = second2;
	}

	@SuppressWarnings("unchecked")
	// hier möglich da, vorab die Klassengleichheit geprüft wurde
	public T first() {
		return (T) first;
	}

	@SuppressWarnings("unchecked")
	// hier möglich da, vorab die Klassengleichheit geprüft wurde
	public E second() {
		return (E) second;
	}
	
	public Pair <Object, Object> flip() {
		return new Pair<Object, Object>(second, first);
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

	public static void main(String[] args) {
		String 	s = "strg";
		int 	i = 5;
		
		Pair <String, Integer> p = new Pair <String, Integer>(s,i);
		System.out.println(p);
		System.out.println(p.first().getClass());
		System.out.println(p.second().getClass());
		System.out.println(p.flip());
		System.out.println(p.flip().first().getClass());
		System.out.println(p.flip().second().getClass());
	}

}
