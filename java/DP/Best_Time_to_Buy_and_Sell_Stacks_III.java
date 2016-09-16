package DP;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Notice

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


 Example
 Given an example [4,4,6,1,1,4,2,5], return 6.
 */
public class Best_Time_to_Buy_and_Sell_Stacks_III {
	//v1 超时
	 // v2,  chaoshi
    //  public int maxProfit(int[] prices) {
    //     if(prices == null || prices.length <= 1 ) {
    //         return 0;
    //     }
    //     int max = 0;
    //     for(int i = 0 ; i < prices.length; i ++) {
    //         max = Math.max(singlemaxProfit(prices, 0, i) +  singlemaxProfit(prices, i + 1, prices.length - 1), max);
    //     }
    //     return max;
    // }
    // private int singlemaxProfit(int[] A,int start, int end) {
    //     if (start >= end) {
    //         return 0;
    //     }
    //     int min = A[start];
    //     int max = 0;
    //     for(int i = start + 1; i <= end; i++) {
    //         if (A[i]  > min) {
    //             max = Math.max(A[i] - min, max);
    //         }else{
    //             min = A[i];
    //         }
    //     }
    //     return max;
    // }
	// v2
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		left[0] = 0;
		right[right.length - 1] = 0;
		// dp from left to right:
		int min = prices[0];
		for (int i = 1; i < left.length; i++) {
			if (prices[i] <= min) {
				left[i] = left[i - 1];
				min = prices[i];
			} else {
				left[i] = Math.max(left[i - 1], prices[i] - min);
			}
		}
		int max = prices[right.length - 1];
		for (int i = right.length - 2; i >= 0; i--) {
			if (prices[i] >= max) {
				max = prices[i];
				right[i] = right[i + 1];
			} else {
				right[i] = Math.max(right[i + 1], max - prices[i]);
			}
		}
		int res = 0;
		for (int i = 0; i < left.length; i++) {
			res = Math.max(left[i] + right[i], res);
		}
		return res;
	}
}
