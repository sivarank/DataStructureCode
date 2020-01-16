package graph;

public class FloydWarshallAllPairsShortestPath {
    private static final int INF = 1000000;
	public static void main(String[] args) {
        int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };
        
        FloydWarshallAllPairsShortestPath allDistances = new FloydWarshallAllPairsShortestPath();
        allDistances.findDistances(graph);
	}
	
	private void findDistances(int[][] graph) {
		//TODO: create new distance matrix
		int n = graph.length;
		for(int k=0; k<n; k++) {
			for(int i =0; i<n; i++) {
				for(int j=0; j< n; j++) {
					if(graph[i][j] > graph[i][k]+graph[k][j]) {
						graph[i][j] = graph[i][k]+graph[k][j];
					}
				}
			}
		}
		
        for(int i=0; i < graph.length; i++){
            for(int j=0; j < graph.length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
	}

}
