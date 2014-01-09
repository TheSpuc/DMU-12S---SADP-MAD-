package Opg2_2Okt;

import java.util.NoSuchElementException;

import Opg2.QueueI;

public class IndexQueue<T> implements QueueI<T> {

	private IndexListI<T> indexList;

	public IndexQueue(IndexListI<T> indexList) {
		this.indexList = indexList;
	}

	@Override
	public void enqueue(T newElement) {
		indexList.add(indexList.size() , newElement);

	}

	@Override
	public T dequeue() throws NoSuchElementException {

		return indexList.remove(0);
	}

	@Override
	public T getFront() throws NoSuchElementException {
		return indexList.get(0);
	}

	@Override
	public boolean isEmpty() {

		return indexList.isEmpty();
	}

	@Override
	public void clear() {
		int size = indexList.size();
		for (int i = 0; i < size; i++) {
			indexList.remove(0);
		}

	}
}
