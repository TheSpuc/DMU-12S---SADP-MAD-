package Opg1_Kruskal;

public class Item<T> {
	private int priority;
	private T data;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		return "P: " + priority + " Content: " + data;
	}
}
