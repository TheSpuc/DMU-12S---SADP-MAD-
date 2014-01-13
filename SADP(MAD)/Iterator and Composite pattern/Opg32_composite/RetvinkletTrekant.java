package Opg32_composite;

public class RetvinkletTrekant extends Figur {
	private int h, g;

	public RetvinkletTrekant(int x, int y, int h, int g) {
		super("RetvinkletTrekant", x, y);
		this.h = h;
		this.g = g;
	}

	@Override
	public void tegn() {
		System.out.println(getNavn());

	}

	@Override
	public int getOmkreds() {
		return (int) (h + g + Math.sqrt(Math.pow(h, 2) + Math.pow(g, 2)));
	}

	@Override
	public double getAreal() {
		return 0.5 * h * g;
	}

}
