package dynamicProgramming;

import java.util.Arrays;

public class MinimumCoinChangeProblem {

	private int topDownRecursiveApproach(int[] coins, int total, int[] temp) {
		if(total == 0) {
			return 0;
		}
		if(temp[total] != Integer.MAX_VALUE/2) {
			return temp[total];
		}
		int result = Integer.MAX_VALUE/2;
		for(int i=0; i<coins.length; i++) {
			if(total >= coins[i]) {
				int val = 1 + topDownRecursiveApproach(coins, total-coins[i], temp);		
				result = Math.min(val, result);
			}
		}
		temp[total] = result;
		return temp[total];
	}
	
	private void bottomUpApproach(int[] coins, int total) {
		Arrays.sort(coins);
		int[] result = new int[total+1];
		int[] coinInfo = new int[total+1];
		for(int i=0; i<result.length; i++) {
			result[i] = Integer.MAX_VALUE -1;
		}
		result[0] = 0;
		
		for(int j=0; j < coins.length; j++) {
			for(int i=1; i<= total; i++) {
				if(i >= coins[j]) {
					if(result[i] > 1+ result[i - coins[j]]) {
						result[i] = 1+ result[i - coins[j]];
						coinInfo[i] = j;
					}
 				}
			}
		}
		System.out.println(result[total]);
		int j = total;
		while(j>0) {
			System.out.println(coins[coinInfo[j]]);
			j = j - coins[coinInfo[j]];
		}
	}
	public static void main(String[] args) {
        int total = 13;
        int coins[] = {7, 3, 2, 6};
        MinimumCoinChangeProblem cc = new MinimumCoinChangeProblem();
        cc.bottomUpApproach(coins, total);
        int[] temp = new int[total+1];
		for(int i=1; i<temp.length; i++) {
			temp[i] = Integer.MAX_VALUE/2;
		}
        System.out.println("top down :"+cc.topDownRecursiveApproach(coins, total, temp));
	}



}
