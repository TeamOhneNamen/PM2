package de.hawhamburg.ton.P06;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ben Dzaebel, Edward Abiakin
 *	A Stack implementation using a backwards linked List.	
 *
 * @param <T> Type of the values in the stack.
 */
public class LStack<T> {
	
	private StackElement<T> top;
	private int length;
	
	public LStack(){
		top = null;
		length = 0;
	}
	
	/**
	 * Adds a new Element to the top of the stack.
	 * @param value Element to add-
	 * @return Reference to stack.
	 */
	public LStack<T> push(T value) {
		StackElement<T> newTop = new StackElement<T>(value,top);
		top = newTop;
		length++;
		return this;
	}
	
	/**
	 * Removes the top Element of the stack.
	 * @return Value of the top Element.
	 */
	public T pop() {
		if(top == null) return null;
		T value = top.value;
		top = top.prev;
		length--;
		return value;
	}
	
	
	/**
	 * @return true if the Stack is empty.
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
	/**
	 * @return Number of elements on the stack.
	 */
	public int getLength() { return length; }
	
	/**
	 * @return A List representation of the Stack.
	 */
	public ArrayList<T> toList() {
		ArrayList<T> values = new ArrayList<>();
		for(StackElement<T> current = top; current != null; current = current.prev) {
			values.add(current.value);
		}
		Collections.reverse(values);
		return values;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LStack<?> other = (LStack<?>) obj;
		if (top == null) {
			if (other.top != null)
				return false;
		} else {
			if(!this.toList().equals(other.toList())) return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((top == null) ? 0 : toList().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return toList().toString();
	}
	
	/**
	 * Represents one Element of the Stack contains a reference to the previous Element and the Value.
	 * @param <T> Type of the Value.
	 */
	private static class StackElement<T> {
		public T value;
		public StackElement<T> prev;
		public StackElement(T _value, StackElement<T> _prev) {
			value = _value;
			prev = _prev;
		}		
	}
}
