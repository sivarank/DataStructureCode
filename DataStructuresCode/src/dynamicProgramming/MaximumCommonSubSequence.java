package dynamicProgramming;

public class MaximumCommonSubSequence {
	public static void main(String[] args) {
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        int result = new MaximumCommonSubSequence().lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
	}

	private int lcsDynamic(char[] str1, char[] str2) {
		if(str1.length == 0 || str2.length == 0) {
			return 0;
		}
		
		int m = str1.length;
		int n = str2.length;
		int[][] mem = new int[m+1][n+1];
		for(int i=1; i<= m ; i++) {
			for(int j=1; j<=n ; j++) {
				if(str1[i-1] == str2[j-1]) {
					mem[i][j] = 1 + mem[i-1][j-1];
				}else {
					mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
				}
			}
		}
		return mem[m][n];
	}
}
