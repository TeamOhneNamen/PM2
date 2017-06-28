package de.hawhamburg.ton.P06;

import java.util.Arrays;

/**
 * @author Ben Dzaebel, Edward Abiakin
 *	A Stack implementation using an Array.	
 *
 * @param <T> Type of the values in the stack.
 */
public class AStack<T> {
	private Object[] values;
	private int length;
	
	public AStack() {
		this(10);
	}
	public AStack(int capacity) {
		values = new Object[capacity];
		length = 0;
	}
	
	/**
	 * Copys the old values in a new resized Array.
	 * @param size New size of the Array. 
	 */
	private void resizeArray(int size) {
		values = Arrays.copyOf(values, size);
	}
	
	/**
	 * @return Number of elements on the stack.
	 */
	public int getLength() { return length; } 
	
	/**
	 * Adds a new Element to the top of the stack.
	 * @param value Element to add-
	 * @return Reference to stack.
	 */
	public AStack<T> push(T value) {
		if(length >= values.length) resizeArray(length + 10);
		length++;
		values[length - 1] = value;
		return this;
	}
	
	/**
	 * Removes the top Element of the stack.
	 * @return Value of the top Element.
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		if(length == 0) return null;
		T value = (T)values[length - 1];
		length--;
		return value;
	}
	
	/**
	 * @return true if the Stack is empty.
	 */
	public boolean isEmpty() {
		return length == 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(values, length));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + Arrays.hashCode(Arrays.copyOf(values, length));
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
		AStack<?> other = (AStack<?>) obj;
		if (length != other.length)
			return false;
		if (!Arrays.equals(Arrays.copyOf(values, length),Arrays.copyOf(other.values, length)))
			return false;
		return true;
	}
}
