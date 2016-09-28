package DP;

/**
 * Given an array with integers.
 * 
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the
 * largest.
 * 
 * Return the largest difference.
 * 
 * Notice
 * 
 * The subarray should contain at least one number
 * 
 * 
 * Example For [1, 2, -3, 1], return 6.
 * 
 * Challenge O(n) time and O(n) space.
 **/
public class Maximum_Subarray_Difference {
	public static int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] max_left = new int [len];
        int[] min_left = new int[len];
        int[] max_right = new int[len];
        int[] min_right = new int[len];
        max_left[0] = nums[0];
        min_left[0] = nums[0];
        // int maxcur = num , mincur;
        for(int i = 1; i < len; i++) {
            max_left[i] = nums[i] +  Math.max(max_left[i - 1], 0);
            min_left[i] = nums[i] + Math.min(min_left[i - 1], 0);
        }
        for(int i = 1; i < len; i++){
            max_left[i]  = Math.max(max_left[i], max_left[i - 1]);
            min_left[i]  = Math.min(min_left[i], min_left[i - 1]);
         }
         min_right[len - 1] = nums[len - 1];
         max_right[len - 1] = nums[len - 1];
         for(int i = len - 2; i >= 0; i--) {
             max_right[i] = Math.max(max_right[i+ 1] , 0) + nums[i];
             min_right[i]  = Math.min(min_right[i + 1], 0) + nums[i];
         }
         for(int i = len - 2; i >= 0; i--) {
             max_right[i] = Math.max(max_right[i + 1], max_right[i]);
             min_right[i] = Math.min(min_right[i + 1], min_right[i]);
         }
         int res = 0;
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(Math.max(Math.abs(max_left[i] - min_right[ i + 1]),Math.abs(min_left[i] - max_right[i + 1])),res);
        }
        return res;
    }
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,-3,1};
		System.out.println(maxDiffSubArrays(arr));
	}
}
