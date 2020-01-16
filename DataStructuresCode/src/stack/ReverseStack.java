package stack;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		ReverseStack rs = new ReverseStack();
		rs.reverseStack(stk);
		while(!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}

	private void reverseStack(Stack<Integer> stk) {
		if(stk.isEmpty()) {
			return;
		}
		Integer val = stk.pop();
		reverseStack(stk);
		recursivePush(stk, val);
	}

	private void recursivePush(Stack<Integer> stk, Integer val) {
		if(stk.isEmpty()) {
			stk.push(val);
		}else {
			Integer cur = stk.pop();
			recursivePush(stk, val);
			stk.push(cur);
		}
	}
}
