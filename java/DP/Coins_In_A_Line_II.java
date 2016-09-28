package DP;

/**
 * There are n coins with different value in a line. Two players take turns to
 * take one or two coins from left side until there are no more coins left. The
 * player who take the coins with the most value wins.
 * 
 * Could you please decide the first player will win or lose?
 * 
 * 
 * Example Given values array A = [1,2,2], return true.
 * 
 * Given A = [1,2,4], return false.
 * 
 * @author kaizhang
 *
 */
public class Coins_In_A_Line_II {
	/**
	 * @param values
	 *            : an array of integers
	 * @return: a boolean which equals to true if the first player will win
	 */
	// greedy
	public boolean firstWillWin(int[] values) {
		// write your code here
		if (values == null || values.length == 0) {
			return false;
		}
		if (values.length == 1 || values.length == 2) {
			return true;
		}
		int sum = 0;

		for (int i = 1; i < values.length; i++) {
			sum += values[i];
		}
		int money = 0;
		// int[] lose = new int[values.length];
		boolean a = false;
		boolean b = false;
		boolean c = false;
		for (int i = 0; i < values.length; i++) {
			c = !a || !b;
			a = b;
			b = c;
			if (c) {
				money += values[i];
			}
		}
		return money > sum - money;
	}

	// dp :

	/**
	 * @param values
	 *            : an array of integers
	 * @return: a boolean which equals to true if the first player will win
	 */
	/**
	 * • State: • dp[i] 现在还剩i个硬币,现在先手取硬币的人最后最多取硬币价值
	 *  • Function: 
	 *  • n 是所有硬币数目 
	 *  •pick_one = min(dp[i-2], dp[i-3]) + coin[n-i] ; 
	 *  • pick_two = min(dp[i-3],dp[i-4]) + coin[n-i] + coin[n-i+1]; 
	 *  • dp[i] = max(pick_one, pick_two) 
	 *  •Intialize: 
	 *  • dp[0] = 0
	 *  • dp[1] = coin[i-1] 
	 *  • dp[2] = coin[i-2] +coin[i-1] 
	 *  • dp[3] = coin[i-3] + coin[i-2] 
	 *  • Answer:
	 * 
	 * @param values
	 * @return
	 */
	public boolean firstWillWin_DP(int[] values) {
		// write your code here
		int[] dp = new int[values.length + 1];
		boolean[] flag = new boolean[values.length + 1];
		int sum = 0;
		for (int now : values)
			sum += now;

		return sum < 2 * MemorySearch(values.length, dp, flag, values);
	}

	int MemorySearch(int n, int[] dp, boolean[] flag, int[] values) {
		if (flag[n] == true)
			return dp[n];
		flag[n] = true;
		if (n == 0) {
			dp[n] = 0;
		} else if (n == 1) {
			dp[n] = values[values.length - 1];
		} else if (n == 2) {
			dp[n] = values[values.length - 1] + values[values.length - 2];
		} else if (n == 3) {
			dp[n] = values[values.length - 2] + values[values.length - 3];
		} else {
			dp[n] = Math.max(
					Math.min(MemorySearch(n - 2, dp, flag, values),
							MemorySearch(n - 3, dp, flag, values))
							+ values[values.length - n],
					Math.min(MemorySearch(n - 3, dp, flag, values),
							MemorySearch(n - 4, dp, flag, values))
							+ values[values.length - n]
							+ values[values.length - n + 1]);
		}

		return dp[n];
	}
}
