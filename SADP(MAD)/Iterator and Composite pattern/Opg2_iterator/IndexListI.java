package Opg2_iterator;

import java.util.Iterator;

public interface IndexListI<E> {
	/**
	 * @return returnerer elementet p� plads nummer i i listen
	 * @throws IndexOutOfBoundsEception
	 *             hvis i<0 eller i>= antal elementer i listen
	 */
	public E get(int i);

	/**
	 * @return fjerner og returnerer elementet p� plads nummer i i listen
	 * @throws IndexOutOfBoundsEception
	 *             hvis i<0 eller i>= antal elementer i listen
	 */
	public E remove(int i);

	/**
	 * @return Inds�tter elementet e p� indeks plads i i listen. Elementerne p�
	 *         plads i og frem, f�r indeks plads en h�jere
	 * @throws IndexOutOfBoundsEception
	 *             hvis i<0 eller i> antal elementer i listen
	 */
	public void add(int i, E e);

	/**
	 * @return Overskriver elementet p� indeks plads i i listen med elementet
	 *         E.. Det element der oprindeligt stod p� indeks plads i
	 *         returneres.
	 * @throws IndexOutOfBoundsEception
	 *             hvis i<0 eller i>= antal elementer i listen
	 */
	public E set(int i, E e);

	/**
	 * 
	 * @return Returnerer antallet af elementer i listen
	 */
	public int size();

	/**
	 * 
	 * @return Returnerer om listen er tom
	 */
	public boolean isEmpty();

	public Iterator<E> iterator();

}
