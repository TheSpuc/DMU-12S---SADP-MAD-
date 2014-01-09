package Opg2;

import java.util.*;

/**
 * Abstrakt datatype: Binary Tree
 * 
 * @version (10-11-2013)
 * @author Margrethe Dybdahl
 */
public interface BinaryTreeI<E> {

	/**
	 * Returnerer antallet af knuder i det bin�re tr�.
	 * 
	 * @return antallet af knuder i tr�et
	 */
	public int size();

	/**
	 * Returnerer om tr�et er tomt
	 * 
	 * @return om tr�et er tomt
	 */

	public boolean isEmpty();

	/**
	 * Returnerer en iterator med indholdet i det bin�re tr�.
	 * 
	 * @return iterator over knuderne i det bin�re tr�
	 */
	public Iterator<E> elements();

	/**
	 * Erstatter objektet indeholdt i knuden n med objektet o
	 * 
	 * @param v
	 *            knuden der skal have nyt element
	 * @param e
	 *            det nye element
	 * @return det objekt der oprindelig var p� v's plads
	 * 
	 */
	public E replace(BinaryNodeI<E> v, E e);

	/**
	 * Returnerer roden af det bin�re tr�.
	 * 
	 * @return roden til tr�et
	 * @exception java.lang.Exception
	 *                hvis tr�et er tomt
	 */
	public BinaryNodeI<E> root();

	/**
	 * Returnerer om v er in intern knude.
	 * 
	 * @param v
	 *            knuden der skal afg�res om er intern
	 * @return true hvis v er intern ellers false
	 */
	public boolean isInternal(BinaryNodeI<E> v);

	/**
	 * Returnerer om v er in ekstern knude.
	 * 
	 * @param v
	 *            knuden der skal afg�res om er ekstern
	 * @return true hvis n er ekstern ellers false
	 */
	public boolean isExternal(BinaryNodeI<E> v);

	/**
	 * Returnerer om v er roden i tr�et.
	 * 
	 * @param v
	 *            knuden der skal afg�res om er roden
	 * @return true hvis v er roden ellers false
	 */
	public boolean isRoot(BinaryNodeI<E> v);

	/**
	 * Opretter og returnerer roden i tr�et med indhold e
	 * 
	 * @return roden til tr�et
	 * @exception hvis
	 *                tr�et ikke er tomt
	 */
	public BinaryNodeI<E> addRoot(E e);

	/**
	 * Returnerer det venstre barn til knuden v.
	 * 
	 * @param v
	 *            knuden der skal findes venstre barn til
	 * @return det venstre barn til knuden v
	 * @exception hvis
	 *                det ikke findes
	 */
	public BinaryNodeI<E> left(BinaryNodeI<E> v);

	/**
	 * Returnerer det h�jre barn til knuden v.
	 * 
	 * @param v
	 *            knuden der skal findes h�jre barn til
	 * @return det h�jre barn til knuden v.
	 * @exception hvis
	 *                det ikke findes
	 */
	public BinaryNodeI<E> right(BinaryNodeI<E> n);

	/**
	 * Returnerer om v har et venstre barn
	 * 
	 * @return om v har et venstre barn
	 */
	public boolean hasLeft(BinaryNodeI<E> v);

	/**
	 * Returnerer om v har et h�jre barn
	 * 
	 * @return om v har et venstre barn
	 */
	public boolean hasRight(BinaryNodeI<E> v);

	/**
	 * Opretter og returnerer en ny knude som venstrebarn til v
	 * 
	 * @return ny knude
	 * @exception hvis
	 *                v allerede har et venstre barn
	 * 
	 */
	public BinaryNodeI<E> insertLeft(BinaryNodeI<E> v, E e);

	/**
	 * Opretter og returnerer en ny knude som h�jrebarn til v
	 * 
	 * @return ny knude
	 * @exception hvis
	 *                v allerede har et h�jre barn
	 */
	public BinaryNodeI<E> insertRight(BinaryNodeI<E> v, E e);

}
