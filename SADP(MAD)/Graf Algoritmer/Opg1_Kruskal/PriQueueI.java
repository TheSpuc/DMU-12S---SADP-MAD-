package Opg1_Kruskal;

import java.util.NoSuchElementException;

public interface PriQueueI<T> {
	/**
	 * Indsæt data med en prioritet i listen
	 * 
	 * @param priority
	 * @param data
	 */
	public void insert(int priority, T data);

	/**
	 * Fjerner og retunerer element med den laveste prioritet fra køen. Tom kø =
	 * Exception
	 * 
	 * @return Fjernet element
	 * @throws NoSuchElementException
	 */
	public T removeMin() throws NoSuchElementException;

	/**
	 * Retunere element med laveste prioritet fra køen. Tom kø = Exception
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	public T min() throws NoSuchElementException;

	/**
	 * Retunere antallet af elementer i køen
	 * 
	 * @return antal af elementer
	 */
	public int size();

	/**
	 * Retunere om køen er tom.
	 * 
	 * @return angiver om køen er tom.
	 */
	public boolean isEmpty();

}
