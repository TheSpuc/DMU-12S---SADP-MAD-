package Opg4_Niclas;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		CircularEatingTable menu = new CircularEatingTable();
		addPersons(menu);

		menu.printMenu();

		Scanner scan = new Scanner(System.in);

		System.out.println("You need to eat " + menu.randomStart());

		boolean open = true;
		while (open) {
			System.out.println("Please input a number");
			int count = scan.nextInt();
			if (count == 0) {
				open = false;
			}
			Person p = menu.eatPerson(count);
			if (p != null) {
				System.out.println("You need to eat " + p);
			} else {
				open = false;
			}
		}
	}

	private static void addPersons(CircularEatingTable menu) {
		menu.addPersonToMenu(new Person("Jonas"));
		menu.addPersonToMenu(new Person("Jonas"));
		menu.addPersonToMenu(new Person("Lizette"));
		menu.addPersonToMenu(new Person("Mark"));
		menu.addPersonToMenu(new Person("Simon"));
		menu.addPersonToMenu(new Person("Tomas"));
		menu.addPersonToMenu(new Person("Martin"));
		menu.addPersonToMenu(new Person("Nicolai"));
		menu.addPersonToMenu(new Person("Margrethe"));
		menu.addPersonToMenu(new Person("Christine"));
		menu.addPersonToMenu(new Person("Casper"));
		menu.addPersonToMenu(new Person("Niclas"));
		menu.addPersonToMenu(new Person("Sig"));
		menu.addPersonToMenu(new Person("Emil"));
		menu.addPersonToMenu(new Person("Henrik"));
		menu.addPersonToMenu(new Person("Vicki"));
		menu.addPersonToMenu(new Person("Jeppe"));
		menu.addPersonToMenu(new Person("Jakob"));
		menu.addPersonToMenu(new Person("Hans"));
		menu.addPersonToMenu(new Person("Michael"));
		menu.addPersonToMenu(new Person("Tobias"));
		menu.addPersonToMenu(new Person("Christian"));
		menu.addPersonToMenu(new Person("Soeren"));
		menu.addPersonToMenu(new Person("Stefan"));
	}

}
