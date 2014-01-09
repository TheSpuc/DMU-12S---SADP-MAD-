package Opg3_BST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTreeDictionary<K extends Comparable<K>, V> implements Dictionary<K, V> {

	private BinarySearchTree<Entry> bst;

	public BinarySearchTreeDictionary() {
		bst = new BinarySearchTree<Entry>();
	}

	@Override
	public V get(K key) {
		Entry dummy = new Entry(key, null);
		Entry old = bst.get(dummy);
		if (old != null) {
			return old.getValue();
		} else {
			return null;
		}

	}

	@Override
	public boolean isEmpty() {
		// return size()==0;
		return bst.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		Entry addedEntry = new Entry(key, value);
		Entry oldValue = bst.add(addedEntry);
		return oldValue.getValue();
	}

	@Override
	public V remove(K key) {
		Entry dummy = new Entry(key, null);
		Entry toBeRemoved = bst.remove(dummy);
		V result = null;
		if (toBeRemoved != null) {
			result = toBeRemoved.getValue();
		}
		return result;
	}

	@Override
	public int size() {
		return bst.size();
	}

	@Override
	public Iterator<K> keys() {
		List<K> list = new ArrayList<K>();
		Iterator<Entry> it = bst.inorderIterator();
		while (it.hasNext()) {
			list.add(it.next().key);
		}
		return list.iterator();
	}

	@Override
	public Iterator<V> values() {
		List<V> list = new ArrayList<V>();
		Iterator<Entry> it = bst.inorderIterator();
		while (it.hasNext()) {
			list.add(it.next().value);
		}
		return list.iterator();
	}

	private class Entry implements Comparable<Entry> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		@Override
		public int compareTo(Entry arg0) {

			return key.compareTo(arg0.getKey());
		}
	}
}
