package DP;

/**
 * There are n coins in a line. Two players take turns to take a coin from one
 * of the ends of the line until there are no more coins left. The player with
 * the larger amount of money wins.
 * 
 * Could you please decide the first player will win or lose?
 * 
 * 
 * Example Given array A = [3,2,2], return true.
 * 
 * Given array A = [1,2,4], return true.
 * 
 * Given array A = [1,20,4], return false.
 * 
 * Challenge Follow Up Question:
 * 
 * If n is even. Is there any hacky algorithm that can decide whether first
 * player will win or lose in O(1) memory and O(n) time?
 * 
 * 
 * @author kaizhang
 *
 */
/**
 * http://articles.leetcode.com/coins-in-line/
 * @author kaizhang
 *
 */
public class Coins_In_A_Line_III {
	/**
	 * @param values
	 *            : an array of integers
	 * @return: a boolean which equals to true if the first player will win
	 */
	/**
	 * main thinking : memory search, the transition function is • pick_left
	 * =min(dp[i+2][j], dp[i+1][j-1]) + coin[i]; • pick_right = min(dp[i][j-2],
	 * • dp[i+1][i-1])+coin[j]; • dp[i][j] = max(pick_left, pick_right); where
	 * dp[i][j] means the most amount of money you can get by taking a coin
	 * first from the coins subsequence in which the indices range from i to j
	 * 
	 * @author kaizhang
	 * 
	 */
	public boolean firstWillWin(int[] values) {
		// write your code here
		if (values == null || values.length == 0) {
			return false;
		}
		int[][] res = new int[values.length][values.length];
		boolean[][] visited = new boolean[values.length][values.length];
		int sum = 0;
		for (int cur : values) {
			sum += cur;
		}
		return search(values, res, visited, 0, values.length - 1) * 2 > sum;
	}

	private int search(int[] values, int[][] res, boolean[][] visited,
			int start, int end) {
		if (visited[start][end]) {
			return res[start][end];
		}

		if (start == end) {
			res[start][end] = values[start];
		} else if (start + 1 == end) {
			res[start][end] = Math.max(values[start], values[end]);
		} else {
			res[start][end] = Math
					.max(values[start]
							+ Math.min(
									search(values, res, visited, start + 2, end),
									search(values, res, visited, start + 1,
											end - 1)),
							values[end]
									+ Math.min(
											search(values, res, visited,
													start + 1, end - 1),
											search(values, res, visited, start,
													end - 2)));

		}
		visited[start][end] = true;
		return res[start][end];
	}
	/**
	 * for follow up : cause there only have even numbers , when pick first you
	 * can force your opponent to pick the coin even or odd numbered. 
	 * Count the sum of all coins that are odd-numbered. (Call this X)   
	 * Count the sum of all coins that are even-numbered. (Call this Y) 
	 * If X > Y, take the left-most coin first. Choose all odd-numbered coins in subsequent moves.
	 * If X < Y, take the right-most coin first. Choose all even-numbered coins in subsequent moves. 
	 * If X == Y, you will guarantee to get a tie if you stick with taking only even-numbered/odd-numbered coins.
	 * 
	 */
	
}
