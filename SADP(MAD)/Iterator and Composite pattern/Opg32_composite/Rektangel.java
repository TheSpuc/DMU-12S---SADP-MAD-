package Opg32_composite;

public class Rektangel extends Figur {

	private int s1, s2;

	public Rektangel(int x, int y, int s1, int s2) {
		super("Rektangel", x, y);
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void tegn() {
		System.out.println(getNavn());

	}

	@Override
	public int getOmkreds() {
		return 2 * s1 + 2 * s2;
	}

	@Override
	public double getAreal() {
		return s1 * s2;
	}

}
