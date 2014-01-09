package Opg1_DFS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFSIterator<E1, E2> {
	private Graph<E1, E2> graph;
	private Set<Vertex<E1>> visited;

	private void dfsVisit(Vertex<E1> v) {
		visited.add(v);
		Iterator<Vertex<E1>> it = graph.adjacentVertices(v);
		while(it.hasNext()){
			Vertex<E1> current = it.next();
			if(!visited.contains(current)){
				dfsVisit(current);
			}
		}
	}

	public Iterator<Vertex<E1>> iteratorDFS(Graph<E1, E2> g, Vertex<E1> start) {
		graph = g;
		visited = new HashSet<Vertex<E1>>();
		dfsVisit(start);
		return visited.iterator();
	}

}
