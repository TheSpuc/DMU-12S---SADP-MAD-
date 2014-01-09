package Opg2;

import java.util.Iterator;

public class LinkedDictionary<K, V> implements DictionaryI<K, V> {

	private Node firstNode;
	private int numberOfEntries;

	public LinkedDictionary() {
		firstNode = new Node();
		numberOfEntries = 0;
	}

	// SORTED!

	@Override
	public V get(K key) {
		Node temp = null;
		boolean found = false;
		while (!found && temp.next != null) {
			if (temp.next.key.equals(key)) {
				found = true;
			} else {
				temp = temp.next;
			}
		}
		V result = null;
		if (found) {
			result = temp.value;
		}
		return result;
	}

	@Override
	public V put(K key, V value) {

		Node temp = firstNode;
		boolean found = false;
		V result = null;
		while (!found && temp.next != null) {
			if (temp.next.key.equals(key)) {
				result = temp.next.value;
				temp.next.value = value;
				found = true;
			} else {
				temp = temp.next;
			}
		}
		if (!found) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			newNode.next = firstNode.next;
			firstNode.next = newNode;
			numberOfEntries++;
		}
		return result;
	}

	@Override
	public V remove(K key) {
		Node temp = firstNode;
		boolean found = false;
		V result = null;
		while (!found && temp.next != null) {
			if (temp.next.key.equals(key)) {
				Node nodeToBeRemoved = temp.next;
				temp.next = nodeToBeRemoved.next;
				nodeToBeRemoved.next = null;
				result = nodeToBeRemoved.value;
				numberOfEntries--;
			} else {
				temp = temp.next;
			}
		}
		return result;
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

		private Node start;

		public LinkedDictionaryKeyIterator() {
			start = firstNode;
		}

		@Override
		public boolean hasNext() {
			return start.next != null;
		}

		@Override
		public K next() {
			if (hasNext()) {
				start = start.next;
				return start.key;

			} else {
				throw new RuntimeException("No keys");
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class LinkedDictionaryValueIterator implements Iterator<V> {

		private Node start;

		public LinkedDictionaryValueIterator() {
			start = firstNode;
		}

		@Override
		public boolean hasNext() {
			return start.next != null;
		}

		@Override
		public V next() {
			if (hasNext()) {
				start = start.next;
				return start.value;
			} else {
				throw new RuntimeException("No values");
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class Node {
		private Node next;
		private K key;
		private V value;
	}

}
