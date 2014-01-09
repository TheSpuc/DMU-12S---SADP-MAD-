package Opg2;

public class Opg2 {

	private static BinaryTreeI<Integer> tree;

	public static void main(String[] args) {

		tree = new BinaryTree<>();
		BinaryNodeI<Integer> root = tree.addRoot(45);
		BinaryNodeI<Integer> node22 = tree.insertLeft(root, 22);
		BinaryNodeI<Integer> node11 = tree.insertLeft(node22, 11);
		BinaryNodeI<Integer> node15 = tree.insertRight(node11, 15);
		BinaryNodeI<Integer> node30 = tree.insertRight(node22, 30);
		BinaryNodeI<Integer> node25 = tree.insertLeft(node30, 25);
		BinaryNodeI<Integer> node77 = tree.insertRight(root, 77);
		BinaryNodeI<Integer> node90 = tree.insertRight(node77, 90);
		BinaryNodeI<Integer> node88 = tree.insertLeft(node90, 88);
		System.out.println(treeHeight(tree.root()));

		System.out.println("preorder: ");
		preOrder(tree.root());
		System.out.println("\ninorder: ");
		inOrder(tree.root());
		System.out.println("\npostorder: ");
		postOrder(tree.root());

		System.out.println(preOrder(root, "preorder2"));

	}

	public static int treeHeight(BinaryNodeI<Integer> node) {
		int result = 0;
		if (node != null) {
			int left = treeHeight(tree.left(node));
			int right = treeHeight(tree.right(node));
			if (left > right) {
				result = left;
			} else {
				result = right;
			}
			result++;
		} else {
			result = 0;
		}
		return result;
	}

	public static void preOrder(BinaryNodeI<Integer> node) {
		if (node != null) {
			System.out.println(node.getData());
			preOrder(tree.left(node));
			preOrder(tree.right(node));
		}
	}

	public static String preOrder(BinaryNodeI<Integer> node, String input) {
		String result = input;
		if (node != null) {
			result = preOrder(tree.left(node), node.getData() + ", ");
			result = preOrder(tree.right(node), node.getData() + ", ");
		}
		return result;
	}

	public static void inOrder(BinaryNodeI<Integer> node) {
		if (node != null) {
			inOrder(tree.left(node));
			System.out.println(node.getData());
			inOrder(tree.right(node));
		}
	}

	public static void postOrder(BinaryNodeI<Integer> node) {
		if (node != null) {
			postOrder(tree.left(node));
			postOrder(tree.right(node));
			System.out.println(node.getData());
		}
	}
}
