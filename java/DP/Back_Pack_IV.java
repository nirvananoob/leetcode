package DP;

import java.util.ArrayList;

/**
 * Given n items with size nums[i] which an integer array and all positive
 * numbers, no duplicates. An integer target denotes the size of a backpack.
 * Find the number of possible fill the backpack.
 * 
 * Each item may be chosen unlimited number of times
 * 
 * 
 * Example Given candidate items [2,3,6,7] and target 7,
 * 
 * A solution set is: [7] [2, 2, 3] return 2
 * 
 * 
 * @author kaizhang
 *
 */
public class Back_Pack_IV {
	public int backPackIV(int[] nums, int target) {
		// Write your code here
		if (nums == null || nums.length == 0 || target <= 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;

		for (int i = 0; i < nums.length; i++) {

			for (int j = 1; j <= target; j++) {

				if (j >= nums[i]) {
					dp[j] += dp[j - nums[i]];
				}
			}
		}
		return dp[target];

	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };
		int target = 7;
		Back_Pack_IV test = new Back_Pack_IV();
		System.out.println(test.backPackIV(arr, target));
		ArrayList<Integer> list = new ArrayList<Integer> ();
		list.add(1);
		list.add(0, 0);
		System.out.println(list.toString());
	}
}
