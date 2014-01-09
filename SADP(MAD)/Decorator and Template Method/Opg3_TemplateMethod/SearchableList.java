package Opg3_TemplateMethod;

import java.util.List;

public class SearchableList<E extends Comparable<E>> extends SearchPattern<E> {

	private List<E> list;
	private int counter;

	public SearchableList(List<E> list) {
		this.list = list;
	}

	@Override
	protected void init() {
		counter = 0;
	}

	@Override
	protected boolean isEmpty() {

		return counter == list.size();
	}

	@Override
	protected E select() {

		return list.get(counter);
	}

	@Override
	protected void split(E m) {
		counter++;

	}

}
