package OpgRecursive;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		BinarySearchTree<String> bst = new BinarySearchTree<>();

		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		list.add("J");
		list.add("K");
		list.add("L");
		list.add("M");
		list.add("N");
		System.out.println(list);

		insertRecursive(bst, list);
		System.out.println(((BinarySearchTree<String>) bst).findMax());

		for (int i = 0; i < 14; i++) {
			System.out.println(((BinarySearchTree<String>) bst).removeMin());
		}
	}

	public static <E extends Comparable<E>> void insertRecursive(BinarySearchTree<E> bst, List<E> sortedList) {

		if (sortedList.size() > 0) {
			int half = sortedList.size() / 2;

			List<E> listUnder = new ArrayList<>();
			int i = 0;
			while (i < half) {
				listUnder.add(sortedList.get(i));
				i++;
			}
			List<E> listOver = new ArrayList<>();
			i = half + 1;
			while (i < sortedList.size()) {
				listOver.add(sortedList.get(i));
				i++;
			}
			bst.add(sortedList.get(half));
			sortedList.remove(half);
			insertRecursive(bst, listUnder);
			insertRecursive(bst, listOver);
		}
	}
}
