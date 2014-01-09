package Opg1;

import java.util.NoSuchElementException;

public class TestIndexLinkedList {
	public static void main(String[] args) {
		IndexListI<String> list = new LinkedIndexList<String>();
		list.printList();
		list.add(0, "Mike");
		list.add(0, "Jonas");
		list.add(1, "Jacob");
		list.add(3, "Niklas");
		list.printList();
		System.out.println("\nGetting element no 2 (Result = Mike): " + list.get(2));
		try {
			System.out.print(list.get(-1));

		} catch (NoSuchElementException e) {
			System.out.println("\nCAUGHT NO SUCH ELEMENTEXCEPTION!");
		}
		try {
			System.out.print(list.remove(4));

		} catch (NoSuchElementException e) {
			System.out.println("\nCAUGHT NO SUCH ELEMENTEXCEPTION!");
		}

		list.printList();

		System.out.println("NumberOfElements " + list.size());

		System.out.println("Is list empty? " + list.isEmpty());
		list.remove(0);
		list.remove(0);
		list.remove(0);
		System.out.println("\nNumberOfElements " + list.size());

		System.out.println("Is list empty? " + list.isEmpty());
		list.remove(0);
		System.out.println("\nNumberOfElements " + list.size());

		System.out.println("Is list empty? " + list.isEmpty());
		try {
			System.out.print(list.get(0));

		} catch (NoSuchElementException e) {
			System.out.println("\n noSuchElement get Method on empty list");
		}
		try {
			System.out.print(list.remove(0));

		} catch (NoSuchElementException e) {
			System.out.println("\n noSuchElement remove Method on empty list");
		}

		try {
			list.set(0, "Hej");

		} catch (NoSuchElementException e) {
			System.out.println("\n noSuchElement set Method on empty list");
		}

		list.add(0, "Stefan");
		System.out.print("\nReplacing Stefan with Martin..");
		list.set(0, "Martin");
		System.out.println(list.get(0));

		list.add(0, "Hans");
		list.add(2, "Sigh");
		System.out.print("\nReplacing Martin with Jonas..");
		list.set(1, "Jonas");
		System.out.println(list.get(1));

	}
}
