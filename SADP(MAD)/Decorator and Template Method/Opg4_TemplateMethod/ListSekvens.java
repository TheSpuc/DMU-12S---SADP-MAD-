package Opg4_TemplateMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSekvens<E> implements Sekvens<E> {

	private List<E> list;

	public ListSekvens() {
		list = new ArrayList<>();
	}

	@Override
	public void add(E obj) {
		list.add(obj);

	}

	@Override
	public void addAll(Sekvens<E> s) {
		Iterator<E> it = s.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
	}

	@Override
	public E head() {
		return list.get(0);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public void tail() {
		list.remove(0);

	}

}
