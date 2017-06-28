/**
 * AFiFo.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package diverse;

public class AQueue<E> {

	Object[] data;
	public int index = 0;

	public AQueue(int size) {
		data = new Object[size];
	}

	public AQueue() {
		data = new Object[5];
	}

	public void insert(E entry) {
		if (data.length == index) {
			extend();
		}

		Object[] datacopy = data.clone();
		for (int i = 0; i < index; i++) {
			data[i + 1] = datacopy[i];
		}
		data[0] = entry;
		index++;
	}
	
	public void delete() {
		Object[] datacopy = data.clone();
		for (int i = 0; i < index -1; i++) {
			data[i] = datacopy[i+1];
		}
		index--;
	}

	@Override
	public String toString() {
		if(index==0){
			return "";
		}
		StringBuilder sb = new StringBuilder(index);
		String sym = ", ";
		sb.append("[");
		for(int i =0; i< index; i++){
			if(i == index-1){
				sym = "]";
			}
			sb.append(data[i].toString() + sym);
		}
		return sb.toString();
	}

	public void extend() {
		Object[] datacopy = new Object[index*2];
		for (int i = 0; i < index; i++) {
			datacopy[i] = data[i];
		}
		this.data = datacopy;
	}
	public boolean isEmpty(){
		return (index == 0);
	}

	public static void main(String[] args) {
		AQueue<Integer> que = new AQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			que.insert(5);
		}
		System.out.println(que.index);
		System.out.println(que);
		que.delete();
		System.out.println(que.index);
		System.out.println(que);
	}

}
