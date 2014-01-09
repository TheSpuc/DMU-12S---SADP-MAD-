package Opg1_Kruskal;

import java.util.NoSuchElementException;

public class PriQueue<T> implements PriQueueI<T> {

	private Item<T>[] queue;
	private int numberOfElements;

	public PriQueue() {
		@SuppressWarnings("unchecked")
		Item<T>[] temp = new Item[10];
		queue = temp;

	}

	@Override
	public void insert(int priority, T data) {
		if (numberOfElements == queue.length) {
			@SuppressWarnings("unchecked")
			Item<T>[] newArray = new Item[2 * numberOfElements];
			for (int i = 0; i < numberOfElements; i++) {
				newArray[i] = queue[i];
			}
			queue = newArray;
			System.out.println("Expanded array");
		}
		Item<T> newItem = new Item<T>();
		newItem.setData(data);
		newItem.setPriority(priority);
		queue[numberOfElements] = newItem;
		numberOfElements++;

	}

	@Override
	public T removeMin() throws NoSuchElementException {
		Item<T> highestPriotrity = null;
		if (numberOfElements > 0) {
			int indexOfHigh = 0;
			for (int i = 0; i < numberOfElements; i++) {
				if (queue[i].getPriority() < queue[indexOfHigh].getPriority()) {
					indexOfHigh = i;
				}
			}
			highestPriotrity = queue[indexOfHigh];
			// OBS SKAL MÅSKE VÆRE NOE -1!!
			for (int j = indexOfHigh; j < numberOfElements; j++) {
				queue[j] = queue[j + 1];
			}
			numberOfElements--;

		} else {
			throw new NoSuchElementException();
		}
		return highestPriotrity.getData();
	}

	@Override
	public T min() throws NoSuchElementException {
		Item<T> highestPriotrity = null;
		if (numberOfElements > 0) {
			int indexOfHigh = 0;
			for (int i = 0; i < numberOfElements; i++) {
				if (queue[i].getPriority() < queue[indexOfHigh].getPriority()) {
					indexOfHigh = i;
				}
			}
			highestPriotrity = queue[indexOfHigh];

		} else {
			throw new NoSuchElementException();
		}
		return highestPriotrity.getData();
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	public String toString() {
		String result = "[";
		for (int i = 0; i < numberOfElements; i++) {
			result += queue[i].getData() + ", ";
		}
		result = result.substring(0, result.length() - 2) + "]";
		return result;
	}

}
