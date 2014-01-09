package Opg2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDictionary<K, V> implements DictionaryI<K, V> {

	private Entry<K, V>[] entries;
	private int numberOfEntries;

	@SuppressWarnings("unchecked")
	public ArrayDictionary() {
		// entries = (Entry[]) new Object[10];
		entries = new Entry[10];
		numberOfEntries = 0;
	}

	@Override
	public V get(K key) {
		return entries[locateIndex(key)].getValue();
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> entry = entries[locateIndex(key)];
		V result = null;
		if (entry != null) {
			result = entry.getValue();
			entry.setValue(value);
		} else {
			ensureCapacity();
			entries[numberOfEntries] = new Entry<K, V>(key, value);
			numberOfEntries++;
		}
		return result;
	}

	@Override
	public V remove(K key) {
		int index = locateIndex(key);
		Entry<K, V> entry = entries[index];
		V value = null;
		if (entry != null) {
			entries[index] = entries[numberOfEntries - 1];
			entries[numberOfEntries - 1] = null;
			value = entry.getValue();
		}
		return value;
	}

	@Override
	public Iterator<K> keys() {
		return new ArrayDictionaryKeyIterator();
	}

	@Override
	public Iterator<V> values() {
		return new ArrayDictionaryValueIterator();
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (numberOfEntries == entries.length) {
			Entry<K, V>[] newEntries = new Entry[2 * entries.length];
			int index = 0;
			while (entries[index] != null) {
				newEntries[index] = entries[index];
				index++;
			}
			newEntries = entries;
		}
	}

	private int locateIndex(K key) {
		int index = 0;
		while (index < numberOfEntries && !entries[index].getKey().equals(key)) {
			index++;
		}
		return index;
	}

	private class ArrayDictionaryKeyIterator implements Iterator<K> {

		private int counter;

		public ArrayDictionaryKeyIterator() {
			counter = 0;
		}

		@Override
		public boolean hasNext() {
			return numberOfEntries > counter;
		}

		@Override
		public K next() {
			if (hasNext()) {
				K key = entries[counter].getKey();
				counter++;
				return key;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private class ArrayDictionaryValueIterator implements Iterator<V> {

		private int counter;

		public ArrayDictionaryValueIterator() {
			counter = 0;
		}

		@Override
		public boolean hasNext() {
			return counter < numberOfEntries;
		}

		@Override
		public V next() {
			if (hasNext()) {
				V value = entries[counter].getValue();
				counter++;
				return value;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	@SuppressWarnings("hiding")
	private class Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
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

	}

}
