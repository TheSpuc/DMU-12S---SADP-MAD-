package Opg3;

import java.util.NoSuchElementException;

public class DoubleLinkedDeque<E> implements DequeI<E> {

	private Node head;
	private Node tail;
	private int numberOfEntries;

	// next ->
	// prev <-
	// head = as far left as you can come
	// tail = as far right as you can come

	public DoubleLinkedDeque() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		numberOfEntries = 0;
	}

	@Override
	public void addFirst(E e) {
		Node newNode = new Node();
		newNode.data = e;

		newNode.prev = head;
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		numberOfEntries++;

	}

	@Override
	public void addLast(E e) {
		Node newNode = new Node();
		newNode.data = e;

		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev.next = newNode;
		tail.prev = newNode;
		numberOfEntries++;

	}

	@Override
	public E removeFirst() {
		if (!isEmpty()) {
			Node toBeRemoved = head.next;
			toBeRemoved.next.prev = head;
			head.next = toBeRemoved.next;
			toBeRemoved.next = null;
			toBeRemoved.prev = null;
			numberOfEntries--;
			return toBeRemoved.data;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public E removeLast() {
		if (!isEmpty()) {
			Node toBeRemoved = tail.prev;
			toBeRemoved.prev.next = tail;
			tail.prev = toBeRemoved.prev;
			toBeRemoved.next = null;
			toBeRemoved.prev = null;
			numberOfEntries--;
			return toBeRemoved.data;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public E getFirst() {
		if (!isEmpty()) {
			return head.next.data;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public E getLast() {
		if (!isEmpty()) {
			return tail.prev.data;
		} else {
			throw new NoSuchElementException();
		}
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
		head.next = tail;
		tail.prev = head;
		numberOfEntries = 0;

	}

	private class Node {
		private Node next;
		private Node prev;
		private E data;
	}

}
