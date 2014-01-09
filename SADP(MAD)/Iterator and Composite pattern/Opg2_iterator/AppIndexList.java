package Opg2_iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class AppIndexList {

	public static void main(String[] args) {
		IndexListI<String> list = new LinkedIndexList<String>();

		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.add(0, "Hanne");
		list.add(0, "Margrethe");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.remove(1));
		System.out.println(list.remove(0));
		System.out.println(list.size());
		System.out.println(list.isEmpty());

		list.add(0, "Jonas");
		list.add(0, "Simon");
		list.add(0, "Mark");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		try {
			it.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println("Caught right exception");
		}
		System.out.println("hasNext on empty list: " + it.hasNext());
		System.out.print("next on empty list: ");
		try {
			it.next();
		} catch (NoSuchElementException e) {
			System.out.println("cant do that, list empty");
		}

		IndexListI<String> list2 = new ArrayListIndexList<String>();
		list2.add(0, "Jonas");
		list2.add(0, "Simon");
		list2.add(0, "Mark");
		Iterator<String> it2 = list2.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		try {
			it2.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println("Caught right exception");
		}
		System.out.println("hasNext on empty list: " + it2.hasNext());
		System.out.print("next on empty list: ");
		try {
			it2.next();
		} catch (NoSuchElementException e) {
			System.out.println("cant do that, list empty");
		}

	}

}
