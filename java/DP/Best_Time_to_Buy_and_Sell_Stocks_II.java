package DP;

public class Best_Time_to_Buy_and_Sell_Stocks_II {
	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */
	//V1DP :
	public int maxProfit_dp(int[] prices) {
	    //     // write your code here
	    
	         if (prices == null || prices.length <= 1){
	             return 0;
	         }
	         int size = prices.length ;
	         int[] profit = new int[size] ;
	         for(int i = 1 ; i < size ; i++){
	             profit[i] = profit[i-1] + Math.max(prices[i] -prices[i-1] , 0);
	         }
	         return profit[size - 1];
	     }
	//v2 Greedy
	 public int maxProfit(int[] prices) {
         if(prices == null || prices.length <= 1) {
             return 0;
         }
         int min = prices[0];
         int max = 0;
         for(int i = 1; i < prices.length; i++) {
             if (prices[i] < min){
                 min = prices[i];
                 continue;
             }
             max += prices[i] - min;
             min = prices[i];
         }
         return max;
     }
}
