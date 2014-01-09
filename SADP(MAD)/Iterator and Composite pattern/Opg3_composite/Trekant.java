package Opg3_composite;

public class Trekant extends FigurGruppe {

	private int a, b, c;

	public Trekant(int a, int b, int c) {
		super("Trekant");
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getOmkreds() {
		return a + b + c;
	}

}
