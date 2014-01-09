package Opg2;

import java.util.NoSuchElementException;

import Opg2_2Okt.QueueI;

public class NodeQueue<E> implements QueueI<E> {

	private Node front, back;
	private E[] queue;

	public NodeQueue(int maxSize) {
		queue = (E[]) new Object[maxSize + 1];
		front = null;
		back = null;
	}

	@Override
	public void enqueue(E newElement) {

	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getFront() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	private class Node {
		private E data;
		private Node next;
	}

}
