package Opg3_composite;

public class Ellipse extends FigurGruppe {

	int a, b;

	public Ellipse(int d) {
		super("Ellipse");
		this.a = d;
		this.b = d;
	}

	public Ellipse(int a, int b) {
		super("Ellipse");
		this.a = a;
		this.b = b;
	}

	public double getOmkreds() {
		return 3.14159 * (a + b);
	}
}
