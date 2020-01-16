package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;



public class TopologicalSort<T> {

	private void topologicalSort(Graph g) {
		Collection<Vertex<T>> col = g.getAllVertex();
		Stack<Vertex<T>> stk = new Stack<Vertex<T>>();
        Set<Vertex<T>> visited = new HashSet<>();
		for(Vertex<T> v : col) {
			if(!visited.contains(v)) {
				DFS(v, g, visited, stk);
			}
		}
		
		while(!stk.isEmpty()) {
			Vertex<T> v = stk.pop();
			System.out.println(v.getId());
		}
	}
	private void DFS(Vertex<T> v, Graph g, Set<graph.Vertex<T>> visited, Stack<Vertex<T>> stk) {
		if(!visited.contains(v)) {
			visited.add(v);
			for(Vertex<T> v1 :v.getAdjacentVertexes()) {
				DFS(v1, g,visited, stk);
			}
			stk.push(v);
		}
	}

	public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        TopologicalSort sort = new TopologicalSort<Integer>();
        
        sort.topologicalSort(graph);
	}

}
