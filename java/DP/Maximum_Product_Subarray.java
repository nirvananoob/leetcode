package DP;

public class Maximum_Product_Subarray {
	/*
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest product.
	 * 
	 * 
	 * Example For example, given the array [2,3,-2,4], the contiguous subarray
	 * [2,3] has the largest product = 6.
	 */

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] curmax = new int[nums.length];
		int[] curmin = new int[nums.length];
		curmax[0] = nums[0];
		curmin[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			curmax[i] = nums[i] >= 0 ? Math.max(curmax[i - 1] * nums[i],
					nums[i]) : Math.max(curmin[i - 1] * nums[i], nums[i]);
			curmin[i] = nums[i] < 0 ? Math
					.min(curmax[i - 1] * nums[i], nums[i]) : Math.min(
					curmin[i - 1] * nums[i], nums[i]);
			max = Math.max(max, curmax[i]);
		}
		return max;
	}
}