package DP;

import java.util.ArrayList;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely. - You
 * may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not
 * burst them. - 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * Example Given [4, 1, 5, 10] Return 270
 * 
 * nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20 nums = [4, 5, 10]
 * burst 5, get coins 4 * 5 * 10 = 200 nums = [4, 10] burst 4, get coins 1 * 4 *
 * 10 = 40 nums = [10] burst 10, get coins 1 * 10 * 1 = 10
 * 
 * Total coins 20 + 200 + 40 + 10 = 270
 * 
 * @author kaizhang
 *
 */
public class Burst_Ballons {
	/**
	 * @param nums
	 *            a list of integer
	 * @return an integer, maximum coins
	 */
	// //v1 : backtracking : O(n!),time limit exceeded
	// public int maxCoins(int[] nums) {
	// // Write your code here
	// if(nums == null || nums.length == 0) {
	// return 0;
	// }
	// ArrayList<Integer> list = new ArrayList<Integer> ();
	// list.add(1);
	// for(int cur : nums){
	// list.add(cur);
	// }
	// list.add(1);
	// int max = 0, curmax = 0;
	// return dfs(list, max, curmax);
	//
	//
	// }
	// private int dfs(ArrayList<Integer> list, int max, int curmax) {
	// if(list.size() <= 2){
	// max = Math.max(curmax, max);
	// return max;
	// }
	// int size = list.size();
	// for(int i = 1; i < size - 1; i++) {
	// int score = list.get(i) * list.get(i - 1) * list.get(i + 1);
	// int temp = list.get(i);
	// curmax += score;
	// list.remove(i);
	// max = dfs(list, max, curmax);
	// list.add(i,temp);
	// curmax -= score;
	// }
	// return max;
	// }
	// v2 memory search
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] bound = new int[len + 2];

		int n = 1;
		for (int cur : nums) {
			bound[n++] = cur;
		}
		bound[0] = bound[n++] = 1;
		int[][] res = new int[n][n];
		
		return search(res, bound, 0, n - 1);
	}

	private int search(int[][] res, int[] nums, int l, int r) {
		if (res[l][r] != 0) {
			return res[l][r];
		}
		if (l + 1 >= r) {
			return 0;
		} else {
			int ans = 0;
			for (int i = l + 1; i < r; i++) {
				ans = Math.max(
						nums[l] * nums[r] * nums[i] + search(res, nums, l, i)
								+ search(res, nums, i, r), ans);
			}
			res[l][r] = ans;
		}
		return res[l][r];
	}
	//v3 DP
	 public int maxCoins_DP(int[] nums) {
	       if(nums == null ||nums.length == 0 ) {
	           return 0;
	       }
	       int[] arr = new int[nums.length + 2];
	       int n = 1;
	       for (int cur : nums){
	           arr[n++] = cur;
	       }
	       arr[n++] = arr[0] = 1;
	       int[][] dp = new int[n][n];
	        for (int k = 2; k < n; ++k){
	        for (int left = 0; left < n - k; ++left) {
	            int right = left + k;
	            for (int i = left + 1; i < right; ++i)
	                dp[left][right] = Math.max(dp[left][right], 
	                arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]);
	        }

	              
	       }
	       return dp[0][n - 1];
	       
	    }
	public static void main(String[] args) {
		int[] test = new int[] { 4, 1, 5, 10 };
		Burst_Ballons a = new Burst_Ballons();
		System.out.println(a.maxCoins(test));
	}
}
