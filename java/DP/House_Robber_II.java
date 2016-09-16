package DP;

public class House_Robber_II {
	/**
	 * After robbing those houses on that street, the thief has found himself a
	 * new place for his thievery so that he will not get too much attention.
	 * This time, all houses at this place are arranged in a circle. That means
	 * the first house is the neighbor of the last one. Meanwhile, the security
	 * system for these houses remain the same as for those in the previous
	 * street.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 * 
	 * Notice
	 * 
	 * This is an extension of House Robber.
	 * 
	 * 
	 * Example nums = [3,6,4], return 6
	 * 
	 * Tags Dynamic Programming, Microsoft
	 */
	public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //if the first one will be stolen
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(dp(nums, 0, nums.length - 2),dp(nums, 1, nums.length - 1)); 
    }
    private int dp(int[] arr, int start, int end) {
        int[] res = new int[2];
        res[0] = arr[start];
        res[1] = Math.max (arr[start + 1],arr[start]);
        for (int i = 2; i < end - start + 1; i++) {
            res[i % 2] = Math.max(res[(i - 2) % 2] + arr[i + start] ,res[(i -1) % 2]);
        }
        return res[(end - start) % 2];
    }
}
