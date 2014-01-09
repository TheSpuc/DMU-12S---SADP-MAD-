package Opg2;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		DictionaryI<Integer, String> list = new LinkedDictionary<Integer, String>();
		list.put(4, "Jonas");
		list.put(3, "hans");
		list.put(1, "mike");
		list.put(2, "Mark");
		list.put(5, "christian");
		list.put(4, "Joachim");
		list.put(5, "jacob");
		list.put(5, "Margethe");

		Iterator<Integer> keys = list.keys();

		while (keys.hasNext()) {
			System.out.print("\t" + keys.next());
		}
		System.out.println();
		Iterator<String> values = list.values();
		while (values.hasNext()) {
			System.out.print("\t" + values.next());
		}

	}

}
