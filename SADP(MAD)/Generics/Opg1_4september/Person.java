package Opg1_4september;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {

	private T navn;

	public Person(T navn) {
		this.navn = navn;
	}

	public T getNavn() {
		return navn;
	}

	public void setNavn(T navn) {
		this.navn = navn;
	}

	@Override
	public int compareTo(Person<T> arg0) {
		return navn.compareTo(arg0.getNavn());
	}

	@Override
	public String toString() {
		return "Person [navn=" + navn + "]";
	}

}
