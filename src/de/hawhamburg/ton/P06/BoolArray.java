/**
 * BoolArray.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

public class BoolArray {
	
	boolean[] data;
	
	public int length(){
		return data.length;
	}
	
	public boolean bit(int i){
		return data[i];
	}
	
	public boolean any(){
		boolean any = false;
		for(boolean element : data){
			if(element){
				any = true;
			}
		}
		return any;
	}
	
	public boolean none(){
		boolean none = true;
		for(boolean element : data){
			if(element){
				none = false;
			}
		}
		return none;
	}
	
	public boolean all(){
		return(!none());
	}
	
	public int count(boolean bit){
		int sum = 0;
		for(boolean element : data){
			if(element==bit){
				sum++;
			}
		}
		return sum;
	}
	
	BoolArray not()
	
	BoolArray or(BoolArray that)
	
	BoolArray and(BoolArray that)
	
	BoolArray xor(BoolArray that)

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
