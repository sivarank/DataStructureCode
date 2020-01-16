package dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
	private boolean breakWord(Set<String> dictionary, String str) {
		if(str.length() == 0) {
			return false;
		}
		int n = str.length();
		
		int[][] mem = new int[n][n];
		// initialize mem
		for(int i =0; i<n ; i++) {
			if(dictionary.contains(str.substring(i, i+1))){
				mem[i][i] = i;
			}else {
				mem[i][i] = -1;
			}
		}
		
		for(int d =1; d<n; d++) {
			for(int i=0; i+d<n; i++) {
				mem[i][i+d] = -1;
				String wholeString = str.substring(i, i+d+1);
				if(dictionary.contains(wholeString)) {
					mem[i][i+d]= i;
					continue;
				}
				for(int k=i+1; k<=i+d; k++) {
					// split at kth location
					if(mem[i][k-1] != -1 && mem[k][i+d] != -1) {
						mem[i][i+d]= k;
						break;
					}
				}
			}
		}
		
		printWords(mem, str, 0, n-1);
		return mem[0][n-1] != -1;
	}
	private void printWords(int[][] mem, String str, int start, int end) {
		if(mem[start][end] == -1) {
			return;
		}
		if(mem[start][end] == start) {
			System.out.println(str.substring(start, end+1));
		}else {
			printWords(mem, str, start, mem[start][end]-1);
			printWords(mem, str, mem[start][end], end);
		}
	}
	
	public static void main(String[] args) {
		WordBreakProblem wb = new WordBreakProblem();
        Set<String> dictionary = new HashSet<String>();
//        dictionary.add("I");
//        dictionary.add("like");
//        dictionary.add("had");
//        dictionary.add("play");
//        dictionary.add("to");
//        String str = "Ihadliketoplay";
        String str ="Iamace";
        dictionary.add("I");
        dictionary.add("am");
        dictionary.add("ace");
		
		System.out.println(wb.breakWord(dictionary, str));
	}

}
