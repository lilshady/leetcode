/**
 * TODO: comment here
 */
public interface SkipList<K extends Comparable<? super K>,V> {

	boolean insert(K key, V value);

	V find(K key);

	V delete(K key);

	boolean update(K key, V value);

	int size();

}
