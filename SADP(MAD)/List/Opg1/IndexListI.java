package Opg1;

import java.util.NoSuchElementException;

public interface IndexListI<E> {

	public E get(int i) throws NoSuchElementException;

	public E remove(int i) throws NoSuchElementException;

	public void add(int i, E newEntry) throws NoSuchElementException;

	public void set(int i, E newEntry) throws NoSuchElementException;

	public int size();

	public boolean isEmpty();

	public void printList();

}
