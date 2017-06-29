/**
 * UniqueLetterColl.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2tutorium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class UniqueLetterColl extends LetterColl implements Set<Character>{
	private ArrayList<Character> data;
	
	
	public UniqueLetterColl (char... ls) {
		this.data = uniqueChars(ls);
	}
	public UniqueLetterColl(String str) {
		this.data = uniqueChars(str.toCharArray());
	}
	
	private ArrayList<Character> uniqueChars(char[] input){
	ArrayList<Character> uniqueChars = new ArrayList<Character>();
		for(char element : input){
			if(!uniqueChars.contains(element)){
				uniqueChars.add(element);
			}
		}
		return uniqueChars;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(Character c) {
		for(char element : data){
			if(!data.contains(element)){
				data.add(c);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Character> coll) {
		boolean added = false;
		for(char element : coll){
			if(!added){
				added = this.add(element);
			}else{
				this.add(element);
			}
		}
		return added;
	}

	@Override
	public void clear() {
		this.data = new ArrayList<Character>();
		
	}

	@Override
	public boolean contains(Object o) {
		return this.data.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		return data.containsAll(coll);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Iterator<Character> iterator() {
		return data.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return data.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> coll) {
		return data.removeAll(coll);
	}

	@Override
	public boolean retainAll(Collection<?> coll) {
		return data.retainAll(coll);
	}

	@Override
	public Object[] toArray() {
		return data.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return data.toArray(a);
	}

}
