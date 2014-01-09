package Opg2_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIndexList<E> implements IndexListI<E> {
	private Node start;
	private int size;

	public LinkedIndexList() {
		start = new Node(null, null);
		size = 0;
	}

	@Override
	public E get(int i) {
		E toReturn = null;
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = getNodeAt(i);
			toReturn = temp.getData();
		}
		return toReturn;
	}

	@Override
	public E remove(int i) {
		Node toReturn = null;
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = getNodeAt(i - 1);
			toReturn = temp.getNext();
			temp.setNext(toReturn.getNext());
			toReturn.setNext(null);
			size--;
		}
		return toReturn.getData();
	}

	@Override
	public void add(int i, E e) {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = getNodeAt(i - 1);
			Node newNode = new Node(temp.getNext(), e);
			temp.setNext(newNode);
			size++;
		}

	}

	@Override
	public E set(int i, E e) {
		E toReturn = null;
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = getNodeAt(i);
			toReturn = temp.getData();
			temp.setData(e);
		}
		return toReturn;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return start.getNext() == null;
	}

	private Node getNodeAt(int i) {
		Node toReturn = start;
		int j = 0;
		while (j <= i) {
			toReturn = toReturn.getNext();
			j++;
		}
		return toReturn;

	}

	private class Node {
		private Node next;
		private E data;

		public Node(Node next, E element) {
			this.next = next;
			this.data = element;
		}

		private Node getNext() {
			return next;
		}

		private void setNext(Node next) {
			this.next = next;
		}

		private E getData() {
			return data;
		}

		private void setData(E data) {
			this.data = data;
		}

	}

	@Override
	public Iterator<E> iterator() {

		return new LinkedIndexListIterator();
	}

	private class LinkedIndexListIterator implements Iterator<E> {

		private Node currentNode = start.next;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public E next() {
			if (hasNext()) {
				E data = currentNode.data;
				currentNode = currentNode.next;
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
