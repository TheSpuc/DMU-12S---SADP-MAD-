package Opg3;

public class SingleLinkedStackDropout<T> implements StackI<T> {

	private Node top;
	private int capacity;
	private int numberOfEntries;

	public SingleLinkedStackDropout(int capacity) {
		this.capacity = capacity;
		top = null;
		numberOfEntries = 0;
	}

	@Override
	public void push(T newEntry) {
		Node newNode = new Node();
		newNode.data = newEntry;
		newNode.next = top;
		top = newNode;
		if (numberOfEntries + 1 > capacity) {
			int index = 0;
			Node current = top;
			while (index < capacity - 1) {
				current = current.next;
				index++;
			}
			current.next = null;
		} else {
			numberOfEntries++;
		}

	}

	@Override
	public T pop() {
		T result = null;
		if (top != null) {
			result = top.data;
			top = top.next;
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public T peek() {
		T result = null;
		if (top != null) {
			result = top.data;
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void clear() {
		top = null;
		numberOfEntries = 0;
	}

	private class Node {
		private T data;
		private Node next;
	}

}
