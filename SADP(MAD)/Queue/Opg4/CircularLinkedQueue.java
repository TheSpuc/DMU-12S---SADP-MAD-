package Opg4;

public class CircularLinkedQueue {

	private Node lastNode;

	public CircularLinkedQueue() {
		lastNode = null;
	}

	public void addPerson(Person p) {
		Node newNode = new Node();
		newNode.person = p;
		if (lastNode == null) {
			newNode.next = newNode;
			lastNode = newNode;
		} else {
			newNode.next = lastNode.next;
			lastNode.next = newNode;
		}
	}

	public void print() {
		if (lastNode != null) {
			Node temp = lastNode;
			while (temp.next != lastNode) {
				System.out.println(temp.person);
				temp = temp.next;
			}
		}
	}

	public void randomStart() {

	}

	public Person remove(int count) {
		Person result = null;
		if (lastNode != null) {
			Node temp = lastNode;
			int counter = count - 1;
			while (counter > 0) {
				temp = temp.next;
				counter--;
			}
			Node nodeToBeRemoved = temp.next;
			temp.next = nodeToBeRemoved.next;
			nodeToBeRemoved.next = null;
			result = temp.person;
			
			//virker ikke til at fjerne det sidste element....
		}
		return result;
	}

	private class Node {
		private Person person;
		private Node next;
	}

}
