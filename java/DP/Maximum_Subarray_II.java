package DP;

import java.util.ArrayList;

public class Maximum_Subarray_II {
	/**
	 * Given an array of integers, find two non-overlapping subarrays which have
	 * the largest sum. The number in each subarray should be contiguous. Return
	 * the largest sum.
	 * 
	 * Notice
	 * 
	 * The subarray should contain at least one number
	 * 
	 * 
	 * Example For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and
	 * [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.
	 * 
	 * Challenge Can you do it in time complexity O(n) ?
	 * 
	 * @param nums
	 * @return
	 */
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		if (nums == null || nums.size() <= 1) {
			return 0;
		}
		int len = nums.size();
		int[] left = new int[len];
		int[] right = new int[len];
		int[] maxleft = new int[len];
		int[] maxright = new int[len];
		left[0] = nums.get(0);
		right[len - 1] = nums.get(len - 1);
		maxleft[0] = left[0];
		maxright[len - 1] = right[len - 1];
		for (int i = 1; i < len; i++) {
			left[i] = Math.max(left[i - 1], 0) + nums.get(i);
			maxleft[i] = Math.max(left[i], maxleft[i - 1]);
			right[len - 1 - i] = Math.max(right[len - i], 0)
					+ nums.get(len - 1 - i);
			maxright[len - i - 1] = Math.max(right[len - 1 - i], maxright[len
					- i]);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len - 1; i++) {
			max = Math.max(max, maxleft[i] + maxright[i + 1]);
		}
		return max;
	}
	// v2 : optimization : just need two array left[] and right[] to store the
	// max value end at i from left or start at i from right , use two variables
	// to store the value of sum must includes the ith element
	  public int maxTwoSubArrays_final(ArrayList<Integer> nums) {
	        // write your code
	        int size = nums.size();
	        int[] left = new int[size];
	        int[] right = new int[size];
	        int sum = 0;
	        int minSum = 0;
	        int max = Integer.MIN_VALUE;
	        for(int i = 0; i < size; i++){
	            sum += nums.get(i);
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(sum, minSum);
	            left[i] = max;
	        }
	        sum = 0;
	        minSum = 0;
	        max = Integer.MIN_VALUE;
	        for(int i = size - 1; i >= 0; i--){
	            sum += nums.get(i);
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(sum, minSum);
	            right[i] = max;
	        }
	        max = Integer.MIN_VALUE;
	        for(int i = 0; i < size - 1; i++){
	            max = Math.max(max, left[i] + right[i + 1]);
	        }
	        return max;
	    }
}
