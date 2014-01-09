package Opg2_BST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BinarySearchTreeDictionary<K extends Comparable<K>, V> implements
		Dictionary<K, V> {

	private BinarySearchTree<Entry> bst;

	public BinarySearchTreeDictionary(){
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
		//TODO
		return false;
	}

	@Override
	public V put(K key, V value) {
		//TODO
		return null;
	}

	@Override
	public V remove(K key) {
		//TODO
		return null;
	}

	@Override
	public int size() {
		return bst.size();
	}

	@Override
	public Iterator<K> keys() {
		//TODO
		return null;
	}

	@Override
	public Iterator<V> values() {
		//TODO
		return null;
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
