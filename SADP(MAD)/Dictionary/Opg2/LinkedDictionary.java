package Opg2;

import java.util.Iterator;

public class LinkedDictionary<K, V> implements DictionaryI<K, V> {

	private Node firstNode;
	private int numberOfEntries;

	public LinkedDictionary() {
		firstNode = null;
		numberOfEntries = 0;
	}

	// SORTED!

	@Override
	public V get(K key) {
		Node resultNode = null;
		// TODO: Search for key!
		V result = null;
		if (resultNode != null) {
			result = resultNode.value;
		}
		return result;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		Node resultNode = null;
		// TODO: Search for key!
		V result = null;
		if (resultNode.next.value.equals(value)) {
			result = resultNode.next.value;
			resultNode.next.value = value;
		} else if (resultNode == null) {

		} else {

		}

		numberOfEntries++;
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub

		numberOfEntries--;
		return null;
	}

	@Override
	public Iterator<K> keys() {
		return new LinkedDictionaryKeyIterator();
	}

	@Override
	public Iterator<V> values() {
		return new LinkedDictionaryValueIterator();
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	private class LinkedDictionaryKeyIterator implements Iterator<K> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	private class LinkedDictionaryValueIterator implements Iterator<V> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public V next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	private class Node {
		private Node next;
		private K key;
		private V value;
	}

}
