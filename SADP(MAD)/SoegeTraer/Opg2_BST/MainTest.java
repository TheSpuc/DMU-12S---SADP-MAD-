package Opg2_BST;

public class MainTest {

	public static void main(String[] args) {
		BinarySearchTreeI<Integer> bst = new BinarySearchTree<>();
		bst.add(45);
		bst.add(22);
		bst.add(77);
		bst.add(11);
		bst.add(30);
		bst.add(90);
		bst.add(15);
		bst.add(25);
		bst.add(88);

		System.out.println(((BinarySearchTree<Integer>) bst).findMax());

		for (int i = 0; i < 20; i++) {
			System.out.println(((BinarySearchTree<Integer>) bst).removeMin());
		}
	}

}
