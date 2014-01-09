package Opg3_composite;

public class Firkant extends FigurGruppe {

	int a, b;

	public Firkant(int a, int b) {
		super("Firkant");
		this.a = a;
		this.b = b;
	}

	public double getOmkreds() {
		return 2 * a + 2 * b;
	}

}
