package pm2ss2016;

import java.util.ArrayList;
import java.util.Stack;

public class ExampleCollection {

	public static void main(String[] args) throws Exception {

		ArrayList<Integer> ai = new ArrayList<Integer>();
		ai.add(1);
		ai.add(Integer.MAX_VALUE);
		ai.add(Integer.MAX_VALUE);
		
		Stack<Integer> ae = new Stack<Integer>();
		
		ae.push(3);
		ae.push(3);
		ae.push(6);
		ae.push(Integer.MAX_VALUE);
		ae.push(Integer.MIN_VALUE);
		ae.push(6);

		Stack<Integer> ao = new Stack<Integer>();
		
		Stack<Stack<Integer>> all = new Stack<Stack<Integer>>();
		all.push(ae);
		all.push(ao);
		
		System.out.println(Collections02.sumExact01(ai));
		System.out.println(Collections02.sumExact02(ai));
		System.out.println(Collections02.sumExact03(ae));
		System.out.println(Collections02.getBiggest(ai));
		System.out.println(Collections02.getBiggest(ae));
//		System.out.println(Collections02.averageSize(all));
	}

	

}
