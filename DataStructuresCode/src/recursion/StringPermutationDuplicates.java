package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class StringPermutationDuplicates {
	private List<String> permute(char[] charArray) {

		// count characters using treemap
		
		TreeMap<Character, Integer> countMap = new TreeMap<>();
		for(char ch : charArray) {
			countMap.compute(ch, (key, val) -> {
				return val == null ? 1 : val +1; 
			});
		}
		//create two arrays, literal and count arrays
		
		char[] str = new char[countMap.size()];
		int[] count = new int[countMap.size()];
	
		int index =0;
		for(char ch : countMap.keySet()) {
			str[index] = ch;
			count[index] = countMap.get(ch);
			index++;
		}
		
		char[] resultString = new char[charArray.length];
		List<String> result = new ArrayList<String>();
		// call recursion 
		return calculatePermutations(str, count, result, 0, resultString);
	}
	
	
	
	private List<String> calculatePermutations(char[] str, int[] count, List<String> result, int level, char[] resultString) {
		if(level == resultString.length) {
			result.add(new String(resultString));
		}else {
			for(int i = 0; i < count.length; i++) {
				if(count[i] == 0) {
					continue;
				}
				count[i] = count[i] -1;
				resultString[level] = str[i];
				calculatePermutations(str, count, result, level+1, resultString);
				count[i] = count[i] +1;
			}
		}
		return result;
	}



	public static void main(String[] args) {
		StringPermutationDuplicates sp = new StringPermutationDuplicates();
        //sp.permute("AAAABCB".toCharArray()).forEach(s -> System.out.println(s));
		sp.permute("AAAABCB".toCharArray()).forEach(System.out::println);
	}
}
