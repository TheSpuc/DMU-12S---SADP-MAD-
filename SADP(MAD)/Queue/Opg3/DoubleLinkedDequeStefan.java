package Opg3;

public class DoubleLinkedDequeStefan<E> implements DequeI<E> {
	private Node tail;
	private Node head;
	private int numberOfEntries;

	public DoubleLinkedDequeStefan() {
		numberOfEntries = 0;
		tail = new Node(null);
		head = new Node(null);
		tail.prev = head;
		head.next = tail;
	}

	@Override
	public void addLast(E newEntry) {
		Node toInsert = new Node(newEntry);
		toInsert.next = tail;
		toInsert.prev = tail.prev;

		tail.prev.next = toInsert;
		tail.prev = toInsert;
		numberOfEntries++;
	}

	@Override
	public void addFirst(E newEntry) {
		Node toInsert = new Node(newEntry);
		toInsert.next = head.next;
		toInsert.prev = head;

		head.next.prev = toInsert;
		head.next = toInsert;
		numberOfEntries++;
	}

	public E removeLast() {
		if (!isEmpty()) {
			Node toRemove = tail.prev;
			E temp = toRemove.data;
			tail.prev = toRemove.prev;
			toRemove.prev.next = tail;
			numberOfEntries--;
			return temp;
		}
		return null;
	}

	@Override
	public E removeFirst() {
		if (!isEmpty()) {
			Node toRemove = head.next;
			E temp = toRemove.data;
			head.next = toRemove.next;
			toRemove.next.prev = head;
			numberOfEntries--;
			return temp;
		}
		return null;
	}

	@Override
	public E getLast() {
		E result = null;
		if (!isEmpty()) {
			result = tail.prev.data;
		}
		return result;
	}

	@Override
	public E getFirst() {
		E result = null;
		if (!isEmpty()) {
			result = head.next.data;
		}
		return result;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public void clear() {
		tail.prev = head;
		head.next = tail;
		numberOfEntries = 0;
	}

	private class Node {
		private E data;
		private Node next;
		private Node prev;

		public Node(E data) {
			this.data = data;
		}
	}

	public String toString() {
		String s = "";
		Node temp = head.next;
		while (temp != tail) {
			s += " -- " + temp.data;
			temp = temp.next;
		}
		return s;
	}
}
