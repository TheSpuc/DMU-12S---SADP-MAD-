package Opg1;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueI<E> {

	private E[] queue;
	private int front, back;

	public ArrayQueue(int maxSize) {
		queue = (E[]) new Object[maxSize+1];
		front = 0;
		back = maxSize;
	}

	public void enqueue(E newElement) {
		if (front == ((back + 2) % queue.length)) {
			System.out.println("Doubleing size");
			E[] oldqueue = queue;
			int oldSize = queue.length;

			E[] newQueue = (E[]) new Object[2 * oldSize];
			queue = newQueue;
			for (int i = 0; i < oldSize - 1; i++) {
				queue[i] = oldqueue[front];
				front = (front + 1) % oldSize;
			}
			front = 0;
			back = oldSize - 2;
		}
		back = (back + 1) % queue.length;
		queue[back] = newElement;

	}

	public E dequeue() throws NoSuchElementException {
		E result = null;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			result = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
		}
		return result;
	}

	public E getFront() throws NoSuchElementException {
		E result = null;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			result = queue[front];
		}
		return result;
	}

	public boolean isEmpty() {
		return front == (back + 1) % queue.length;
	}

	public void clear() {
		for (int i = 0; i < queue.length; i++) {
			queue[i] = null;
		}
		front = 0;
		back = queue.length - 1;
	}

}
