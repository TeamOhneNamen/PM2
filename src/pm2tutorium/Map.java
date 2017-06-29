/**
 * Map.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package pm2tutorium;

public interface Map<K, V> {
	/**
	 * Associate key with value: next time someone calls get(k) ∗ with a k which
	 * is equals() to key, the get−call shall ∗ return value
	 */
	void put(K key, V value);

	/**
	 * Get the value associated with key, or null if none was ∗ associated with
	 * key.
	 */
	V get(K key);

	/** the number of key−value mappings in this map. */
	int size();
}
