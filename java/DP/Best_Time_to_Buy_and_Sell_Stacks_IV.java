package DP;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Notice
 * 
 * You may not engage in multiple transactions at the same time (i.e., you must
 * sell the stock before you buy again).
 * 
 * 
 * Example Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
 * 
 * Challenge O(nk) time.
 */
public class Best_Time_to_Buy_and_Sell_Stacks_IV {
	public static int maxProfit(int k, int[] prices) {

		if (prices == null || prices.length <= 1 || k == 0) {
			return 0;
		}
		// / 不然超时
		if (k >= prices.length / 2) {
			int profit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) {
					profit += prices[i] - prices[i - 1];
				}
			}
			return profit;
		}

		int len = prices.length;
		int[][] local = new int[k][len];
		int[][] global = new int[k][len];
		local[0][0] = 0;
		global[0][0] = 0;

		//
		int min = prices[0];
		for (int i = 1; i < len; i++) {
			local[0][i] = prices[i] - min;
			min = Math.min(min, prices[i]);
			global[0][i] = Math.max(global[0][i - 1], local[0][i]);
		}
		for (int i = 1; i < k; i++) {
			for (int j = 1; j < len; j++) {
				local[i][j] = Math.max(global[i - 1][j - 1], local[i][j - 1])
						+ prices[j] - prices[j - 1];
				global[i][j] = Math.max(global[i][j - 1], local[i][j]);
				// local[i][j] = Math.max(local[i - 1][j], Math.max(global[i -
				// 1][j - 1],local[i][j - 1]) + prices[j] - prices[j - 1] );
				// global[i][j] = Math.max(global[i][j - 1], local[i][j]);
			}
		}
		return global[k - 1][len - 1];
	}

	public static void main(String[] args) {
		int[] res = new int[] { 6, 1, 3, 2, 4, 7 };
		int max = maxProfit(2, res);
		System.out.print(max);
	}
}
