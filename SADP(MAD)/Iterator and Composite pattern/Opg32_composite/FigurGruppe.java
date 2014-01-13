package Opg32_composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FigurGruppe extends Figur {

	private List<Figur> figurer;

	public FigurGruppe(String navn, int x, int y) {
		super(navn, x, y);
		figurer = new ArrayList<>();
	}

	@Override
	public void tegn() {
		System.out.println(getNavn() + " består af:");
		Iterator<Figur> it = figurer.iterator();
		while (it.hasNext()) {
			Figur f = it.next();
			f.tegn();

		}
	}

	@Override
	public int getOmkreds() {
		Iterator<Figur> it = figurer.iterator();
		int result = 0;
		while (it.hasNext()) {
			Figur f = it.next();
			result += f.getOmkreds();
		}
		return result;
	}

	@Override
	public double getAreal() {
		Iterator<Figur> it = figurer.iterator();
		double result = 0;
		while (it.hasNext()) {
			Figur f = it.next();
			result += f.getAreal();
		}
		return result;
	}

	public void addFigur(Figur f) {
		figurer.add(f);
	}

	public void removeFigur(Figur f) {
		figurer.remove(f);
	}
}
