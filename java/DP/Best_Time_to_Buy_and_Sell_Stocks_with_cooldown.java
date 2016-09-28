package DP;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again). After you sell your stock, you cannot
 * buy stock on next day. (ie, cooldown 1 day) Example:
 * 
 * prices = [1, 2, 3, 0, 2] maxProfit = 3 transactions = [buy, sell, cooldown,
 * buy, sell]
 * 
 * @author kaizhang
 *
 */
/**
 * please see the blog
 * https://discuss.leetcode.com/topic/30421/share-my-thinking-process to see
 * better solution
 * 
 * @author kaizhang
 *
 */
public class Best_Time_to_Buy_and_Sell_Stocks_with_cooldown {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		// if (pirces.length == 2) {
		// return Math.max(prices[1] - prices[0], 0);
		// }
		int[] local = new int[prices.length];
		int[] global = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			local[i] = prices[i] - min;
			min = Math.min(prices[i], min);
		}
		for (int i = 1; i < prices.length && i < 3; i++) {
			global[i] = Math.max(global[i - 1], local[i]);
		}
		for (int i = 3; i < prices.length; i++) {
			local[i] = Math.max(local[i - 1], global[i - 3]) + prices[i]
					- prices[i - 1];
			global[i] = Math.max(global[i - 1], local[i]);
		}
		return global[prices.length - 1];

	}
}
