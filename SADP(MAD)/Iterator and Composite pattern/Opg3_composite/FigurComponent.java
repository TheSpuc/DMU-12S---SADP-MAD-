package Opg3_composite;

import java.util.ArrayList;

public abstract class FigurComponent {

	private ArrayList<FigurComponent> components;
	private String navn;

	public FigurComponent(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void addFigurComponent(FigurComponent f) {
		throw new UnsupportedOperationException();
	}

	public void removeFigurComponent(FigurComponent f) {
		throw new UnsupportedOperationException();
	}

	public FigurComponent getChild(int i) {
		return components.get(i);
	}

	public int getOmkreds() {
		throw new UnsupportedOperationException();
	}

	public void tegn() {
		System.out.println();
	}
}
