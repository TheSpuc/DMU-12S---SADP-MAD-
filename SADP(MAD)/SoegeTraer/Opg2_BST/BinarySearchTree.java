package Opg2_BST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements BinarySearchTreeI<E> {

	@Override
	public boolean contains(E element) {
		BinaryNodeI<E> node = findElement((BinaryNode) root(), element);
		return node != null;
	}

	@Override
	public E get(E element) {
		E result = null;
		BinaryNodeI<E> node = findElement((BinaryNode) root(), element);
		if (node != null) {
			result = node.getData();
		}
		return result;
	}

	@Override
	public E add(E element) {
		E result = null;
		if (root() == null) {
			super.addRoot(element);
		} else {
			result = addElement((BinaryNode) root(), element);
		}
		return result;
	}

	private E addElement(BinaryNode node, E element) {
		E result = null;
		if (node.getData().equals(element)) { // entry er allerede i det bin�re
												// s�getr�
			result = node.getData();
			node.setData(element);
		} else if (element.compareTo(node.getData()) < 0) {
			if (hasLeft(node)) {
				result = addElement((BinaryNode) left(node), element);
			} else {
				node.setLeft(new BinaryNode(element));
				incSize();
			}
		} else {
			if (hasRight(node)) {
				result = addElement((BinaryNode) right(node), element);
			} else {
				node.setRight(new BinaryNode(element));
				incSize();
			}
		}
		return result;
	}

	@Override
	public E remove(E element) {
		E result = null;
		if (!isEmpty()) {
			if (root().getData().equals(element)) { // det er roden der skal
													// slettes
				result = root().getData();
				decSize();
				removeRoot();
			} else if (element.compareTo(root().getData()) < 0) {
				result = removeElement((BinaryNode) left(root()), element, (BinaryNode) root());
			} else {
				result = removeElement((BinaryNode) right(root()), element, (BinaryNode) root());
			}
		}
		return result;
	}

	private void removeRoot() {
		if (!hasLeft(root()) && !hasRight(root())) { // tr�et bliver tomt
			setRoot(null);
		} else if (!hasRight(root())) { // roden har ikke h�jre barn
			setRoot(left(root()));
		} else if (!hasLeft(root())) { // roden har ikke venstre barn
			setRoot(right(root()));
		} else { // roden har efterf�lger til b�de venstre og h�jre
			removeNodeTwoChildren((BinaryNode) root());
		}

	}

	private E removeElement(BinaryNode node, E element, BinaryNode father) {
		E result = null;
		if (element.equals(node.getData())) {
			result = node.getData();
			decSize();
			if (!hasLeft(node)) {// der er ikke et venstre barn
				if (node.equals(father.getLeft())) {
					father.setLeft(right(node));
				} else {
					father.setRight(right(node));
				}

			} else if (!hasRight(node)) { // der er ikke et h�jre barn
				if (node.equals(father.getLeft())) {
					father.setLeft(left(node));
				} else {
					father.setRight(left(node));
				}

			} else { // der er b�de h�jre og venstre barn}
				removeNodeTwoChildren(node);
			}

		} else if (element.compareTo(node.getData()) < 0) {
			if (hasLeft(node))
				removeElement((BinaryNode) left(node), element, node);
		} else {
			if (hasRight(node))
				removeElement((BinaryNode) right(node), element, node);

		}
		return result;

	}

	private void removeNodeTwoChildren(BinaryNode node) {
		BinaryNode current = (BinaryNode) right(node);
		BinaryNode behind = node;
		while (hasLeft(current)) {
			behind = current;
			current = (BinaryNode) left(current);
		}
		node.setData(current.getData());
		if (behind != node) {
			behind.setLeft(right(current));
		} else {
			node.setRight(right(current));
		}
	}

	@Override
	public Iterator<E> inorderIterator() {
		List<E> list = new ArrayList<E>();
		inorder(list, (BinaryNode) root());
		return list.iterator();
	}

	private void inorder(List<E> list, BinaryNode node) {
		if (node != null) {
			inorder(list, (BinaryNode) left(node));
			list.add(node.getData());
			inorder(list, (BinaryNode) right(node));
		}

	}

	/**
	 * Returnerer den knude element findes i ellers returneres null Del-l�s og
	 * kombiner skabelonen
	 * 
	 * @param node
	 * @param element
	 * @return
	 */

	private BinaryNode findElement(BinaryNode node, E element) {
		BinaryNode result = null;
		if (node != null) {
			if (node.getData().equals(element)) {
				result = node;
			} else if (node.getData().compareTo(element) < 0) {
				result = findElement((BinaryNode) right(node), element);
			} else {
				result = findElement((BinaryNode) left(node), element);
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
	 * @return det objekt der oprindelig var p� v's plads
	 * 
	 */
	public E replace(BinaryNodeI<E> v, E e) {
		throw new UnsupportedOperationException("Indholdet i bin�rts�getr� kan ikke opdateres");
	}

	/**
	 * Opretter og returnerer roden i tr�et med indhold e
	 * 
	 * @return roden til tr�et
	 * @exception hvis
	 *                tr�et ikke er tomt
	 */
	public BinaryNodeI<E> addRoot(E e) {
		throw new UnsupportedOperationException("Roden kan ikke oprettes i bim�rts�getr�");
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
		throw new UnsupportedOperationException("Kan ikke inds�tte vilk�rligt i bin�rts�getr�");
	}

	/**
	 * Opretter og returnerer en ny knude som h�jrebarn til v
	 * 
	 * @return ny knude
	 * @exception hvis
	 *                v allerede har et h�jre barn
	 */
	@Override
	public BinaryNodeI<E> insertRight(BinaryNodeI<E> v, E e) {
		throw new UnsupportedOperationException("Kan ikke inds�tte vilk�rligt i bin�rts�getr�");
	}

	/**
	 * Retunere det største element i det binære søgetræ
	 * 
	 * @return
	 */
	public E findMax() {
		E result = null;
		if (!isEmpty()) {
			BinaryNodeI<E> node = root();
			while (hasRight(node)) {
				node = right(node);
			}
			result = node.getData();
		}
		return result;
	}

	/**
	 * Fjerner knuden med det mindste element i det binære søgetræ og retunere
	 * værdien af dette
	 * 
	 * @return
	 */
	public E removeMin() {
		E result = null;
		if (!isEmpty()) {
			BinaryNodeI<E> node = root();
			while (hasLeft(node)) {
				node = left(node);
			}
			result = node.getData();
			remove(result);
		}
		return result;
	}

}
