package stack;

import java.util.HashMap;
import java.util.Stack;
public class PostfixConversion {

	public static void main(String[] args) {
		HashMap<Character, Integer> precedence = new HashMap<Character, Integer>();
		Stack<Character> stk = new Stack<Character>();
		String infix = "A*B-(C+D)+E";
		StringBuilder builder = new StringBuilder();
		
		// set precedence
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('%', 2);
		
		for(int i=0; i<infix.length(); i++){
			Character ch = infix.charAt(i);
			System.out.println(ch);
			if(Character.isAlphabetic(ch)){
				builder.append(ch);
			}else if(ch == ')'){
				// pop till '('
				while(stk.peek() != '('){
					builder.append(stk.pop());
				}
				stk.pop();
			}else{
				if(ch == '('){
					stk.push(ch);
				}else{
					while((!stk.isEmpty() && stk.peek() != '(') && (precedence.get(stk.peek()) >= precedence.get(ch))){
						Character val = stk.pop();
						builder.append(val);
					}
					stk.push(ch);
				}
			}
		}
		while(!stk.isEmpty()){
			builder.append(stk.pop());
		}
		System.out.println(builder.toString());
	}
}