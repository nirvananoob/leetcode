package DP;

public class Jump_Game_II {
	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * 
	 * 
	 * Example Given array A = [2,3,1,1,4]
	 * 
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
	 * from index 0 to 1, then 3 steps to the last index.)
	 */
	/**
	 * @param A
	 *            : A list of lists of integers
	 * @return: An integer
	 */
	// method 1: dp
	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 0;
		}
		// initialization
		int[] res = new int[A.length];
		for (int i = 1; i < A.length; i++) {
			res[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				// caution ! 不能直接写res[i] > res[j] + 1,会溢出
				if (j + A[j] >= i && res[i] - (res[j] + 1) > 0) {
					res[i] = res[j] + 1;
				}
			}
		}
		return res[A.length - 1];
	}

	// v2 greddy
	public int jump_greedy(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 0;
		}
		int max = 0, cur = 0;
		int count = 0;
		while (cur <= max && max < A.length - 1) {
			count++;
			int next = max;
			for (int i = cur; i <= max; i++) {
				if (i + A[i] > next) {
					next = i + A[i];
				}
			}
			if (next == max) {
				return Integer.MAX_VALUE;
			}
			cur = max;
			max = next;
		}
		return count;
	}
}
