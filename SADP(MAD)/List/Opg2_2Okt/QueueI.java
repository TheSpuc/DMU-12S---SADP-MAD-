package Opg2_2Okt;

import java.util.NoSuchElementException;

public interface QueueI<E> {

	/**
	 * Indsaetter elementet newElement bagerst i koen
	 * 
	 * @param newElement
	 */
	public void enqueue(E newElement);

	/**
	 * Fjerner og retunere det forreste element i koen. Hvis metoden kaldes pa
	 * en tom ko kastes en exception
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	public E dequeue() throws NoSuchElementException;

	/**
	 * Retunere det forreste element i koen. Hvis metoden kaldes på en tom ko
	 * kastes en exception.
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	public E getFront() throws NoSuchElementException;

	/**
	 * Retunere true hvis koen er tom, false hvis koen ikke er tom.
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Tommer koen.
	 */
	public void clear();

}
