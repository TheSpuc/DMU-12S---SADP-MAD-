package Opg3_TemplateMethod;

public class SearchableArray<E extends Comparable<E>> extends SearchPattern<E> {

	private E[] list;
	private int counter;

	public SearchableArray(E[] list) {
		this.list = list;
	}

	@Override
	protected void init() {
		counter = 0;

	}

	@Override
	protected boolean isEmpty() {

		return counter == list.length;
	}

	@Override
	protected E select() {
		return list[counter];
	}

	@Override
	protected void split(E m) {
		counter++;
	}

}
