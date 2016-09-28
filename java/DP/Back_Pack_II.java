package DP;

/**
 * Given n items with size Ai and value Vi, and a backpack with size m. What's
 * the maximum value can you put into the backpack?
 * 
 * Notice
 * 
 * You cannot divide item into small pieces and the total size of items you
 * choose should smaller or equal to m.
 * 
 * 
 * Example Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a
 * backpack with size 10. The maximum value is 9.
 * 
 * Challenge O(n x m) memory is acceptable, can you do it in O(m) memory?
 * 
 * @author kaizhang
 *
 */
public class Back_Pack_II {
	public int backPackII(int m, int[] A, int V[]) {
		// write your code here
		if (m == 0 || A.length == 0 || V.length == 0 || A.length != V.length) {
			return 0;
		}
		int n = A.length;

		int[] dp = new int[m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = m; j >= A[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
			}
		}
		int max = 0;
		for (int i = 0; i < m + 1; i++) {
			max = Math.max(dp[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 5, 7 };
		int[] V = { 1, 4, 2, 5 };
		Back_Pack_II test = new Back_Pack_II();
		System.out.println(test.backPackII(10, A, V));
	}
}
