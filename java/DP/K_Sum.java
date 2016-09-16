package DP;

/**
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * 
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * 
 * 
 * Example Given [1,2,3,4], k = 2, target = 5.
 * 
 * There are 2 solutions: [1,4] and [2,3].
 * 
 * Return 2.
 * 
 * @author kaizhang
 *
 */
public class K_Sum {
	public int kSum(int A[], int k, int target) {
		// write your code here
		if (A == null || A.length == 0 || k == 0) {
			return 0;
		}
		int[][][] dp = new int[A.length][k + 1][target + 1];
		for (int i = 0; i < A.length; i++) {
			dp[i][0][0] = 1;
		}
		dp[0][1][A[0]] = 1;

		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j <= Math.min(k, i + 1); j++) {
				for (int m = 0; m <= target; m++) {
					dp[i][j][m] = dp[i - 1][j][m];
					if (m >= A[i]) {
						dp[i][j][m] += dp[i - 1][j - 1][m - A[i]];
					}
				}
			}
		}
		return dp[A.length - 1][k][target];
	}
}
