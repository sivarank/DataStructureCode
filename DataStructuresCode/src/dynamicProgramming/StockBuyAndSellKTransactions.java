package dynamicProgramming;


public class StockBuyAndSellKTransactions {

	public static void main(String[] args) {
		StockBuyAndSellKTransactions sbt = new StockBuyAndSellKTransactions();
        int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};

        System.out.println("Max profit fast solution " + sbt.maxProfit(prices, 3));
        //System.out.println("Max profit slow solution " + sbt.maxProfitSlowSolution(prices, 3));
	}

	private int maxProfit(int[] prices, int k) {
		
		int[][] mem = new int[k+1][prices.length];
		for(int i= 1; i<= k ; i++) {
			for(int j=1; j<prices.length; j++) {
				int maxValue = Integer.MIN_VALUE/2;
				for(int m =0; m<j; m++) {
					maxValue = Math.max(maxValue, prices[j] - prices[m] + mem[i-1][m]);
				}
				mem[i][j] = Math.max(maxValue, mem[i][j-1]);
			}
		}
		//System.out.println(mem[k][prices.length-1]);
		
		int i =k, j=prices.length-1;
		int maxValue = mem[i][j];
		while(i>=0 && j>= 1) {
			//did we get max from previous transactions
			if(mem[i][j] == mem[i][j-1]) {
				j--;
			}else {
				// find out m which gave max profit
				for(int m=j-1; m>=0; m--) {
					if(prices[j] - prices[m] + mem[i-1][m] == mem[i][j]) {
						System.out.println("bought on "+m+" , sold on "+j);
						i--;
						j = m;
						break;
					}
				}
			}

		}
		return mem[k][prices.length-1];
	}

}
