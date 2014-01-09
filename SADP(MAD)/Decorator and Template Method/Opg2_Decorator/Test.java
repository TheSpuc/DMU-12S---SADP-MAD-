package Opg2_Decorator;

public class Test {

	public static void main(String[] args) {
		Bil mondeo = new Mondeo();
		System.out.println(mondeo.getBeskrivelse());
		System.out.println(mondeo.getPris());
		mondeo = new LaederIndtraek(mondeo);
		mondeo = new Metallak(mondeo);
		mondeo = new Bakkesensor(mondeo);
		System.out.println(mondeo.getBeskrivelse());
		System.out.println(mondeo.getPris());

		Bil focus = new Focus();
		System.out.println(focus.getBeskrivelse());
		System.out.println(focus.getPris());
		focus = new LaederIndtraek(focus);
		System.out.println(focus.getPris());
		focus = new Turbo(focus);
		System.out.println(focus.getPris());
		focus = new Metallak(focus);
		System.out.println(focus.getBeskrivelse());
		System.out.println(focus.getPris());
	}

}
