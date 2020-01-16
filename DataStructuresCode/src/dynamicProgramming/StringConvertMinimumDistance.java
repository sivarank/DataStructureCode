package dynamicProgramming;

public class StringConvertMinimumDistance {

	public static void main(String[] args) {
        String str1 = "azced";
        String str2 = "abcdef";
        StringConvertMinimumDistance editDistance = new StringConvertMinimumDistance();
        int result = editDistance.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);

	}
	
	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	private int dynamicEditDistance(char[] str1, char[] str2) {
		int[][] mem = new int[str1.length+1][str2.length+1];
		// fill row
		for(int i=0; i<= str2.length ; i++) {
			mem[0][i] = i;
		}
		for(int j=1; j<= str1.length; j++ ) {
			mem[j][0] = j;
		}
		
		for(int i  = 1; i<=str1.length ; i++) {
			for(int j=1; j<=str2.length; j++) {
				if(str1[i-1] == str2[j-1]) {
					mem[i][j] = mem[i-1][j-1];
				}else {
					mem[i][j] = 1 + min(mem[i-1][j-1], mem[i-1][j], mem[i][j-1]); 
				}
			}
		}
		// print actual edits
		printEdits(mem, str1, str2);
		return mem[str1.length][str2.length];
	}

	private void printEdits(int[][] mem, char[] str1, char[] str2) {
		int row = mem.length -1 ;
		int col = mem[0].length -1;
		while(row >0 && col>0 && mem[row][col] >0) {
			if(str1[row-1] == str2[col-1]) {
				row--;
				col--;
			}else {
				int minValue = min(mem[row-1][col-1], mem[row-1][col], mem[row][col-1]);
				// check character added 
				if(minValue == mem[row-1][col]) {
					System.out.println(str1[row-1] + ":removed, pos:"+(row-1));
					row--;
				}else if(minValue == mem[row][col-1]) {
					System.out.println(str2[col-1] + ":added, pos:"+(row));
					col--;
				}else {
					System.out.println(str1[row-1] + ":replaced, pos:"+(row-1));
					row--;
					col--;
				}
			}
		}
	}
}
