package Opg4_Niclas;

import java.util.Random;

public class CircularEatingTable {

	private Node firstNode, personWhoHasBeenEated;
	private int numberOfEntries;

	private boolean started;

	public CircularEatingTable() {
		firstNode = new Node();
		firstNode.setNext(firstNode);
		numberOfEntries = 0;
		personWhoHasBeenEated = firstNode;
		started = false;
	}

	/**
	 * addPerson
	 */
	public void addPersonToMenu(Person newEntry) {
		Node post = firstNode.getNext();
		Node newNode = new Node(newEntry, post);
		firstNode.setNext(newNode);
		numberOfEntries++;
	}

	/**
	 * O(n)
	 */
	public void printMenu() {
		Node temp = firstNode.getNext();
		String result = "[";
		if (numberOfEntries != 0) {
			while (temp != firstNode) {
				result += temp.getData();
				if (temp.getNext() != firstNode) {
					result += ", ";
				}
				temp = temp.getNext();
			}
		} else {
			result += "The menu is empty";
		}
		System.out.println(result + "]");
	}

	/**
	 * O(1)
	 * 
	 * Method for getting the first person to be eaten
	 * 
	 * @return the first element to be removed
	 */
	public Person randomStart() {
		Person p = null;
		// If there are items in the list and the method has not yet been run
		if (numberOfEntries > 0 && !started) {
			// Random generator which generate a number between 0 and 1337
			Random rand = new Random();
			int randomValue = rand.nextInt(1337);

			Node pre = firstNode;
			// randomStart is the first element is removed from the list and
			// returned
			Node randomStart = firstNode.getNext();
			Node post = randomStart.getNext();

			// køre så længe den tilfældige værdi er større end 0 eller at min
			// tilfældige person ikke peger på
			// min firstnode.
			while (randomValue > 0 || randomStart == firstNode) {
				pre = randomStart;
				randomStart = post;
				post = post.getNext();
				randomValue--;
			}

			pre.setNext(post);
			p = randomStart.getData();
			personWhoHasBeenEated = randomStart;
			numberOfEntries--;
		} else {
			System.err.println("The menu is empty");
		}
		return p;
	}

	/**
	 * O(n)
	 */
	public Person eatPerson(int count) {
		Person p = null;
		if (numberOfEntries > 0) {

			Node pre = null;
			Node toBeEaten = personWhoHasBeenEated;
			Node post = personWhoHasBeenEated.getNext();

			int i = 0;
			while (i < count || toBeEaten == firstNode) {
				pre = toBeEaten;
				toBeEaten = post;
				post = post.getNext();
				i++;
			}

			personWhoHasBeenEated = toBeEaten;
			pre.setNext(post);
			p = toBeEaten.getData();
			numberOfEntries--;

		} else {
			System.err.println("There is no people on the menu");
		}
		return p;
	}

	private class Node {
		private Person data;
		private Node next;

		public Node() {
			this(null);
		}

		public Node(Person data) {
			this(data, null);
		}

		public Node(Person data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Person getData() {
			return data;
		}

		public void setData(Person data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
