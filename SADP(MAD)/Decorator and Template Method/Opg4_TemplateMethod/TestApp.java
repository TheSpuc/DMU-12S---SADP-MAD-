package Opg4_TemplateMethod;

import java.util.Iterator;

public class TestApp {

	public static void main(String[] args) {
		Sekvens<String> agf = new ListSekvens<>();
		agf.add("tirsdag - basketball");
		agf.add("tirsdag - volleyball");
		agf.add("torsdag - fodbold");
		agf.add("torsdag - håndbold");

		Sekvens<String> aia = new ListSekvens<>();
		aia.add("tirsdag - basketball");
		aia.add("onsdag - floorball");
		aia.add("torsdag - fodbold");

		printer(agf.iterator());
		System.out.println();
		printer(aia.iterator());
		System.out.println();

		// OBS: findAlle og sammenlaegHold fjerner fra listen, så begge på én
		// gang går ikke!
		System.out.println();
		FindAlleHold<String> flet = new FindAlleHold<>(aia, agf);
		// printer(flet.findAlle().iterator());

		System.out.println();
		System.out.println();
		SammenlægHold<String> sammenLaeg = new SammenlægHold<>(aia, agf);
		printer(sammenLaeg.sammenleagHold().iterator());

	}

	public static void printer(Iterator it) {
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
