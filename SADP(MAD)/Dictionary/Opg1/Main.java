package Opg1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Map<String, Kunde> kunde = new HashMap<String, Kunde>();
		Kunde k1 = new Kunde("12347", "123455", "Jonas", "Andersen");
		Kunde k2 = new Kunde("12346", "123465", "Vicki", "Buhl");
		Kunde k3 = new Kunde("12345", "123475", "Mark", "Bandgaard");
		Kunde k4 = new Kunde("12349", "123485", "Jonas", "Anders");
		Kunde k5 = new Kunde("12348", "123495", "Emil", "Andersen");
		kunde.put(k1.getTlfNr(), k1);
		kunde.put(k2.getTlfNr(), k2);
		kunde.put(k3.getTlfNr(), k3);
		kunde.put(k4.getTlfNr(), k4);
		kunde.put(k5.getTlfNr(), k5);
		
		System.out.println("Hashmap:\n");
		for(String k : kunde.keySet()){
			System.out.println(k);
		}
		
		for(Kunde k : kunde.values()){
			System.out.println(k);
		}
		
		System.out.println("\n\nTreemap: \n");
		
		Map<String, Kunde> kunde2 = new TreeMap<String, Kunde>();
		kunde2.put(k1.getTlfNr(), k1);
		kunde2.put(k2.getTlfNr(), k2);
		kunde2.put(k3.getTlfNr(), k3);
		kunde2.put(k4.getTlfNr(), k4);
		kunde2.put(k5.getTlfNr(), k5);
			
		for(String k : kunde2.keySet()){
			System.out.println(k);
		}
		
		for(Kunde k : kunde2.values()){
			System.out.println(k);
		}

	}

}
