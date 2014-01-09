package Opg1_Kruskal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Kruskal<E1> {

	private Graph<E1, Integer> graph;
	private PriQueueI<Edge<Integer>> queue;

	public Kruskal(Graph<E1, Integer> graph) {
		this.graph = graph;
	}

	public Iterator<Edge<Integer>> kruskalVisit() {
		makeQueue();
		List<Set<Vertex<E1>>> C = populateListSet();
		
		List<Edge<Integer>> t = new ArrayList<>();
		while (t.size() < graph.numVertices() - 1) {
			Edge<Integer> e = queue.removeMin();
			Vertex<E1> u = graph.endVertices(e).get(0);
			Vertex<E1> v = graph.endVertices(e).get(1);
			int i = findSet(C, u);
			int j = findSet(C, v);
			if (i != j) {
				t.add(e);
				C.get(i).addAll(C.get(j));
				C.remove(j);
			}
		}
		return t.iterator();

	}

	private int findSet(List<Set<Vertex<E1>>> c, Vertex<E1> u) {
		boolean found = false;
		int i = 0;
		while (!found) {
			if (c.get(i).contains(u)) {
				found = true;
			} else {
				i++;
			}
		}
		return i;
	}

	private List<Set<Vertex<E1>>> populateListSet() {
		List<Set<Vertex<E1>>> result = new ArrayList<Set<Vertex<E1>>>();
		Iterator<Vertex<E1>> it = graph.vertices();
		while (it.hasNext()) {
			Set<Vertex<E1>> tempSet = new HashSet<>();
			Vertex<E1> current = it.next();
			tempSet.add(current);
			result.add(tempSet);
		}
		return result;
	}

	private void makeQueue() {
		Iterator<Edge<Integer>> it = graph.edges();
		queue = new PriQueue<Edge<Integer>>();
		while (it.hasNext()) {
			Edge<Integer> e = it.next();
			queue.insert(e.element(), e);
		}
	}

}
