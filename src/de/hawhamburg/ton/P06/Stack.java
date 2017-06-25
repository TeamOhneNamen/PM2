/**
 * Stack.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

import java.util.Arrays;
import java.util.Collections;

public class Stack {
	
	Object[] data;
	int pointer = 0;
	
	public Stack(int size){
		data = new Object[size];
	}
	
	public Stack(){
		data = new Object[5];
	}
	
	public static void main(String[] args){
		Stack s = new Stack(3);
		System.out.println(s);
		System.out.println(s.isEmpty());
		System.out.println(s.length());
		System.out.println(s.isFull());
		
		s.push(5);
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.isFull());
		
		s.push("hallo");
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.isFull());
		
		s.push("hallo");
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.isFull());
		
		s.push("hallo");
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.isFull());
	}
	
	public void push(Object element){
		if (length() >= data.length){
			extend();
		}
		data[pointer] = element;
		pointer++;
		
	}
	public Object pop() throws EmptyStackException{
		if(pointer == 0){
			throw new EmptyStackException(); 
		}
		Object o = data[(pointer-1)];
		data[(pointer-1)] = null;
		pointer--;
		return o;
		
	}
	
	public Object peek() throws EmptyStackException{
		if(pointer == 0){
			throw new EmptyStackException(); 
		}
		return data[(pointer)];
		
	}
	
	public boolean isEmpty(){
		boolean isEmpty = false;
		for(int i = 0; i < data.length && !(isEmpty); i++){
			isEmpty = (data[i] == null);
		}
		return isEmpty;
	}
	
	public boolean isFull(){
		Object[] datarev = data;
		Collections.reverse(Arrays.asList(datarev));
		return !(datarev[1] == null);
	}
	
	public String toString(){
		String output = "";
		for(int i = 0; i < length(); i++){
			if(data[i] != null){
				output += data[i] + ", ";
			}
			
		}
		return output;
	}
	
	public void extend(){
		int count = 0;
		Object[] ext_data = new Object[(data.length * 2)];
		while (count < data.length){
			ext_data[count] = data[count];
			count++;
		}
		data = ext_data;
	}
	
	public int length(){
		return pointer;
	}

}
