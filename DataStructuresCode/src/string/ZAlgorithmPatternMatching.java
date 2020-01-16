package string;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithmPatternMatching {

    private int[] constructZArray(char[] text, char[] pattern) {
    	char[] prefixComparisionText = new char[text.length + pattern.length+1];
    	
    	// copy pattern 
    	for(int i=0; i< pattern.length; i++) {
    		prefixComparisionText[i] = pattern[i]; 
    	}
    	// copy special character
    	
    	prefixComparisionText[pattern.length] = '$';
    	// copy text
    	for(int i= pattern.length + 1, j=0; i< text.length + pattern.length+1; i++,j++) {
    		prefixComparisionText[i] = text[j]; 
    	}
    	int[] Z = new int[text.length];
    	// calculate Z by matching prefix
    	for(int i = pattern.length + 1; i< text.length + pattern.length+1; i++) {
    		int j = 0;
    		int k = i;
    		while(k<text.length + pattern.length+1 &&  prefixComparisionText[j] == prefixComparisionText[k]) {
    			j++;
    			k++;
    		}
    		Z[i-pattern.length - 1] = Math.min(k-i,pattern.length);
    	}
    	return Z;
	}
    
	private List<Integer> matchPattern(char[] text, char[] pattern) {
		int[] Z = constructZArray(text, pattern);
		List<Integer> result = new ArrayList<Integer>();
		for(int i= 0; i< text.length; i++) {
			if(Z[i] == pattern.length) {
				result.add(i);
			}
		}
		return result;
	}

	



	public static void main(String args[]) {

        String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
        String pattern = "aaabc";
    	ZAlgorithmPatternMatching wcm = new ZAlgorithmPatternMatching();
        List<Integer> result = wcm.matchPattern(text.toCharArray(), pattern.toCharArray());
        result.forEach(System.out::println);
    }



}
