package Opg4_TemplateMethod;

import java.util.Iterator;

public interface Sekvens<E> {
	/**
	 * Objektet obj er adderet bagerst i sekvensen
	 * 
	 * @param obj
	 */
	public void add(E obj);

	/**
	 * Objekterne fra s er adderet bagerst i sekvensen, i samme rækkefælge som
	 * de er i s
	 * 
	 * @param s
	 */
	public void addAll(Sekvens<E> s);

	/**
	 * Krav: sekvensen er ikke tom Retunere det første objekt i sekvensen.
	 * Sekvensen ændres ikke.
	 * 
	 * @return
	 */
	public E head();

	/**
	 * Retunere om sekvensen er tom
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Retunere en iterator over sekvensen
	 * 
	 * @return
	 */
	public Iterator<E> iterator();

	/**
	 * Krav: sekvensen er ikke tom Det første objekt i sekvensen er fjernet fra
	 * sekvensen.
	 */
	public void tail();
}
