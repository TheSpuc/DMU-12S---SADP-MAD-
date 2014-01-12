package Opg4_TemplateMethod;

public class FindAlleHold<E extends Comparable<E>> extends FletteTemplate<E> {

	private Sekvens<E> a;
	private Sekvens<E> b;

	public FindAlleHold(Sekvens<E> a, Sekvens<E> b) {
		this.a = a;
		this.b = b;
	}

	public Sekvens<E> findAlle() {
		return flette(a, b, new ListSekvens<E>());
	}

	protected void flyt1(Sekvens<E> s) {
		g.add(s.head());
		s.tail();
	}

	protected void flyt2(Sekvens<E> s) {
		g.add(s.head());
		s.tail();
	}

	protected void flyt3(Sekvens<E> s1, Sekvens<E> s2) {
		g.add(s1.head());
		g.add(s2.head());
		s1.tail();
		s2.tail();
	}

	protected void flytHale1(Sekvens<E> s) {
		g.add(s.head());
		s.tail();
	}

	protected void flytHale2(Sekvens<E> s) {
		g.add(s.head());
		s.tail();
	}
}
