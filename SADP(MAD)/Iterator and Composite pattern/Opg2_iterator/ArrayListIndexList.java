package Opg2_iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayListIndexList<E> implements IndexListI<E> {

	private List<E> list;
	private int counter;

	public ArrayListIndexList() {
		list = new ArrayList<E>();
		counter = 0;
	}

	@Override
	public E get(int i) {
		return list.get(i);
	}

	@Override
	public E remove(int i) {
		counter++;
		return list.remove(i);
	}

	@Override
	public void add(int i, E e) {
		counter++;
		list.add(i, e);

	}

	@Override
	public E set(int i, E e) {
		return list.set(i, e);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIndexListIterator();
	}

	private class ArrayListIndexListIterator implements Iterator<E> {
		private int count = 0;
		private final int itCounter = counter;

		@Override
		public boolean hasNext() {
			return list.size() > count;
		}

		@Override
		public E next() {
			if (itCounter != counter) {
				throw new ConcurrentModificationException();
			}
			if (hasNext()) {
				E data = list.get(count);
				count++;
				return data;
			} else
				throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}
	}
}
