package Opg2_sam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFSIterator<E1, E2> {
	private Graph<E1, E2> graph;
	private Set<Vertex<E1>> visited;

	private void dfsVisit(Vertex<E1> v) {
		visited.add(v);
		Iterator<Vertex<E1>> it = graph.adjacentVertices(v);
		while (it.hasNext()) {
			Vertex<E1> current = it.next();
			if (!visited.contains(current)) {
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

	public boolean isCoherent(Graph<E1, E2> g) {
		graph = g;
		visited = new HashSet<Vertex<E1>>();
		Iterator<Vertex<E1>> it = g.vertices();
		if (it.hasNext()) {
			Vertex<E1> start = it.next();
			dfsVisit(start);
		}
		return g.numVertices() == visited.size();
	}

	public boolean isVertexsConnectedWithEdges(Graph<E1, E2> g, Vertex<E1> v, Vertex<E1> w) {
		graph = g;
		visited = new HashSet<Vertex<E1>>();
		dfsVisit(v);
		return visited.contains(w);
	}
	
	private boolean isVertexNeighbors(Vertex<E1> v, Vertex<E1> w){
		boolean found = false;
		visited.add(v);
		Iterator<Vertex<E1>> it = graph.adjacentVertices(w);
		while(it.hasNext() && !found){
			Vertex<E1> current = it.next();
			if(current.equals(w)){
				found = true;
			} else if (!visited.contains(current)){
				isVertexNeighbors(current, w);
			}
			
		}
		
		return found;
		
	}

}
