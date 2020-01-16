package graph;

import java.util.HashMap;
import java.util.Map;

public class DijKstrawShortestPath {

	public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);
        
        DijKstrawShortestPath dsp = new DijKstrawShortestPath();
        dsp.findShortestPaths(graph);
	}

	private void findShortestPaths(Graph<Integer> graph) {
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
		Map<Vertex<Integer>,Integer> distance = new HashMap<>();
		Map<Vertex<Integer>,Vertex<Integer>> parent = new HashMap<>();
		
		graph.getAllVertex();
		// add all nodes to minHeap with infinity distance
		for(Vertex<Integer> v :graph.getAllVertex()) {
			minHeap.add(Integer.MAX_VALUE/2, v);
		}
		// source vertex 
		Vertex<Integer> source = graph.getVertex(1);
		minHeap.decrease(source, 0);
		
		// extract source from minHeap
		//BinaryMinHeap<Vertex<Integer>>.Node heapNode = minHeap.extractMinNode();
		
		distance.put(source, 0);
		parent.put(source, null);
		while(!minHeap.empty()) {
			BinaryMinHeap<Vertex<Integer>>.Node heapNode = minHeap.extractMinNode();
			distance.put(heapNode.key, heapNode.weight);
			
            //iterate through all edges of current vertex
            for(Edge<Integer> edge : heapNode.key.getEdges()){
                //get the adjacent vertex
                Vertex<Integer> adjacent = getVertexForEdge(heapNode.key, edge);
                if(minHeap.containsData(adjacent)) {
                	int newDistance = edge.getWeight() + heapNode.weight;
                	if(newDistance < minHeap.getWeight(adjacent)) {
                		minHeap.decrease(adjacent, newDistance);
                		parent.put(adjacent, heapNode.key);
                	}
                }
            }
		}
		
		for(Vertex<Integer> v : distance.keySet()) {
			System.out.println(v.getId()+" : "+distance.get(v));
		}
	}
    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }
}
