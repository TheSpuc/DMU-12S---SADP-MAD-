package Opg32_composite;

public abstract class FigurComponent {

	public String getNavn() {
		throw new UnsupportedOperationException();
	}

	public void setNavn(String navn) {
		throw new UnsupportedOperationException();
	}

	public abstract void tegn();

	public abstract int getOmkreds();

	public void addFigur(FigurComponent f) {
		throw new UnsupportedOperationException();
	}

	public void removeFigur(FigurComponent f) {
		throw new UnsupportedOperationException();
	}

}
