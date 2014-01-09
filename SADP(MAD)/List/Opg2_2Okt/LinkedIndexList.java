package Opg2_2Okt;

import java.util.NoSuchElementException;

public class LinkedIndexList<E> implements IndexListI<E> {

	public Node firstNode;
	private int numberOfEntries;

	public LinkedIndexList() {
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public E get(int i) throws NoSuchElementException {
		E result = null;
		if (i == 0 && numberOfEntries > 0) {
			result = firstNode.data;
		} else if (i > 0 && i < numberOfEntries) {
			Node temp = firstNode;
			for (int index = 0; index < i; index++) {
				temp = temp.next;
			}
			result = temp.data;
		} else {
			throw new NoSuchElementException();
		}
		return result;
	}

	@Override
	public E remove(int i) throws NoSuchElementException {
		E result = null;
		if (i == 0 && numberOfEntries > 0) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		} else if (i > 0 && i < numberOfEntries) {
			Node temp = firstNode;

			for (int index = 0; index + 1 < i; index++) {
				temp = temp.next;
			}
			Node toBeRemoved = temp.next;
			result = toBeRemoved.data;
			temp.next = toBeRemoved.next;
			numberOfEntries--;

		} else {
			throw new NoSuchElementException();
		}
		return result;
	}

	@Override
	public void add(int i, E newEntry) throws NoSuchElementException {
		if (i == 0) {
			Node newNode = new Node();
			newNode.data = newEntry;
			newNode.next = firstNode;
			firstNode = newNode;
			numberOfEntries++;
		} else if (i > 0 && i <= numberOfEntries) {
			Node newNode = new Node();

			Node temp = firstNode;
			for (int index = 0; index + 1 < i; index++) {
				temp = temp.next;
			}

			newNode.data = newEntry;
			newNode.next = temp.next;
			temp.next = newNode;
			numberOfEntries++;

		} else {
			throw new NoSuchElementException();
		}

	}

	@Override
	public void set(int i, E newEntry) throws NoSuchElementException {
		if (i == 0 && numberOfEntries > 0) {
			firstNode.data = newEntry;
		} else if (i > 0 && i <= numberOfEntries) {
			int index = 0;
			Node temp = firstNode;
			while (index < i && temp != null) {
				temp = temp.next;
				index++;
			}

			temp.data = newEntry;

		} else {
			throw new NoSuchElementException();
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNode == null;
	}

	public void printList() {
		Node temp = firstNode;
		for (int i = 0; i < numberOfEntries; i++) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		if (numberOfEntries == 0) {
			System.out.println("List is empty");
		}
	}

	private class Node {
		private Node next;
		private E data;
	}

}
