package dynamicProgramming;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		OptimalBinarySearchTree optimal = new OptimalBinarySearchTree();
        int input[] = {10,12,20,35};
        int freq[] = {4,2,6,3};
        System.out.println(optimal.minCost(input, freq));
       // System.out.println(ots.minCostRec(input, freq));
	}

	private int minCost(int[] input, int[] freq) {
		int n = input.length;
		int[][] mem = new int[n][n];
		
		// initialize table
		for(int  i=0 ; i<n; i++) {
			mem[i][i] = freq[i];
		}
		int[] sum = new int[n];
		
		sum[0] = freq[0];
		for(int i =1; i< n; i++) {
			sum[i] = sum[i-1] + freq[i]; 
		}
		// diagonal
		for(int d = 1; d < n; d++) {
			// Cell
			for(int i =0; i+d < n; i++) {
				// find minimum value by selecting different roots
				int minCost = Integer.MAX_VALUE/2;
				for(int j =i; j<= i+d; j++) {
					//int cost = mem[j][j]; // DO NOT COUNT ROOT VALUE
					int cost = 0;
					
					//check of left tree there
					if(j > i) {
						cost += mem[i][j-1]; 
					}
					if(j < i+d) {
						cost += mem[j+1][i+d];
					}
					minCost = Math.min(cost, minCost);
				}
				if(i-1 >= 0) {
					mem[i][i+d] = sum[i+d] - sum[i-1] +minCost;					
				}else {
					mem[i][i+d] = sum[i+d] +minCost;
				}

			}
		}
		return mem[0][n-1];
	}
}
