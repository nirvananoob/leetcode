package DP;

import java.util.Arrays;

/**
 * On one line there are n houses. Give you an array of integer means the the
 * position of each house. Now you need to pick k position to build k post
 * office, so that the sum distance of each house to the nearest post office is
 * the smallest. Return the least possible sum of all distances between each
 * village and its nearest post office.
 * 
 * Example Given array a = [1,2,3,4,5], k = 2. return 3.
 * 
 * Challenge Could you solve this problem in O(n^2) time ?
 * 
 * @author kaizhang
 *
 */
public class Post_Office {
	public int postOffice(int[] A, int k) {
		// Write your code here
		if (A == null || A.length == 0 || k == 0) {
			return 0;
		}
		Arrays.sort(A);
		int[][] dis = process(A);
		int[][] res = new int[A.length + 1][k + 1];
		for (int i = 1; i <= A.length; i++) {
			res[i][1] = dis[1][i];
		}
		// for(int i = 1; i <= A.length; i++) {
		// for(int j = 2 ; j <= k; j++) {
		// res[i][j] = Integer.MAX_VALUE;
		// for(int m = 1; m < i; i++) {
		// res[i][j] = Math.min(res[i][j], res[m][j - 1] + dis[m + 1][i]);
		// }
		// }
		// }
		for (int i = 2; i <= k; i++) {
			for (int j = i + 1; j <= A.length; j++) {
				res[j][i] = Integer.MAX_VALUE;
				for (int m = 1; m < j; m++) {
					res[j][i] = Math.min(res[j][i], res[m][i - 1]
							+ dis[m + 1][j]);
				}
			}
		}

		return res[A.length][k];
	}

	private int[][] process(int[] A) {
		int[][] dp = new int[A.length + 1][A.length + 1];
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= A.length; j++) {
				int pos = (i + j) / 2 - 1;
				for (int m = i; m <= j; m++) {
					dp[i][j] += Math.abs(A[m - 1] - A[pos]);
				}
			}
		}
		return dp;
	}
	/**
	 * ans for follow up :
	 * to optiminze the algo to O(n^2)， we need use the property of monge array.
	 * see the link:
	 * http://blog.csdn.net/find_my_dream/article/details/4931222
	 */
}
