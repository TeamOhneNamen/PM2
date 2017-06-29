/**
 * Menge.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2tutorium;

import java.util.ArrayList;
import java.util.Iterator;

public class Menge<T> implements Iterable<T> {
	ArrayList<Object> data = new ArrayList<Object>();

	public void add(T element) {
		if (!data.contains(element)) {
			data.add(element);
		}
	}

	public void add(Menge<T> element) {
		if (!data.contains(element)) {
			data.add(element);
		}
	}

	public boolean contains(Object element) {
		return data.contains(element);
	}

	public int size() {
		return data.size();
	}

	public Menge<T> union(Menge<T> set) {
		for (T element : set) {
			this.add(element);
		}
		return this;
	}

	public Menge<T> difference(Menge<T> set) {
		
		for (T element : this) {
			set.remove(element);
		}
		for (T element : set) {
			this.remove(element);
		}
		return this;
	}
	
	public Menge<T> intersection(Menge<T> set) {
		Menge<T> me = new Menge<T>();
		for (T element : this) {
			if(set.contains(element)){
				me.add(element);
			}
		}
		return me;
	}
	
	public void remove(T element) {
		for (int i = 0; i < data.size(); i++) {
			if (data.contains(element)) {
				data.remove(i);
			}
		}
	}

	@Override
	public String toString() {
		return data.toString();
	}

	@SuppressWarnings("unchecked")
	// hier möglich da, vorab die Klassengleichheit geprüft wurde
	@Override
	public boolean equals(Object o) {
		if (!(this.getClass() == o.getClass())) {
			return false;
		}
		if (!(this.size() == ((Menge<T>) o).size())) {
			return false;
		}

		for (Object element : this.data) {
			if (!(((Menge<T>) o).contains(element))) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	// hier möglich da, vorab die Klassengleichheit geprüft wurde
	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) data.iterator();
	}

	public static void main(String[] args) {
		Menge<Integer> A = new Menge<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(2);
		System.out.println(A); // AUSGABE etwa: { 3 1 2 }
		System.out.println(A.contains(1)); // AUSGABE: true
		System.out.println(A.contains(5)); // AUSGABE: false
		Menge<Integer> B = new Menge<Integer>();
		B.add(1);
		Menge<Integer> C = new Menge<Integer>();
		C.add(1);
		C.add(2);
		C.add(3);

		Menge<Menge<Integer>> mengen = new Menge<Menge<Integer>>();
		mengen.add(A);
		mengen.add(B);
		mengen.add(C);

		System.out.println(C.union(A));
		System.out.println(B.intersection(C));
		System.out.println(C.intersection(B));
		System.out.println(mengen); // AUSGABE etwa: { { 1 2 3 } { 1 2 } } //
									// NICHT aber etwa: { { 1 2 3 } { 1 2 } { 1
									// 2 3 }
		System.out.println(A.equals(C)); // AUSGABE: true (!!)
	}

}
