package Opg2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapHashDictionary<K, V> implements Dictionary<K, V> {

	private java.util.Map<K, V>[] tabel;
	private static int N = 3;

	/**
	 * HashingMap constructor comment.
	 */

	public MapHashDictionary() {
		tabel = new java.util.HashMap[N];
		for (int i = 0; i < N; i++)
			tabel[i] = new java.util.HashMap<K, V>();
	}

	public V get(K key) {
		int i = key.hashCode() % N;
		java.util.Map<K, V> m = tabel[i];
		return m.get(key);
	}

	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;
		while (empty && i < N) {
			empty = (tabel[i]).isEmpty();
			i++;
		}
		return empty;
	}

	public V put(K key, V value) {
		int i = key.hashCode() % N;
		java.util.Map<K, V> m = tabel[i];
		if ((double) size() / N > 0.9) {
			rehash();

		}
		return m.put(key, value);
	}

	private void rehash() {
		int prime = nextPrime(2 * N);
		System.out.println("HERE");
		java.util.Map<K, V>[] tempMap = new HashMap[prime];
		for (int j = 0; j < prime; j++) {
			tempMap[j] = new HashMap<K, V>();
		}
		Iterator<V> values = values();
		Iterator<K> keys = keys();
		tabel = tempMap;
		while (values.hasNext()) {
			// K key = keys.next();
			// V value = values.next();
			// int i = key.hashCode() % prime;
			// Map<K, V> m = tempMap[i];
			// m.put(key, value);
			put(keys.next(), values.next());
		}

	}

	private int nextPrime(int i) {
		i++;
		while (!isPrime(i)) {
			i += 2;
			System.out.println(i);
		}
		System.out.println("FOUND PRIME:" + i);
		return i;
	}

	private boolean isPrime(int i) {
		int j = 3;
		boolean isPrime = true;
		while (j * j < i && isPrime) {
			if (j % i == 0) {
				isPrime = false;
			} else {
				j += 2;
			}
		}
		return isPrime;
	}

	public V remove(K key) {
		int i = key.hashCode() % N;
		java.util.Map<K, V> m = tabel[i];
		return m.remove(key);
	}

	public int size() {
		int size = 0;
		for (int i = 0; i < N; i++) {
			size += tabel[i].size();
		}
		return size;
	}

	/**
	 * @see dictionary.Dictionary#keys()
	 */
	public Iterator<K> keys() {

		int i = 0;
		Set<K> s = new HashSet<K>();
		while (i < N) {
			java.util.Map<K, V> m = tabel[i];
			s.addAll(m.keySet());
			i++;
		}
		return s.iterator();
	}

	public Iterator<V> values() {
		int i = 0;
		List<V> s = new ArrayList<V>();
		while (i < N) {
			java.util.Map<K, V> m = tabel[i];
			s.addAll(m.values());
			i++;
		}
		return s.iterator();
	}

}
