package string;

/**
 * Date 09/22/2014
 * @author tusroy
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class KMPSubstringSearch {


	private boolean KMP(char[] input, char[] pattern) {
		int pa[] = computeArray(pattern);
		int i =0;
		int j=0;
		while(i < input.length && j<pattern.length) {
			if( input[i] == pattern[j]) {
				i++;
				j++;
			}else {
				if(j>0) {
					j = pa[j-1];					
				}else {
					i++;
				}
			}
		}
		return j == pattern.length;
	}
	
	/**
	 * search pattern's matching array 
	 * @param args
	 */
	
	int[] computeArray(char[] pattern) {
		// add validations
		
		int[] pa = new int[pattern.length];
		int j = 0;
		int i=1;
		while(i<pattern.length) {
			if(pattern[i] == pattern[j]) {
				pa[i] = j+1;
				i++;
				j++;
			}else {
				if(j == 0) {
					pa[i] = 0;
					i++;
				}else {
					j = pa[j-1];
				}
			}
		}
		return pa;
	}
	
    public static void main(String args[]){
        
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMPSubstringSearch ss = new KMPSubstringSearch();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
        
    }

}

