import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * TODO: comment here
 */

public class SkipListImpl<K extends Comparable<? super K>, V> implements SkipList<K, V> {

	private int level;
	private int size;
	private Map<Integer, SkipListNode<K, V>> nodeList;
	private Random rnd;

	public SkipListImpl() {

		level = 0;
		size = 0;
		nodeList = new HashMap<Integer, SkipListNode<K, V>>();
		rnd = new Random(System.currentTimeMillis());
	}

	public boolean insert(K key, V value) {

		SkipListNode<K, V> insertNode = new SkipListNode<K, V>(key, value);

		Map<Integer, SkipListNode<K, V>> shouldUpdate = new HashMap<Integer, SkipListNode<K, V>>();

		for (int i = level; i >= 0; i--) {
			SkipListNode<K, V> levelNode = nodeList.get(i);

			if (levelNode == null) {
				shouldUpdate.put(i, null);
				continue;
			}

			SkipListNode<K, V> pre = null;
			SkipListNode<K, V> node = levelNode;
			boolean update = false;
			while (node != null) {

				int result = node.key.compareTo(key);
				if (result > 0) {
					shouldUpdate.put(i, pre);
					update = true;
					break;
				} else {
					if (result == 0) {
						node.value = value;
						return false;
					}
				}
				pre = node;
				node = node.nodeList.get(i);
			}
			if (!update) {
				shouldUpdate.put(i, pre);
			}
		}

		int newLevel = rnd.nextInt(level + 2);

		if (newLevel > level) {

			level = newLevel;
			nodeList.put(level, insertNode);
			insertNode.nodeList.put(newLevel,null);
		}

		for (Map.Entry<Integer, SkipListNode<K, V>> record : shouldUpdate.entrySet()) {

			SkipListNode<K, V> node = record.getValue();
			int level = record.getKey();

			if  (level > newLevel) {
				continue;
			}

			if (node == null) {
				insertNode.nodeList.put(level,nodeList.get(level));
				nodeList.put(level,insertNode);
			} else {
				insertNode.nodeList.put(level, node.nodeList.get(level));
				node.nodeList.put(level, insertNode);
			}
		}

		size++;
		return true;

	}

	public V find(K key) {

		for (int i = level; i > 0; i--) {
			SkipListNode<K, V> levelNode = nodeList.get(i);

			if (levelNode == null) {
				continue;
			}

			SkipListNode<K, V> node = levelNode;
			while (node != null) {

				int result = node.key.compareTo(key);

				if (result == 0) {

					return node.value;
				}
				node = node.nodeList.get(i);
			}
		}

		return null;
	}

	public V delete(K key) {

        int levelRemainder = level + 1;
        V value = null;
		for (int i = level; i > 0; i--) {
			SkipListNode<K, V> levelNode = nodeList.get(i);

			if (levelNode == null) {
				continue;
			}

			SkipListNode<K, V> pre = null;
			SkipListNode<K, V> node = levelNode;
			while (node != null) {
				int result = node.key.compareTo(key);
					if (result == 0) {
						if (pre != null) {
							pre.nodeList.put(i,node.nodeList.get(i));
							node.nodeList.put(i,null);
							value = node.value;
						}
						if (levelRemainder > level) {
							levelRemainder = i;
						}
						break;
					}
				pre = node;
				node = node.nodeList.get(i);
			}
		}

		return value;
	}

	public boolean update(K key, V value) {
		for (int i = level; i > 0; i--) {
			SkipListNode<K, V> levelNode = nodeList.get(i);

			if (levelNode == null) {
				continue;
			}

			SkipListNode<K, V> node = levelNode;
			while (node != null) {
				int result = node.key.compareTo(key);
				if (result == 0) {
					node.value = value;
					return true;
				}
				node = node.nodeList.get(i);
			}
		}

		return false;
	}

	public int size() {
		return size;
	}

	static class SkipListNode<K, V> {

		private Map<Integer, SkipListNode<K, V>> nodeList;

		private K key;

		private V value;

		public SkipListNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.nodeList = new HashMap<Integer, SkipListNode<K, V>>();
		}
	}

	public static void main(String[] args) {

		SkipList<Integer,Integer> skipList = new SkipListImpl<Integer, Integer>();

		skipList.insert(7,93);

		skipList.insert(8,92);

		skipList.insert(6,94);

		skipList.insert(3,97);

		skipList.insert(100,0);

		skipList.insert(45,55);


		int found = skipList.find(45);

		System.out.println(found);
	}
}
