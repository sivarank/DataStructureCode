package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReveseSentence {

	public static void main(String[] args) {
		String str = "SIVA IS A GOOD PERSON";
		
		String tokens[] = str.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i =tokens.length-1; i>=0 ; i--) {
			sb.append(tokens[i] + " ");
		}

		System.out.println(sb.toString());
		List<String> asList = Arrays.asList(tokens);
		Collections.reverse(asList);
		System.out.println(asList.toString());
	}
}
