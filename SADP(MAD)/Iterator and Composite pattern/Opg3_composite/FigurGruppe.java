package Opg3_composite;

import java.util.ArrayList;
import java.util.Iterator;

public class FigurGruppe {
	private ArrayList<FigurGrupper> figurer;
	private String navn;

	public FigurGruppe(String navn) {
		this.navn = navn;
		figurer = new ArrayList<FigurGrupper>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

//	public double getOmkreds() {
//		Iterator<FigurGrupper> it = figurer.iterator();
//		double result = 0;
//		while (it.hasNext()) {
//			FigurGrupper f = it.next();
//			result += f.getOmkreds();
//		}
//		return result;
//	}

	public void add(FigurGrupper figur) {
		figurer.add(figur);
	}

	public void remove(FigurGrupper figur) {
		if (figurer.contains(figur)) {
			figurer.remove(figur);
		}
	}

	public FigurGrupper getChild(int i) {
		return figurer.get(i);
	}

//	public double getOmkreds() {
//		throw new UnsupportedOperationException();
//	}

}
