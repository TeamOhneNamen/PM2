/**
 * Stack.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

public class Stack {
	
	Object[] data = new Object[3];
	int length = 3;
	
	int pointer = 0;
	
	public Stack(int size){
		Object[] data = new Object[size];
		length = size;
	}
	
	public static void main(String[] args){
		Stack s = new Stack(3);
		System.out.println(s);
		System.out.println(s.isEmpty());
		System.out.println(s.length());
		s.push(5);
		System.out.println(s);
	}
	
	public void push(Object element){
		if (pointer >= data.length){
			extend();
		}
		data[pointer] = element;
		pointer++;
		
	}
	public void pop(){
		data[(pointer-1)] = null;
		
	}
	
	public boolean isEmpty(){
		Object[] emptyarry = new Object[3];
		//return (data == emptyarry);
		return (data.equals(emptyarry));
		
	}
	
	public String toString(){
		String str = "";
		for (int i = 0; i < data.length; i++){
			if (data[i] != null) str = str + data[i].toString();
		}
		return str;
	}
	
	public void extend(){
		int count = 0;
		Object[] ext_data = new Object[(length * 2)];
		while (count < data.length){
			ext_data[count] = data[count];
			count++;
		}
		data = ext_data;
	}
	
	public int length(){
		return data.length;
	}

}
