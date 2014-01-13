package Opg32_composite;

public abstract class Figur {

	private int x, y;
	private String navn;

	public Figur(String navn, int x, int y) {
		this.navn = navn;
		this.x = x;
		this.y = y;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract void tegn();

	public abstract int getOmkreds();

	public abstract double getAreal();

	public void addFigur(Figur f) {
		throw new UnsupportedOperationException();
	}

	public void removeFigur(Figur f) {
		throw new UnsupportedOperationException();
	}

}
