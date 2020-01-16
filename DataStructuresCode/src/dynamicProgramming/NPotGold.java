package dynamicProgramming;

public class NPotGold {

	public static void main(String[] args) {
        int pots[] = {3,1,5,6,2,9,3};
        int n = pots.length;
        int[][][] mem = new int[n][n][2];
        
        // initialize 
        for(int i=0; i< n; i++) {
        	mem[i][i][0] = pots[i];// first player
        	mem[i][i][1] = 0; // second player
        }
        for(int d =1; d<n; d++) {
        	for(int i =0; i+d < n ; i++) {
        		// choose left 
        		mem[i][i+d][0] = pots[i] + mem[i+1][i+d][1];
        		mem[i][i+d][1] = mem[i+1][i+d][0];
        		// choose right
        		if(mem[i][i+d][0] < pots[i+d] + mem[i][i+d-1][1]) {
            		mem[i][i+d][0] = pots[i+d] + mem[i][i+d-1][1];
            		mem[i][i+d][1] = mem[i][i+d-1][0];
        		}
        	}
        }
        int i = 0, j = n-1;
        int val = mem[0][n-1][0];
        while(i<=j) {
        	if(mem[i][j][0] == mem[i][j-1][1]+pots[j]) {
        		System.out.println(pots[j]);
        		j--;
        	}else {
        		System.out.println(pots[i]);
        		i++;
        	}
        }
        System.out.println(mem[0][n-1][0]+" : "+ mem[0][n-1][1]);
	}

}
