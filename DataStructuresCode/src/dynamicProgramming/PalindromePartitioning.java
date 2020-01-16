package dynamicProgramming;

public class PalindromePartitioning {

	public static void main(String[] args) {
		String str = "abcbm";
		PalindromePartitioning partition = new PalindromePartitioning();
		System.out.println(partition.minimumCut(str));
	}

	private int minimumCut(String str) {
		int n= str.length();
		
		int[][] mem = new int[n][n];
		// intialize the array
		for(int i=0; i<n; i++) {
			mem[i][i] = 0;
		}
		
		for(int l =1; l <n; l++) {
			for(int i=0; i+l<n; i++) {
				if(isPalindrome(str.substring(i, i+l+1))) {
					mem[i][i+l] = 0;
					continue;
				}
				int min = Integer.MAX_VALUE;
				for(int k=i; k< i+l; k++) {
					min = Math.min(min, mem[i][k]+mem[k+1][i+l]+1);
				}
				mem[i][i+l] = min;
			}
		}
		return mem[0][n-1];
	}

	private boolean isPalindrome(String substring) {
		StringBuilder  stb = new StringBuilder(substring);
		return stb.reverse().toString().equals(substring)  ;
	}

}
