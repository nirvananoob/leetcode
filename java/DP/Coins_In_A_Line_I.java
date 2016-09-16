package DP;

public class Coins_In_A_Line_I {
	/**
	 * There are n coins in a line. Two players take turns to take one or two
	 * coins from right side until there are no more coins left. The player who
	 * take the last coin wins.
	 * 
	 * Could you please decide the first play will win or lose?
	 */
	//greddy
	public boolean firstWillWin(int n) {
		// write your code here
		// state : dp[n] = !dp[n - 1] || !dp[n - 2]
		if (n <= 0) {
			return false;
		}
		boolean a = false;
		boolean b = false;
		boolean c = false;
		for (int i = 0; i < n; i++) {
			c = !a || !b;
			a = b;
			b = c;

		}
		return c;
	}
}
