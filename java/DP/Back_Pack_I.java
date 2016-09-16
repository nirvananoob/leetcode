package DP;

import java.util.Arrays;

/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How
 * full you can fill this backpack?
 * 
 * Notice
 * 
 * You can not divide any item into small pieces.
 * 
 * 
 * Example If we have 4 items with size [2, 3, 5, 7], the backpack size is 11,
 * we can select [2, 3, 5], so that the max size we can fill this backpack is
 * 10. If the backpack size is 12. we can select [2, 3, 7] so that we can
 * fulfill the backpack.
 * 
 * You function should return the max size we can fill in the given backpack.
 * 
 * Challenge O(n x m) time and O(m) memory.
 * 
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * 
 * 
 * @author kaizhang
 *
 */
public class Back_Pack_I {
	public int backPack(int m, int[] A) {
		// write your code here
		if (m == 0 || A == null || A.length == 0) {
			return 0;
		}
		Arrays.sort(A);
		int n = A.length;
		boolean[] dp = new boolean[m + 1];
		dp[0] = true;
		for (int i = 0; i < n; i++) {
			for (int j = m; j >= A[i]; j--) {
				dp[j] = dp[j] || dp[j - A[i]];
			}
		}
		for (int i = m; i >= 0; i--) {
			if (dp[i] == true) {
				return i;
			}
		}

		return 0;
	}
}
