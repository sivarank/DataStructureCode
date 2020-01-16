package string;

import java.util.regex.Pattern;

public class KIDStringMatch {

	public static void main(String[] args) {
		String kid = "7823666a";
		System.out.println(Pattern.matches("[1-9a-f]+ {10,20}", kid));
		System.out.println(Pattern.matches("([1-9a-f]{8,32})", kid));
	}

}
