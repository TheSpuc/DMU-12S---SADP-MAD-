package Opg2_BST;

import java.util.Iterator;

public interface BinarySearchTreeI<E extends Comparable<E>> extends BinaryTreeI<E>{
	public boolean contains(E element);
	public E get(E element);
	public E add(E element);
	public E remove(E element);
	public Iterator<E> inorderIterator();
	
	

}
