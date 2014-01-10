package Opg3_BST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>
		implements BinarySearchTreeI<E> {

	@Override
	public boolean contains(E entry) {
		BinaryNodeI<E> node = findEntry((BinaryNode) root(), entry);
		return node != null;
	}

	@Override
	public E get(E entry) {
		E result = null;
		BinaryNodeI<E> node = findEntry((BinaryNode) root(), entry);
		if (node != null) {
			result = node.getData();
		}
		return result;
	}

	@Override
	public E add(E entry) {
		E result = null;
		if (root()==null){
			super.addRoot(entry);
		}
		else {
			result = addEntry((BinaryNode) root(), entry);
		}
		return result;
	}

	private E addEntry(BinaryNode node, E entry) {
		E result = null;
		if (node.getData().compareTo(entry)==0){
			result = node.getData();
			node.setData(entry);
		}
		else if (entry.compareTo(node.getData()) < 0) {
			if (hasLeft(node)) {
				result = addEntry((BinaryNode) left(node), entry);
			} else {
				node.setLeft(new BinaryNode(entry));
				incSize();
			}
		}
		else{
			if (hasRight(node)) {
				result = addEntry((BinaryNode) right(node), entry);
			}
			else {
				node.setRight(new BinaryNode(entry));
				incSize();
			}
		}
		return result;
	}

	@Override
	public E remove(E entry) {
		E result = null;
		if (!isEmpty()){
			if (root().getData().compareTo(entry)==0){ // det er roden der skal slettes 
				result = root().getData();
				decSize();
				removeRoot();
			}
			else if (entry.compareTo(root().getData())<0){
				result = removeEntry((BinaryNode)left(root()), entry, (BinaryNode)root());
			}
			result = removeEntry((BinaryNode)right(root()), entry,(BinaryNode)root());
		}
		return result;
	}
	
	private void removeRoot(){
		if (!hasLeft(root())&& !hasRight(root())){ // træet bliver tomt
			setRoot(null);
		}
		else if(!hasRight(root())){ // roden har ikke højre barn
			setRoot(left(root()));
		}
		else if(!hasLeft(root())){ // roden har ikke venstre barn
			setRoot(right(root()));
		}
		else{						// roden har efterfølger til både venstre og  højre
			removeNodeTwoChildren((BinaryNode)root());
		}
		
	}
	
	private E removeEntry(BinaryNode node, E entry, BinaryNode father){
		E result = null;
		if (entry.compareTo(node.getData())==0){
			result = node.getData();
			decSize();
			if (!hasLeft(node)){// der er ikke et venstre barn
				if (node.equals(father.getLeft())){
					father.setLeft(right(node));
				}else{
					father.setRight(right(node));
				}
				
			} else if (!hasRight(node)){ // der er ikke et højre barn
				if (node.equals(father.getLeft())){
					father.setLeft(left(node));
				}else{
					father.setRight(left(node));
				}
				
			}
			else{ // der er både højre og venstre barn}
				removeNodeTwoChildren(node);
			}
			
		}
		else if (entry.compareTo(node.getData())<0){
			if (hasLeft(node))
				removeEntry((BinaryNode)left(node), entry, node);
		}
		else{
			if (hasRight(node))
				removeEntry((BinaryNode)right(node), entry, node);
			
		}
		return result;
		
	}

	private void removeNodeTwoChildren(BinaryNode node){
		BinaryNode current =(BinaryNode) right(node);
		BinaryNode behind = node;
		while (hasLeft(current)){
			behind = current;
			current = (BinaryNode)left(current);
		}
		node.setData(current.getData());
		if (behind!=node){
			behind.setLeft(right(current));
		} else{
			node.setRight(right(current));
		}
	}
	@Override
	public Iterator<E> inorderIterator() {
		List<E> list = new ArrayList<E>();
		inorder(list,(BinaryNode)root());
		return list.iterator();
	}
	
	private void inorder(List<E> list, BinaryNode node){
		if (node != null){
			inorder(list, (BinaryNode)left(node));
			list.add(node.getData());
			inorder(list, (BinaryNode)right(node));
		}
	
	}

	private BinaryNode findEntry(BinaryNode node, E entry) {
		BinaryNode result = null;
		if (node != null) {
			if (node.getData().compareTo(entry)==0) {
				result = node;
			} else if (node.getData().compareTo(entry) < 0) {
				result = findEntry((BinaryNode) right(node), entry);
			} else {
				result = findEntry((BinaryNode) left(node), entry);
			}
		}
		return result;
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
		throw new UnsupportedOperationException(
				"Indholdet i binærtsøgetræ kan ikke opdateres");
	}

	/**
	 * Opretter og returnerer roden i træet med indhold e
	 * 
	 * @return roden til træet
	 * @exception hvis
	 *                træet ikke er tomt
	 */
	public BinaryNodeI<E> addRoot(E e) {
		throw new UnsupportedOperationException(
				"Roden kan ikke oprettes i bimærtsøgetræ");
	}

	/**
	 * Opretter og returnerer en ny knude som venstrebarn til v
	 * 
	 * @return ny knude
	 * @exception hvis
	 *                v allerede har et venstre barn
	 * 
	 */
	@Override
	public BinaryNodeI<E> insertLeft(BinaryNodeI<E> v, E e) {
		throw new UnsupportedOperationException(
				"Kan ikke indsætte vilkårligt i binærtsøgetræ");
	}

	/**
	 * Opretter og returnerer en ny knude som højrebarn til v
	 * 
	 * @return ny knude
	 * @exception hvis
	 *                v allerede har et højre barn
	 */
	@Override
	public BinaryNodeI<E> insertRight(BinaryNodeI<E> v, E e) {
		throw new UnsupportedOperationException(
				"Kan ikke indsætte vilkårligt i binærtsøgetræ");
	}
	
	

}
