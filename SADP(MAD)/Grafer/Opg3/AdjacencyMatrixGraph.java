/**
 *
 */
package Opg3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdjacencyMatrixGraph<E1, E2> implements Graph<E1, E2> {
	private ArrayList<Vertex<E1>> vertices; // knuderne i grafen
	private ArrayList<Edge<E2>> edges; // kanterne i grafen
	private AMEdge[][] matrix;

	/**
	 * Indre klasse, der implementerer knuden i en EdgeListGraph.
	 */
	private class AMVertex implements Vertex<E1> {
		private E1 element; // elementet indeholdt i knuden
		private int number;
		private int numberOfEdges;

		/**
		 * Opretter en knude indeholdende objektet e.
		 * 
		 * @param e
		 *            objektet som knuden skal indeholde
		 */
		public AMVertex(E1 e) {
			element = e;
			numberOfEdges = 0;
		}

		/**
		 * Returnerer objektet, som er indeholdt i knuden.
		 * 
		 * @return objektet i knuden
		 */
		public E1 element() {
			return element;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		/**
		 * Returnerer antal tilst�dende kanter til knuden.
		 * 
		 * @return antal tilst�dende kanter
		 */
		public int getNumIncidentEdges() {
			return numberOfEdges;
		}

		/**
		 * Opjusterer antal tilst�dende kanter til knuden med 1.
		 */
		public void incNumIncidentEdges(AMEdge ale) {
			numberOfEdges++;
		}

		/**
		 * Nedjusterer antal tilst�dende kanter til knuden med 1.
		 */
		public void decNumIncidentEdges() {
			numberOfEdges--;
		}

	}

	/**
	 * Indre klasse, der implementerer kanten i en EdgeListGraph.
	 */
	private class AMEdge implements Edge<E2> {
		private E2 element; // elementet indeholdt i kanten
		private Vertex<E1> endPoint1; // knuden i kantens ene ende
		private Vertex<E1> endPoint2; // knuden i kantens anden ende

		/**
		 * Opretter en kant mellem knuderne e1 og e2 indeholdende objektet e.
		 * 
		 * @param e
		 *            objektet som kanten skal indeholde
		 * @param e1
		 *            kantens ene endepunkt
		 * @param e2
		 *            kantens andet endepunkt
		 */
		public AMEdge(E2 e, Vertex<E1> v1, Vertex<E1> v2) {
			element = e;
			endPoint1 = v1;
			endPoint2 = v2;
		}

		/**
		 * Returnerer objektet, som er indeholdt i kanten.
		 * 
		 * @return objektet i kanten
		 */
		public E2 element() {
			return element;
		}

		/**
		 * Returnerer en List indeholdende de to knuder, som er endepunkter for
		 * kanten.
		 * 
		 * @return knuderne h�rende til kanten
		 */
		public List<Vertex<E1>> endPoints() {
			// Vertex<E1>[] ep = (Vertex<E1>[]) new Object[2];
			List<Vertex<E1>> ep = new ArrayList<Vertex<E1>>(2);
			ep.add(endPoint1);
			ep.add(endPoint2);
			return ep;
		}
	}

	/**
	 * Opretter en EdgeListGraph. Tid: O(1)
	 */
	public AdjacencyMatrixGraph() {
		edges = new ArrayList<Edge<E2>>();
		vertices = new ArrayList<Vertex<E1>>();
		matrix = (AMEdge[][]) new Object[1][1];
	}

	/**
	 * Returnerer en iterator med knuderne, der er nabo til v. Tid: O(antal
	 * kanter)
	 * 
	 * @return en iterator med knuderne der er nabo til v
	 * @param v
	 *            knuden for hvilken man �nsker en iterator over naboknuder
	 */
	public Iterator<Vertex<E1>> adjacentVertices(Vertex<E1> v) {
		ArrayList<Vertex<E1>> naboVertices = new ArrayList<Vertex<E1>>();
		int i = ((AMVertex) v).getNumber();
		for (int j = 0; j < matrix[i].length;) {
			AMEdge current = matrix[i][j];
			if (current != null) {
				if (current.endPoint1.equals(v)) {
					naboVertices.add(current.endPoint2);
				} else {
					naboVertices.add(current.endPoint2);
				}
			}
		}
		return naboVertices.iterator();
	}

	/**
	 * Returnerer en boolean, som angiver om knuderne v og w er naboer. Tid:
	 * O(antal kanter)
	 * 
	 * @return om v og w er naboer
	 * @param v
	 *            knude som skal checkes for at have w som nabo
	 * @param w
	 *            knude som skal checkes for at have v som nabo
	 */
	public boolean areAdjacent(Vertex<E1> v, Vertex<E1> w) {
		int i = ((AMVertex) v).getNumber();
		int j = ((AMVertex) w).getNumber();

		return matrix[i][j] != null;
	}

	/**
	 * Returnerer graden af knuden v. Tid: O(1)
	 * 
	 * @return graden af knuden v
	 * @param v
	 *            knuden man �nsker graden af
	 */
	public int degree(Vertex<E1> v) {
		return ((AMVertex) v).getNumIncidentEdges();
	}

	/**
	 * Returnerer en iterator med kanterne i grafen. Tid: O(antal kanter)
	 * 
	 * @return en iterator med kanterne i grafen
	 */
	public Iterator<Edge<E2>> edges() {
		return edges.iterator();
	}

	/**
	 * Returnerer et array med de to knuder der er e's endepunkter Tid: O(1)
	 * 
	 * @return et array med de to knuder der er e's endepunkter.
	 * @param e
	 *            kanten man �nsker endepunkterne af
	 */
	public List<Vertex<E1>> endVertices(Edge<E2> e) {
		return ((AMEdge) e).endPoints();
	}

	/**
	 * Inds�tter og returnerer en ny kant mellem knuderne v og w. Tid: O(1)
	 * 
	 * @param v
	 *            kantens ene endepunkt
	 * @param w
	 *            kantens andet endepunkt
	 * @param o
	 *            objektet som kanten skal indeholde
	 * @return den nye kant
	 */
	public Edge<E2> insertEdge(Vertex<E1> v, Vertex<E1> w, E2 o) {
		Edge<E2> e = new AMEdge(o, v, w);
		edges.add(e);
		int i = ((AMVertex) v).getNumber();
		int j = ((AMVertex) w).getNumber();
		matrix[i][j] = (AMEdge) e;

		return e;
	}

	/**
	 * Inds�tter og returnerer en ny knude indeholdende objektet o. Efter
	 * oprettelsen har knuden ingen tilst�dende kanter. Tid: O(1)
	 * 
	 * @param o
	 *            objektet som knuden skal indeholde
	 * @return den nye knude
	 */
	public Vertex<E1> insertVertex(E1 o) {
		Vertex<E1> v = new AMVertex(o);
		vertices.add(v);
		((AMVertex) v).setNumber(matrix.length);

		AMEdge[][] tempMatrix = (AMEdge[][]) new Object[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; i++) {
				tempMatrix[i][j] = matrix[i][j];
			}
		}
		matrix = tempMatrix;
		return v;
	}

	/**
	 * Returnerer antallet af kanter i grafen. Tid: O(1)
	 * 
	 * @return antallet af kanter i grafen
	 */
	public int numEdges() {
		return edges.size();
	}

	/**
	 * Returnerer antallet af knuder i grafen. Tid: O(1)
	 * 
	 * @return antallet af knuder i grafen
	 */
	public int numVertices() {
		return vertices.size();
	}

	/**
	 * Returnerer e's endepunkt som er forskellig fra v. Tid: O(1)
	 * 
	 * @param v
	 *            knuden i den ene ende af e
	 * @param e
	 *            kanten hvor man �nsker den det modsatte endepunkt af v
	 * @return e's endepunkt som er forskellig fra v
	 */
	public Vertex<E1> opposite(Vertex<E1> v, Edge<E2> e) {
		Vertex<E1> v1 = ((AMEdge) e).endPoints().get(0);
		Vertex<E1> v2 = ((AMEdge) e).endPoints().get(1);
		if (v == v1)
			return v2;
		else
			return v1;
	}

	/**
	 * Fjerner kanten e. Tid: O(1)
	 * 
	 * @param e
	 *            kanten som skal fjernes
	 */
	public void removeEdge(Edge<E2> e) {
		Vertex<E1> v1 = ((AMEdge) e).endPoints().get(0);
		Vertex<E1> v2 = ((AMEdge) e).endPoints().get(1);
		((AMVertex) v1).decNumIncidentEdges();
		((AMVertex) v2).decNumIncidentEdges();
		int i = ((AMVertex) v1).getNumber();
		int j = ((AMVertex) v2).getNumber();
		matrix[i][j] = null;
		edges.remove(e);
	}

	/**
	 * Fjerner knuden v og alle dens tilst�dende kanter Tid: O(antal kanter)
	 * 
	 * @param v
	 *            knuden som skal fjernes
	 */
	public void removeVertex(Vertex<E1> v) {
		// Iterator<Edge<E2>> i = edges.iterator();
		// while (i.hasNext()) {
		// AdjacencyListEdge e = (AdjacencyListEdge) i.next();
		// Vertex<E1> v1 = e.endPoints().get(0);
		// Vertex<E1> v2 = e.endPoints().get(1);
		// if (v1 == v || v2 == v) {
		// ((AdjacencyListVertex) v1).decNumIncidentEdges();
		// ((AdjacencyListVertex) v2).decNumIncidentEdges();
		// i.remove();
		// }
		// }
		// vertices.remove(v);
		// TODO
	}

	/**
	 * Returnerer en iterator med knuderne i grafen. Tid: O(antal knuder)
	 * 
	 * @return en iterator med knuderne i grafen
	 */
	public Iterator<Vertex<E1>> vertices() {
		return vertices.iterator();
	}

	/**
	 * Returnerer en iterator med kanterne, der st�der op til v. Tid: O(antal
	 * kanter)
	 * 
	 * @param v
	 *            knuden man �nsker de tilst�dende kanter for
	 * @return en iterator med kanterne, der st�der op til v
	 */
	public Iterator<Edge<E2>> incidentEdges(Vertex<E1> v) {
		ArrayList<Edge<E2>> ie = new ArrayList<Edge<E2>>();
		int i = ((AMVertex) v).getNumber();
		for (int j = 0; j < matrix[i].length; j++) {
			AMEdge current = matrix[i][j];
			if (current != null) {
				ie.add(current);
			}
		}
		return ie.iterator();
	}
}
