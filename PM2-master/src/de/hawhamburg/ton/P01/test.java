package de.hawhamburg.ton.P01;

public class test {

	public static void main(String[] args) {
		
		Complex neues_complex = new Complex(3, 4);
		//neues_complex.i_erzeugen();
		Complex neues_complex2 = new Complex(5, 2);
		//neues_complex2.i_erzeugen();
		
		System.out.println(neues_complex.mul(neues_complex2).toString());
		
		

	}

}
