package Opg2;

public class TestApp {

	public static void main(String[] args) {
		Graph<Integer, Integer> graph = new AdjacencyListGraph<>();
		Vertex<Integer> a = graph.insertVertex(15);
		Vertex<Integer> b = graph.insertVertex(6);
		Vertex<Integer> c = graph.insertVertex(66);
		Vertex<Integer> d = graph.insertVertex(38);
		Vertex<Integer> e = graph.insertVertex(123);
		Edge<Integer> ab = graph.insertEdge(a, b, 23);
		graph.insertEdge(a, d, 10);
		graph.insertEdge(a, c, 90);
		graph.insertEdge(b, c, 8);
		graph.insertEdge(b, e, 7);
		graph.insertEdge(c, e, 76);
		graph.insertEdge(c, d, 2);
		graph.insertEdge(d, e, 55);

		System.out.println(graph.areAdjacent(a, b));
		System.out.println(graph.areAdjacent(a, e));
		System.out.println(graph.degree(b));
		System.out.println(graph.degree(e));
		System.out.println(graph.numEdges());
		System.out.println(graph.numVertices());
		System.out.println(graph.toString());
		System.out.println(graph.opposite(a, ab).element());

	}

}
