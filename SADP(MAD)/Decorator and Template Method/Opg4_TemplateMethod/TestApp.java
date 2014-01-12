package Opg4_TemplateMethod;

import java.util.Iterator;

public class TestApp {

	public static void main(String[] args) {
		Sekvens<String> agf = new ListSekvens<>();
		agf.add("tirsdag - basketball");
		agf.add("tirsdag - volleyball");
		agf.add("torsdag - fodbold");
		agf.add("torsdag - h�ndbold");

		Sekvens<String> aia = new ListSekvens<>();
		aia.add("tirsdag - basketball");
		aia.add("onsdag - floorball");
		aia.add("torsdag - fodbold");

		printer(agf.iterator());
		System.out.println();
		printer(aia.iterator());
		System.out.println();

		// OBS: findAlle og sammenlaegHold fjerner fra listen, s� begge p� �n
		// gang g�r ikke!
		System.out.println();
		FindAlleHold<String> flet = new FindAlleHold<>(aia, agf);
		// printer(flet.findAlle().iterator());

		System.out.println();
		System.out.println();
		Sammenl�gHold<String> sammenLaeg = new Sammenl�gHold<>(aia, agf);
		printer(sammenLaeg.sammenleagHold().iterator());

	}

	public static void printer(Iterator it) {
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
