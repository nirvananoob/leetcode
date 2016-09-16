package DP;

public class Longest_Increasing_Continuous_Subsequence {
	/**
	 * Give an integer array，find the longest increasing continuous subsequence
	 * in this array.
	 * 
	 * An increasing continuous subsequence:
	 * 
	 * Can be from right to left or from left to right. Indices of the integers
	 * in the subsequence should be continuous. Notice
	 * 
	 * O(n) time and O(1) extra space.
	 * 
	 * 
	 * Example For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
	 * 
	 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
	 */
	public int longestIncreasingContinuousSubsequence(int[] A) {
		// Write your code here
		if (A == null || A.length == 0) {
			return 0;
		}
		int length = 1;
		int max = 1;
		// left to right
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= A[i - 1]) {
				length++;
			} else {
				length = 1;
			}
			max = Math.max(max, length);
		}
		// right to left
		length = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] >= A[i + 1]) {
				length++;
			} else {
				length = 1;
			}
			max = Math.max(length, max);
		}
		return max;
	}
}
