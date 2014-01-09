package Opg3_priorityQueue;

import java.util.NoSuchElementException;

public class Test {
	public static void main(String[] args) {
		PriQueueI<String> queue = new PriQueue<String>();
		queue.insert(6, "Hans");
		queue.insert(3, "Ib");
		queue.insert(6, "Jens");
		queue.insert(4, "Mads");
		queue.insert(6, "Lene");
		queue.insert(2, "Finn");
		System.out.println(queue);
		System.out.println(queue.size());
		System.out.println(queue.removeMin());
		System.out.println(queue);
		System.out.println(queue.removeMin());
		System.out.println(queue.removeMin());
		System.out.println(queue.removeMin());
		System.out.println(queue.removeMin());
		System.out.println(queue.isEmpty());
		System.out.println(queue.removeMin());
		System.out.println(queue.isEmpty());
		try {
			System.out.println(queue.removeMin());
		} catch (NoSuchElementException e) {
			System.out.print("Got it.");
		}
		try {
			System.out.println(queue.min());
		} catch (NoSuchElementException e) {
			System.out.print("... Got it again.");
		}
		System.out.println(", size: " + queue.size());
		queue.insert(-1, "neg kasper");
		queue.insert(500, "stor kasper");
		System.out.println(queue);

//		PriQueueI<String> dnc = new DoesNotCompile<String>();

	}
}
