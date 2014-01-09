package Opg2;

public class StackUse {

	// public static <E> void reverse(E[] tabel) {
	// // StackI<E> stak = new ArrayStack<E>(tabel.length);
	// StackI<E> stak = new ListStack<E>();
	// //StackI<E> stak = new LinkedStack<E>();
	// for (int i = 0; i < tabel.length; i++) {
	// stak.push(tabel[i]);
	// }
	// int i = 0;
	// while (!stak.isEmpty()) {
	// tabel[i] = stak.pop();
	// i++;
	// }
	//
	// }

	public static void main(String[] args) {

		// Integer[] tal = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String s = "ABCDDCBA";
		System.out.println(s + ": " + palindrom(s));
		String s2 = "ABCDEFGHFEDCBA";
		System.out.println(s2 + ": " + palindrom(s2));
	}

	private static <E> boolean palindrom(String s) {
		boolean palindrom = true;
		int halfSize = s.length() / 2;
		int index = 0;
		StackI<Character> stak = new ArrayStack<>(halfSize);

		while (index < halfSize) {
			stak.push(s.charAt(index));
			index++;
		}

		if (halfSize % 2 == 1) {
			index++;
		}

		while (index < s.length() && palindrom) {
			if (stak.pop().equals(s.charAt(index))) {
				index++;
			} else {
				palindrom = false;
			}
		}
		return palindrom;

	}

}
