package Opg1;

public class StackUse {

	public static <E> void reverse(E[] tabel) {
//		 StackI<E> stak = new ArrayStack<E>(tabel.length);
		StackI<E> stak = new ListStack<E>();
		//StackI<E> stak = new LinkedStack<E>();
		for (int i = 0; i < tabel.length; i++) {
			stak.push(tabel[i]);
		}
		int i = 0;
		while (!stak.isEmpty()) {
			tabel[i] = stak.pop();
			i++;
		}

	}

	public static void main(String[] args) {

		Integer[] tal = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		reverse(tal);
		for (int i = 0; i < tal.length; i++)
			System.out.print(tal[i] + " ");
	}

}
