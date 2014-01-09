package Opg3_BST;

import java.util.Iterator;

public class BinarySearchhtreeApp {

	public static void main(String[] args) {
		BinarySearchTreeI<Integer> btree = new BinarySearchTree<>();
		btree.add(45);
		btree.add(77);
		btree.add(22);
		btree.add(30);
		btree.add(90);
		btree.add(88);
		btree.add(25);
		btree.add(11);
		btree.add(15);
		System.out.println("Hele træet");
		Iterator<Integer> itr = btree.inorderIterator();
		while (itr.hasNext()){
			System.out.print(itr.next() + ", ");
		}
//		System.out.println();
//		System.out.println("Maksimum er " + ((BinarySearchTreeOpgave)btree).findMax());
//		System.out.println("Minimum er slettet" + ((BinarySearchTreeOpgave)btree).removeMin());
		itr = btree.inorderIterator();
		while (itr.hasNext()){
			System.out.print(itr.next() + ", ");
		}
		System.out.println();
		btree.remove(45);
		System.out.println("45 er væk");
		itr = btree.inorderIterator();
		while (itr.hasNext()){
			System.out.print(itr.next() + ", ");
		}
		System.out.println();
	}

}
