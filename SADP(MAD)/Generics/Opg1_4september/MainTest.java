package Opg1_4september;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		Person<String> p1 = new Person<>("Jonas");
		System.out.println(p1.getNavn());

		Person<Navn> p2 = new Person<>(new Navn("Simon", "Andersen"));
		Person<Navn> p3 = new Person<>(new Navn("Jacob", "Poulsen"));
		Person<Navn> p4 = new Person<>(new Navn("Jonas", "Andersen"));
		Person<Navn> p5 = new Person<>(new Navn("Joachim", "Nyborg"));
		Person<Navn> p6 = new Person<>(new Navn("Jannik", "Lol"));
		List<Person<Navn>> list = new ArrayList<>();
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		for (Person<Navn> p : list) {
			System.out.println(p);
		}
		System.out.println();
		Collections.sort(list);
		for (Person<Navn> p : list) {
			System.out.println(p);
		}

	}
}
