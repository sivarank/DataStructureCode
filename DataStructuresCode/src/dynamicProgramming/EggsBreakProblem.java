package dynamicProgramming;

public class EggsBreakProblem {

	public static void main(String[] args) {
		EggsBreakProblem eb = new EggsBreakProblem();
		System.out.println(eb.minimumAttempts(10, 100));
		System.out.println(eb.minimumAttempts(15,200));
		System.out.println(eb.minimumAttempts(3,100));
		System.out.println(eb.minimumAttempts(2, 5));
	}

	private int minimumAttempts(int m, int n) {
		int[][] mem = new int[m+1][n+1];
		
		// intialize the table. one floor needs minimum 1 egg.
		for(int i=1; i<=m; i++) {
			mem[i][1] = 1;
			mem[i][2] = 2;
		}
		// when there is only one egg. n attempts
		for(int j=3; j<=n; j++) {
			mem[1][j] = j;
		}
		
		for(int i=2; i<=m; i++) { //egg loop
			for(int j= 3; j<=n; j++) { // floor loop
				int min = Integer.MAX_VALUE;
				for(int k=1; k<=j; k++) {
					int value = 1+ Math.max(mem[i-1][k-1], mem[i][j-k]);
					min = Math.min(value, min);
				}
				mem[i][j] = min;
			}
		}
		return mem[m][n];
	}

}
