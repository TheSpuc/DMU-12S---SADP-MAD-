package Opg32_composite;

public class TestApp {

	public static void main(String[] args) {
		Figur snemand = new FigurGruppe("Snemand", 0, 0);
		snemand.addFigur(new Ellipse(0, 0, 10, 10));
		snemand.addFigur(new Ellipse(0, 5, 5, 5));
		snemand.addFigur(new Ellipse(0, 7, 2, 2));
		snemand.tegn();
		System.out.println("Arealet af denne 2d snemand er: " + snemand.getAreal());
		System.out.println("Omkredsen af denne 2d snemand er: " + snemand.getOmkreds() + "\n");

		Figur hus = new FigurGruppe("Hus", 0, 0);
		hus.addFigur(new Rektangel(0, 0, 5, 10));
		hus.addFigur(new RetvinkletTrekant(0, 0, 5, 5));
		hus.tegn();
		System.out.println("Arealet af dette hus er: " + hus.getAreal());
		System.out.println("Omkredsen af dette hus er: " + hus.getOmkreds());

	}

}
