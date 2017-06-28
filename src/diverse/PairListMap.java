/**
 * PairListMap.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package diverse;

import java.util.ArrayList;

public class PairListMap<K, V> implements Map<K, V>{
	
	ArrayList<Pair<K, V>> data = new ArrayList<Pair<K, V>>();

	public static void main(String[] args) {
		String 	s = "strg";
		int 	i = 5;
		
		Pair <String, Integer> p = new Pair <String, Integer>(s,i);
		System.out.println(p);
		
		PairListMap<String, Integer> plm = new PairListMap<String, Integer>();
		plm.put(s,i);
		plm.put(s,i);
		
		System.out.println(plm);
		System.out.println(plm.get("asdf"));
		
	}

	@Override
	public void put(K key, V value) {
		boolean free = true;
		for(int i = 0; i < data.size(); i++){
			if(data.get(i).first().equals(key)){
				data.set(i, new Pair<K, V>(key, value));
				free = false;
			}
		}
		if(free){
			data.add(new Pair<K, V>(key, value));
		}	
	}

	@Override
	public V get(K key) {
		for(Pair<K, V> element : data){
			if(element.first().equals(key)){
				return element.second();
			}
		}
		return null;
	}

	@Override
	public int size() {
		return data.size();
	}
	
	@Override
	public String toString() {
		return data.toString();
	}

}
