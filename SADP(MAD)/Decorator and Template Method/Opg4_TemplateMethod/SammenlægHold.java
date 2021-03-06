package Opg4_TemplateMethod;

public class SammenlægHold<E extends Comparable<E>> extends FletteTemplate<E> {

	private Sekvens<E> a;
	private Sekvens<E> b;

	public SammenlægHold(Sekvens<E> a, Sekvens<E> b) {
		this.a = a;
		this.b = b;
	}

	public Sekvens<E> sammenleagHold() {
		return flette(a, b, new ListSekvens<E>());
	}

	protected void flyt1(Sekvens<E> s) {
		s.tail();
	}

	protected void flyt2(Sekvens<E> s) {
		s.tail();
	}

	protected void flyt3(Sekvens<E> s1, Sekvens<E> s2) {
		g.add(s1.head());
		s1.tail();
		s2.tail();
	}

	protected void flytHale1(Sekvens<E> s) {
		s.tail();
	}

	protected void flytHale2(Sekvens<E> s) {
		s.tail();
	}
}
