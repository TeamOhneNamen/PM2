package pm2ss2016;

import java.util.Stack;

public class ExampleCollection {

	public static void main(String[] args) {

		Stack<Integer> ai = new Stack<Integer>();
		
		ai.push(3);
		ai.push(3);
		ai.push(6);
		ai.push(Integer.MAX_VALUE);
		ai.push(6);

		System.out.println(Collections02.sumExact01(ai));
		System.out.println(Collections02.getBiggest(ai));
	}

	

}
