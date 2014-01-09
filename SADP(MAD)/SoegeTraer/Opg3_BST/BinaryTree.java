package Opg3_BST;

import java.util.*;

/**
 * Abstrakt datatype: Binary Tree
 * 
 * @version (10-11-2013)
 * @author Margrethe Dybdahl
 */
public class BinaryTree<E> implements BinaryTreeI<E> {

	private int size = 0;
	private BinaryNode root;

	/**
	 * Returnerer antallet af knuder i det binære træ.
	 * 
	 * @return antallet af knuder i træet
	 */
	public int size() {
		return size;
	}

	protected void incSize(){
		size++;
	}
	
	protected void decSize(){
		size--;
	}
	/**
	 * Returnerer om træet er tomt
	 * 
	 * @return om træet er tomt
	 */

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Returnerer en iterator med indholdet i det binære træ.
	 * 
	 * @return iterator over knuderne i det binære træ
	 */
	public Iterator<E> elements() {
		ArrayList<E> list =  new ArrayList<E>();
		inorderRek(list,root);
		return list.iterator();
	}

	private void inorderRek(ArrayList<E> list, BinaryNodeI<E> node){
		if (node!=null){
			inorderRek(list, left(node));
			list.add(node.getData());
			inorderRek(list,right(node));
		}
		
		
	}
	/**
	 * Erstatter objektet indeholdt i knuden n med objektet o
	 * 
	 * @param v
	 *            knuden der skal have nyt element
	 * @param e
	 *            det nye element
	 * @return det objekt der oprindelig var på v's plads
	 * 
	 */
	public E replace(BinaryNodeI<E> v, E e) {
		BinaryNode node = (BinaryNode)v;
		E data = node.getData();
		node.setData(e);
		return data;
	}

	/**
	 * Returnerer roden af det binære træ.
	 * 
	 * @return roden til træet
	 * @exception java.lang.Exception
	 *                hvis træet er tomt
	 */
	public BinaryNodeI<E> root() {
		return root;
	}

	/**
	 * Returnerer om v er in intern knude.
	 * 
	 * @param v
	 *            knuden der skal afgøres om er intern
	 * @return true hvis v er intern ellers false
	 */
	public boolean isInternal(BinaryNodeI<E> v) {
		BinaryNode node = (BinaryNode)v;
		return (node.getLeft()!= null) || (node.getRight()!=null);
	}

	/**
	 * Returnerer om v er in ekstern knude.
	 * 
	 * @param v
	 *            knuden der skal afgøres om er ekstern
	 * @return true hvis n er ekstern ellers false
	 */
	public boolean isExternal(BinaryNodeI<E> v) {
		BinaryNode node = (BinaryNode)v;
		return (node.getLeft()==null) && (node.getRight()==null);
	}

	/**
	 * Returnerer om v er roden i træet.
	 * 
	 * @param v
	 *            knuden der skal afgøres om er roden
	 * @return true hvis v er roden ellers false
	 */
	public boolean isRoot(BinaryNodeI<E> v) {
		return v.equals(root);
	}

	/**
	 * Opretter og returnerer roden i træet med indhold e
	 * 
	 * @return roden til træet
	 * @exception hvis
	 *                træet ikke er tomt
	 */
	public BinaryNodeI<E> addRoot(E e) {
		root = new BinaryNode(e);
		return root;
	}

	/**
	 * Returnerer det venstre barn til knuden v.
	 * 
	 * @param v
	 *            knuden der skal findes venstre barn til
	 * @return det venstre barn til knuden v
	 * @exception hvis
	 *                det ikke findes
	 */
	public BinaryNodeI<E> left(BinaryNodeI<E> v) {
		BinaryNode node = (BinaryNode)v;
		return node.getLeft();
	}

	/**
	 * Returnerer det højre barn til knuden v.
	 * 
	 * @param v
	 *            knuden der skal findes højre barn til
	 * @return det højre barn til knuden v.
	 * @exception hvis
	 *                det ikke findes
	 */
	public BinaryNodeI<E> right(BinaryNodeI<E> v) {
		BinaryNode node = (BinaryNode)v;
		return node.getRight();
	}

	/**
	 * Returnerer om v har et venstre barn
	 * 
	 * @return om v har et venstre barn
	 */
	public boolean hasLeft(BinaryNodeI<E> v) {
		BinaryNode node = (BinaryNode)v;
		return node.getLeft()!=null;
	}

	/**
	 * Returnerer om v har et højre barn
	 * 
	 * @return om v har et venstre barn
	 */
	public boolean hasRight(BinaryNodeI<E> v) {
		BinaryNode node = (BinaryNode)v;
		return node.getRight() !=null;
	}

	/**
	 * Opretter og returnerer en ny knude som venstrebarn til v
	 * 
	 * @return ny knude
	 * @exception hvis
	 *                v allerede har et venstre barn
	 * 
	 */
	public BinaryNodeI<E> insertLeft(BinaryNodeI<E> v, E e) {
		BinaryNode node = (BinaryNode)v;
		if (hasLeft(node))
			throw new RuntimeException("Har allerede venstre barn");
		BinaryNode newNode = new BinaryNode(e);
		node.setLeft(newNode);
		size++;
		return newNode;
	}

	/**
	 * Opretter og returnerer en ny knude som højrebarn til v
	 * 
	 * @return ny knude
	 * @exception hvis
	 *                v allerede har et højre barn
	 */
	public BinaryNodeI<E> insertRight(BinaryNodeI<E> v, E e) {
		BinaryNode node = (BinaryNode)v;
		if (hasRight(node))
			throw new RuntimeException("Har allerede højre barn");
		BinaryNode newNode = new BinaryNode(e);
		node.setRight(newNode);
		size++;
		return newNode;
	}

	protected void setRoot(BinaryNodeI<E> v){
		root = (BinaryNode)v;
	}
	
	protected class BinaryNode implements BinaryNodeI<E> {

		private E data;
		private BinaryNode left;
		private BinaryNode right;

		public BinaryNode() {
			this(null);
		}

		public BinaryNode(E data) {
			this(data, null, null);
		}

		public BinaryNode(E data, BinaryNode left, BinaryNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public E getData() {
			return data;
		}

		public void setData(E e) {
			data = e;
		}

		public BinaryNodeI<E> getLeft() {
			return left;
		}

		public BinaryNodeI<E> getRight() {
			return right;
		}

		public void setLeft(BinaryNodeI<E> left) {
			this.left = (BinaryNode) left;
		}

		public void setRight(BinaryNodeI<E> right) {
			this.right = (BinaryNode) right;
		}

		
		

	}
}
