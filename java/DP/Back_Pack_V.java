package DP;

/**
 * Given n items with size nums[i] which an integer array and all positive
 * numbers. An integer target denotes the size of a backpack. Find the number of
 * possible fill the backpack.
 * 
 * Each item may only be used once
 * 
 * 
 * Example Given candidate items [1,2,3,3,7] and target 7,
 * 
 * A solution set is: [7] [1, 3, 3] return 2
 * 
 * 
 * @author kaizhang
 *
 */
public class Back_Pack_V {
	public int backPackV(int[] nums, int target) {
		// Write your code here
		if (nums == null || nums.length == 0 || target <= 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = target; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[target];
	}
}
