package Opg3_BFS;

import java.util.Iterator;

public class TestApp {

	public static void main(String[] args) {
		Graph<Integer, Integer> graph = new EdgeListGraph<>();
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
//		Vertex<Integer> w = graph.insertVertex(-1);

		System.out.println(graph.areAdjacent(a, b));
		System.out.println(graph.areAdjacent(a, e));
		System.out.println(graph.degree(b));
		System.out.println(graph.degree(e));
		System.out.println(graph.numEdges());
		System.out.println(graph.numVertices());
		System.out.println(graph.toString());
		System.out.println(graph.opposite(a, ab).element());
		System.out.println(findMax(graph) + "\n\n");
		
		
		BFSIterator<Integer, Integer> bfs = new BFSIterator<Integer, Integer>();
		Iterator<Vertex<Integer>> it = bfs.iteratorBFS(graph, a);
		while(it.hasNext()){
			System.out.println(it.next().element());
		}

//		DFSIterator<Integer, Integer> dfs = new DFSIterator<Integer, Integer>();
//
//		Iterator<Vertex<Integer>> it = dfs.iteratorDFS(graph, a);
//
//		while (it.hasNext()) {
//			System.out.println(it.next().element());
//		}
//		System.out.println("Is graph coherent? " + dfs.isCoherent(graph));
//		System.out.println("Is graph coherent? " + dfs.isCoherent(new EdgeListGraph<Integer, Integer>()));
//
//		System.out.println("Is there one or more edges between a & b? "
//				+ dfs.isVertexsConnectedWithEdges(graph, a, b));
//
//		System.out.println("Is there one or more edges between a & w? "
//				+ dfs.isVertexsConnectedWithEdges(graph, a, w));
//		System.out.println("Is there one or more edges between w & a? "
//				+ dfs.isVertexsConnectedWithEdges(graph, w, a));

	}

	public static Integer findMax(Graph<Integer, Integer> graph) {
		Iterator<Vertex<Integer>> it = graph.vertices();
		Integer result = -1;
		while (it.hasNext()) {
			Vertex<Integer> current = it.next();
			if (current.element() > result) {
				result = current.element();
			}
		}

		return result;

	}

}
