package DP;

public class Longest_Incresing_Substring {
	/**
	 * Given a sequence of integers, find the longest increasing subsequence
	 * (LIS).
	 * 
	 * You code should return the length of the LIS.
	 * 
	 * Clarification What's the definition of longest increasing subsequence?
	 * 
	 * The longest increasing subsequence problem is to find a subsequence of a
	 * given sequence in which the subsequence's elements are in sorted order,
	 * lowest to highest, and in which the subsequence is as long as possible.
	 * This subsequence is not necessarily contiguous, or unique.
	 * 
	 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
	 * 
	 * Example For `[5, 4, 1, 2, 3]`, the LIS is [1, 2, 3], return `3`
	 * 
	 * For `[4, 2, 4, 5, 3, 7]`, the LIS is `[2, 4, 5, 7]`, return `4` Challenge
	 * Time complexity O(n^2) or O(nlogn)
	 */
	//v1 : dp
	 public int longestIncreasingSubsequence_dp(int[] nums){
	        if (nums == null || nums.length == 0 ) {
	            return 0;
	        }
	        if(nums.length == 1) {
	            return 1;
	        }
	        int[] lens = new int[nums.length];
	        for (int i = 0 ; i < lens.length; i++) {
	            lens[i] = 1;
	        }
	        for (int i = 1 ; i < lens.length; i++){
	            for (int j = 0; j< i; j++){
	                if (nums[j] <= nums[i] && lens[j] + 1 > lens[i]){
	                  lens[i] = lens[j] + 1;
	                }
	            }
	        }
	        int max = lens[0];
	        for (int i = 1; i < lens.length; i++){
	            max = Math.max(lens[i], max);
	        }
	        
	        return max;
	    }
	 //v2 :challenge : patience_sorting:
	 /*
	  * reference :
	  * https://en.wikipedia.org/wiki/Patience_sorting
	  * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
	  */
	 public int longestIncreasingSubsequence_bst(int[] nums) {
	        int[] res = new int[nums.length];
	        int cur = 0;
	        res[0] = nums[0];
	        // int smallest = nums[0] , largest = nums[0];
	        for (int i = 1; i < nums.length; i++){
	            if (nums[i] < res[0] ) {
	                res[0] = nums[i];
	            }else if (nums[i] >= res[cur]) {
	                res[++ cur] = nums[i];
	            }else {
	                int index = bst(res, 0, cur, nums[i]);
	                res[index] =  nums[i];
	            }
	        }
	        return cur + 1;
	    }
	    private int bst(int[] arr, int start, int end ,int target){
	        int l = start, r = end;
	        int mid;
	        while (l + 1 < r) {
	             mid = (l + r) / 2;
	             if( arr[mid]  == target ){
	                 return mid;
	             }else if(arr[mid] > target) {
	                 r = mid - 1;
	             }else {
	                 l = mid + 1;
	             }
	        }
	        if (arr[r] < target) {
	            return r + 1;
	        }else if (arr[l] <= target) {
	            return r;
	        }else {
	            return l;
	        }
	    }
	    public static void main(String[] args) {
	    	int[] test = new int[] {88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59};
	    	Longest_Incresing_Substring lis = new Longest_Incresing_Substring();
	    	System.out.println(lis.longestIncreasingSubsequence_bst(test));
	    }
}
