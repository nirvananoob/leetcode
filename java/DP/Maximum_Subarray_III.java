package DP;

public class Maximum_Subarray_III {
	/**
	 * Given an array of integers and a number k, find k non-overlapping
	 * subarrays which have the largest sum.
	 * 
	 * The number in each subarray should be contiguous.
	 * 
	 * Return the largest sum.
	 * 
	 * Notice
	 * 
	 * The subarray should contain at least one number
	 * 
	 * Given [-1,4,-2,3,-2,3], k=2, return 8
	 * 
	 * Tags LintCode Copyright Dynamic Programming Subarray Array
	 */
	public int maxSubArray(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
			return 0;
		}
		int[][] local = new int[k][nums.length];
		int[][] global = new int[k][nums.length];
		// initizaliton
		local[0][0] = nums[0];
		global[0][0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			local[0][i] = Math.max(local[0][i - 1], 0) + nums[i];
			global[0][i] = Math.max(local[0][i], global[0][i - 1]);
		}
		for (int i = 1; i < k; i++) {
			local[i][i] = local[i - 1][i - 1] + nums[i];
			global[i][i] = local[i][i];
		}
		// state :
		// local[i][j] = Maximum(global[i - 1][j - 1] + nums[j],global[i - 1][j
		// - 2] + nums[j] + nums[j - 1] .....global[i - 1][i - 1] + sum(nums[i]
		// to nums[j])
		// local[i][j - 1] = Maximum(global[i - 1][j - 2] + nums[j - 1]
		// .....global[i - 1][i - 1] + sum(nums[i] to nums[j - 1])
		// which means local[i][j] = Maximum(global[i - 1][j - 1], local[i][j -
		// 1]) + nums[j]!!!
		// global[i][j] = Maximum(global[i][j - 1] ,local[i][j])
		for (int i = 1; i < k; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				local[i][j] = Math.max(local[i][j - 1], global[i - 1][j - 1])
						+ nums[j];

				global[i][j] = Math.max(local[i][j], global[i][j - 1]);

			}
		}
		return global[k - 1][nums.length - 1];
	}

	public static void main(String[] args) {
		Maximum_Subarray_III test = new Maximum_Subarray_III();
		int[] arr = new int[] { -1, 4, -2, 3, -2, 3 };
		int k = 2;
		System.out.println(test.maxSubArray(arr, k));
	}
}
