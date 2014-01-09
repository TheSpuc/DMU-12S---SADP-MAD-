package Opg2_2Okt;

import java.util.NoSuchElementException;

public class Test {

	public static void main(String[] args) {

		IndexListI<Integer> list = new LinkedIndexList<Integer>();
		IndexQueue<Integer> queue = new IndexQueue<Integer>(list);
		queue.enqueue(5);
		System.out.print("Test getFront(): " + queue.getFront());
		System.out.println(", Test dequeue(): " + queue.dequeue());
		System.out.print("Is list empty: " + queue.isEmpty());
		queue.enqueue(1);
		System.out.println(", Added new entry, list is now: " + queue.isEmpty());
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(6);
		System.out.print("list of all elements: ");
		for (int i = 0; i < 9; i++) {
			try {
				System.out.print(queue.dequeue() + ", ");
			} catch (NoSuchElementException e) {
				System.out.println("\nCAUGHT NO SUCH ELEMENTEXCEPTION!");
			}
		}
		try {
			System.out.print("Peeking in empty queue...");
			queue.getFront();
		} catch (NoSuchElementException e) {
			System.out.println(" --- >CAUGHT NO SUCH ELEMENTEXCEPTION!");
		}

	}

}
