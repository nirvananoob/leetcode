package DP;

public class Jump_Game_I {
	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * Notice
	 * 
	 * This problem have two method which is Greedy and Dynamic Programming.
	 * 
	 * The time complexity of Greedy method is O(n).
	 * 
	 * The time complexity of Dynamic Programming method is O(n^2).
	 * 
	 * We manually set the small data set to allow you pass the test in both
	 * ways. This is just to let you learn how to use this problem in dynamic
	 * programming ways. If you finish it in dynamic programming ways, you can
	 * try greedy method to make it accept again.
	 * 
	 * Example A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 */
	// V2 - DP
	// public boolean canJump(int[] A) {
	// if (A == null || A.length == 0){
	// return false;
	// }
	// if (A.length == 1) {
	// return true;
	// }
	// boolean[] res = new boolean[A.length];
	// res[0] = true;
	// for (int i = 1; i < res.length; i++) {
	// for (int j = 0 ; j < i ; j++) {
	// if(res[j] == true && j + A[j] >= i) {
	// res[i] = true;
	// break;
	// }
	// }
	// }
	// return res[A.length - 1];
	// }
	// v2 -Greedy
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
		if (A.length == 1) {
			return true;
		}
		int max = A[0];
		int cur = 0;
		while (cur <= max) {
			if (max >= A.length - 1) {
				return true;
			}
			int next = 0;
			for (int i = cur; i <= max; i++) {
				if (i + A[i] > next) {
					next = i + A[i];
				}
			}
			if (max == next) {
				return false;
			}
			cur = max;
			max = next;

		}
		return false;
	}
}
