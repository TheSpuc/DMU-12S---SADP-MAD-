package Opg1_Kruskal;

import java.util.Iterator;

public class TestApp {

	public static void main(String[] args) {
		Graph<Integer, Integer> graph = new EdgeListGraph<>();
		Vertex<Integer> v15 = graph.insertVertex(15);
		Vertex<Integer> v6 = graph.insertVertex(6);
		Vertex<Integer> v66 = graph.insertVertex(66);
		Vertex<Integer> v38 = graph.insertVertex(38);
		Vertex<Integer> v123 = graph.insertVertex(123);

		Edge<Integer> e10 = graph.insertEdge(v15, v38, 10);
		Edge<Integer> e23 = graph.insertEdge(v15, v6, 23);
		Edge<Integer> e90 = graph.insertEdge(v15, v66, 90);

		Edge<Integer> e55 = graph.insertEdge(v38, v123, 55);
		Edge<Integer> e2 = graph.insertEdge(v38, v66, 2);

		Edge<Integer> e7 = graph.insertEdge(v6, v123, 60);
		Edge<Integer> e8 = graph.insertEdge(v6, v66, 8);

		Edge<Integer> e76 = graph.insertEdge(v123, v66, 76);

		Kruskal<Integer> kruskal = new Kruskal<>(graph);
		Iterator<Edge<Integer>> temp = kruskal.kruskalVisit();
		while (temp.hasNext()) {
			System.out.print(temp.next().element() + " ");
		}
		System.out.println();
	}

}
