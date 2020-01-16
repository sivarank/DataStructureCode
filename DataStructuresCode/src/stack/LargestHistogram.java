package stack;

import java.util.Stack;

class StackEntry{
	int profit;
	int index;
	public StackEntry(int profit, int index) {
		this.profit = profit;
		this.index = index;
	}
}
public class LargestHistogram {

	public static void main(String[] args) {
		int[] h = new int[] {3,1,3,3,1,0};
		Stack<StackEntry> stk = new Stack<StackEntry>();
		//stk.push(new StackEntry(0, 0));
		int maxProfit = Integer.MIN_VALUE;
		for(int i=1; i<h.length; i++) {
			// stack top entry is less than h[i]  
			if(stk.isEmpty() || stk.peek().profit <= h[i]) {
				// simply add entry
				stk.push(new StackEntry(h[i], i));
			}else {
				int newindex = 0;
				while(!stk.isEmpty() && stk.peek().profit>h[i]) {
					StackEntry entry = stk.pop();
					if(stk.isEmpty()) {
						maxProfit = Math.max(maxProfit, (i)*(entry.profit));
					}else {
						maxProfit = Math.max(maxProfit, (i-entry.index)*(entry.profit));				
					}
//					newindex = entry.index;
				}
				stk.push(new StackEntry(h[i], i));
			}
		}
		System.out.println(maxProfit);
	}

}
