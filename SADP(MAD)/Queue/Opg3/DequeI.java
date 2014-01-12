package Opg3;

public interface DequeI<E> {

	/**
	 * Insert element e at the front of the deque
	 * 
	 * @param e
	 */
	public void addFirst(E e);

	/**
	 * Insert element e at the back of the deque
	 * 
	 * @param e
	 */
	public void addLast(E e);

	/**
	 * Remove and return element from the front of the deque. If deque is empty,
	 * NoSuchElementException is thrown.
	 * 
	 * @return
	 */
	public E removeFirst();

	/**
	 * Remove and return element from the back of the deque. If deque is empty,
	 * NoSuchElementException is thrown.
	 * 
	 * @return
	 */
	public E removeLast();

	/**
	 * Returns element from the front of the deque. If deque is empty,
	 * NoSuchElementException is thrown.
	 * 
	 * @return
	 */
	public E getFirst();

	/**
	 * Returns element from the front of the deque. If deque is empty,
	 * NoSuchElementException is thrown.
	 * 
	 * @return
	 */
	public E getLast();

	/**
	 * Returns number of elements in the deque.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Returns whether of not the deque is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Empties deque.
	 */
	public void clear();

}
