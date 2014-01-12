package Opg32_composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FigurGruppe extends FigurComponent {

	List<FigurComponent> figurer;

	private String gruppeNavn;
	private String gruppeBeskrivelse;

	public FigurGruppe(String gruppeNavn, String gruppeBeskrivelse) {
		figurer = new ArrayList<>();
		this.gruppeNavn = gruppeNavn;
		this.gruppeBeskrivelse = gruppeBeskrivelse;
	}

	@Override
	public void tegn() {
		System.out.println(getGruppeNavn() + ", " + getGruppeBeskrivelse() + "\n");

		Iterator<FigurComponent> it = figurer.iterator();
		while (it.hasNext()) {
			FigurComponent f = it.next();
			f.tegn();
		}

		System.out.println();

	}

	@Override
	public int getOmkreds() {
		int result = 0;
		Iterator<FigurComponent> it = figurer.iterator();
		while (it.hasNext()) {
			FigurComponent f = it.next();
			result += f.getOmkreds();
		}
		return result;
	}

	public String getGruppeNavn() {
		return gruppeNavn;
	}

	public String getGruppeBeskrivelse() {
		return gruppeBeskrivelse;
	}

	public void addFigur(FigurComponent f) {
		figurer.add(f);
	}

	public void removeFigur(FigurComponent f) {
		figurer.remove(f);
	}

}
