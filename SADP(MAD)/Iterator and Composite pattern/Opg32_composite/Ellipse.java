package Opg32_composite;

public class Ellipse extends Figur {

	private int r1, r2;

	public Ellipse(int x, int y, int r1, int r2) {
		super("Ellipse", x, y);
		this.r1 = r1;
		this.r2 = r2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tegn() {
		System.out.println(getNavn());

	}

	@Override
	public int getOmkreds() {
		return (int) ((r1 + r2) * Math.PI);
	}

	@Override
	public double getAreal() {
		return Math.PI * r1 * r2;
	}
}
