package Opg3_BFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFSIterator<E1, E2> {

	private Graph<E1, E2> graph;
	private List<Vertex<E1>> visited;

	private void bfsVisit(Vertex<E1> v) {
		LinkedList<Vertex<E1>> queue = new LinkedList<Vertex<E1>>();
		queue.add(v);
		while (!queue.isEmpty()) {
			Vertex<E1> w = queue.removeFirst();
			visited.add(w);
			Iterator<Vertex<E1>> it = graph.adjacentVertices(w);
			while (it.hasNext()) {
				Vertex<E1> u = it.next();
				if (!visited.contains(u) && !queue.contains(u)) {
					queue.addLast(u);
				}
			}
		}

	}

	public Iterator<Vertex<E1>> iteratorBFS(Graph<E1, E2> g, Vertex<E1> start) {
		graph = g;
		visited = new ArrayList<Vertex<E1>>();
		bfsVisit(start);
		return visited.iterator();

	}

}
