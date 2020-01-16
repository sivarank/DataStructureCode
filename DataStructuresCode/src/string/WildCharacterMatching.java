package string;

public class WildCharacterMatching {


	private boolean isMatch(String inputString, String pattern) {

		
		char[] str1 = inputString.toCharArray();
		char[] str2 = pattern.toCharArray();
		//TODO trim adjacent '*' characters
		
		boolean[][] TC = new boolean[str1.length+1][str2.length+1];
		
		TC[0][0] = true;
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str2.length; j++) {
				if(str1[i] == str2[j] || str2[j] == '?') {
					TC[i+1][j+1] = true;
				}else if(str2[j] == '*') {
					TC[i+1][j+1] = TC[i][j+1] || TC[i+1][j]; 
				}
			}
		}
		return TC[str1.length][str2.length];
		//System.out.println();
	}
	
    public static void main(String args[]) {
    	WildCharacterMatching wcm = new WildCharacterMatching();
        System.out.println(wcm.isMatch("xbylmz", "x?y*z"));
        System.out.println(wcm.isMatch("xbylmz", "x?y*Z"));
    }


}
