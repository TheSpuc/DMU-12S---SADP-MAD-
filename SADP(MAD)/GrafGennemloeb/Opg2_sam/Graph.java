package Opg2_sam;

import java.util.Iterator;
import java.util.List;

/**
 * Abstrakt datatype: Graph
 */
public interface Graph<E1, E2> {
	/**
	 * Returnerer en iterator med knuderne, der er nabo til v.
	 * 
	 * @return en iterator med knuderne, der er nabo til v.
	 * @param v
	 *            knuden for hvilken man oensker nabo knuder
	 */
	public Iterator<Vertex<E1>> adjacentVertices(Vertex<E1> v);

	/**
	 * Returnerer en boolean, som angiver om knuderne v og w er naboer.
	 * 
	 * @return om v og w er naboer
	 * @param v
	 *            knude som skal checkes for at have w som nabo
	 * @param w
	 *            knude som skal checkes for at have v som nabo
	 */
	public boolean areAdjacent(Vertex<E1> v, Vertex<E1> w);

	/**
	 * Returnerer graden af knuden v.
	 * 
	 * @return graden af knuden v
	 * @param v
	 *            knuden man oensker graden af
	 */
	public int degree(Vertex<E1> v);

	/**
	 * Returnerer en iterator med kanterne i grafen.
	 * 
	 * @return en iterator med kanterne i grafen
	 */
	public Iterator<Edge<E2>> edges();

	/**
	 * Returnerer en List med de to knuder der er e's endepunkter.
	 * 
	 * @return et array med de to knuder der er e's endepunkter.
	 * @param e
	 *            kanten man oensker endepunkterne af
	 */
	public List<Vertex<E1>> endVertices(Edge<E2> e);

	/**
	 * Returnerer en iterator med kanterne, der st�der op til v.
	 * 
	 * @return en iterator med kanterne, der st�der op til v.
	 * @param v
	 *            knuden man oensker de tilst�dende kanter for
	 */
	public Iterator<Edge<E2>> incidentEdges(Vertex<E1> v);

	/**
	 * Inds�tter og returnerer en ny kant mellem knuderne v og w.
	 * 
	 * @return den nye kant
	 * @param v
	 *            kantens ene endepunkt
	 * @param w
	 *            kantens andet endepunkt
	 * @param o
	 *            objektet som kanten skal indeholde
	 */
	public Edge<E2> insertEdge(Vertex<E1> v, Vertex<E1> w, E2 o);

	/**
	 * Inds�tter og returnerer en ny (enkeltst�ende) knude indeholdende objektet
	 * o.
	 * 
	 * @return den nye knude
	 * @param o
	 *            objektet som knuden skal indeholde
	 */
	public Vertex<E1> insertVertex(E1 o);

	/**
	 * Returnerer antallet af kanter i grafen
	 * 
	 * @return antallet af kanter i grafen
	 */
	public int numEdges();

	/**
	 * Returnerer antallet af knuder i grafen,
	 * 
	 * @return antallet af knuder i grafen
	 */
	public int numVertices();

	/**
	 * Returnerer e's endepunkt som er forskellig fra v.
	 * 
	 * @return e's endepunkt som er forskellig fra v.
	 * @param v
	 *            knuden i den ene ende af e
	 * @param e
	 *            kanten hvor man oensker den det modsatte endepunkt af v
	 */
	public Vertex<E1> opposite(Vertex<E1> v, Edge<E2> e);

	/**
	 * Fjerner kanten e
	 * 
	 * @param e
	 *            kanten som skal fjernes
	 */
	public void removeEdge(Edge<E2> e);

	/**
	 * Fjerner knuden v og alle dens tilst�dende kanter.
	 * 
	 * @param v
	 *            knuden som skal fjernes
	 */
	public void removeVertex(Vertex<E1> v);

	/**
	 * Returnerer en iterator med knuderne i grafen
	 * 
	 * @return en iterator med knuderne i grafen
	 */
	public Iterator<Vertex<E1>> vertices();
}
