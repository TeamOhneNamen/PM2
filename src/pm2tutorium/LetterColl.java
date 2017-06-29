/**
 * LetterColl.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2tutorium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class LetterColl {
	private char[] data;
	private ArrayList<Character> uniqueChars = new ArrayList<Character>();
	
	public LetterColl(char... ls) {
		this.data = ls;
	}
	public LetterColl(String str) {
		this.data = str.toCharArray();
	}

	public int size() {
		return data.length;
	}
	
	public int count(char c) {
		int quantity = 0;
		for(char element : data){
			if(element==c){
				quantity++;
			}
		}
		return quantity;
	}
	
	public int different() {
		return uniqueChars().size();
	}
	
	public ArrayList<Character> uniqueChars(){
		if(!(uniqueChars.isEmpty())){
			return uniqueChars;
		}
		for(char element : data){
			if(!uniqueChars.contains(element)){
				uniqueChars.add(element);
			}
		}
		return uniqueChars;
	}
	
	public char[] elements() {
		return data.clone();
	}
	
	public LetterColl moreThan(int m) {
		StringBuilder sb = new StringBuilder();
		for(char element : data){
			if(count(element)>m){
				sb.append(element);
			}
		}
		return new LetterColl(sb.toString());
	}
	
	
	public char top() {
		Optional<Character>  top = uniqueChars().stream().max((e1, e2) -> count(e1) - count(e2)  );
		if(!(top.isPresent())){
			//throw exception
		}
		return top.get();
	}
	
	private LetterColl except(LetterColl lc) {
		StringBuilder sb = new StringBuilder();
		for(char element : data){
			if(!(lc.contains(element))){
				sb.append(element);
			}else{
				lc.delete(element);
			}
		}
		return new LetterColl(sb.toString());
	}
	
	public boolean contains(char c){
		return uniqueChars().contains(c);
	}
	
	public void delete(char c){
		StringBuilder sb = new StringBuilder();
		boolean deleted = false;
		for(char element : data){
			if(element != c || deleted){
				sb.append(element);
			}else{
				deleted = true;
				uniqueChars = new ArrayList<Character>();
			}
		}
		data = sb.toString().toCharArray();
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LetterColl other = (LetterColl) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		return true;
	}
	public static void main(String[] args) {
		LetterColl lc = new LetterColl("ABRAKADABRA");
		System.out.println(lc.size()); // 11
		System.out.println(lc.count('R')); // 2 
		System.out.println(lc.count('X')); // 0
		System.out.println(lc.different()); // 5
		System.out.println(lc.top()); // A
		System.out.println(lc.elements()); // [A, B, R, A, K, A, D, A, B, R, A]
		System.out.println(lc.toString()); // [A, B, R, A, K, A, D, A, B, R, A]
		System.out.println(lc.moreThan(1)); // [A, B, R, A, A, A, B, R, A]
		System.out.println(lc.except(new LetterColl("ABARAXAS"))); // [K, D, B, R, A]

	}

}
