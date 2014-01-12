package Opg3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements DequeI<E> {

	private E[] deque;
	private int frontIndex, backIndex, numberOfEntries;

	// kan ikke få det til at virke :(

	@SuppressWarnings("unchecked")
	public ArrayDeque() {
		deque = (E[]) new Object[10];
		frontIndex = 0;
		backIndex = deque.length - 1;
		numberOfEntries = 0;
	}

	private void ensureCapacity() {
		if (frontIndex == (backIndex + 2) % deque.length) {
			// System.out.println("Before: " + Arrays.toString(deque));
			E[] oldDeque = deque;
			int oldSize = oldDeque.length;

			@SuppressWarnings("unchecked")
			E[] tempDeque = (E[]) new Object[2 * oldSize];
			deque = tempDeque;
			for (int index = 0; index < oldSize - 1; index++) {
				deque[index] = oldDeque[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
			// System.out.println("After: " + Arrays.toString(deque));
		}
	}

	@Override
	public void addFirst(E e) {
		ensureCapacity();
		deque[frontIndex] = e;
		frontIndex = (((frontIndex - 1) % deque.length) + deque.length) % deque.length;
		numberOfEntries++;
	}

	@Override
	public void addLast(E e) {
		ensureCapacity();
		deque[backIndex] = e;
		backIndex = (backIndex + 1) % deque.length;
		numberOfEntries++;
	}

	@Override
	public E removeFirst() {
		if (!isEmpty()) {
			E result = deque[frontIndex];
			deque[frontIndex] = null;
			frontIndex = (frontIndex + 1) % deque.length;
			numberOfEntries--;
			return result;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public E removeLast() {
		if (!isEmpty()) {
			E result = deque[backIndex];
			deque[backIndex] = null;
			backIndex = (((backIndex - 1) % deque.length) + deque.length) % deque.length;
			numberOfEntries--;
			System.out.println(result);
			return result;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public E getFirst() {
		if (!isEmpty()) {
			return deque[(frontIndex + 1) % deque.length];
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public E getLast() {
		if (!isEmpty()) {
			return deque[(((backIndex - 1) % deque.length) + deque.length) % deque.length];
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
		for (int i = 0; i < deque.length; i++) {
			deque[i] = null;
		}
		numberOfEntries = 0;
		frontIndex = 0;
		backIndex = 2;

	}

}
