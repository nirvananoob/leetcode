package DP;

public class Maximum_Subarray_I {
	/**
	 * Given an array of integers, find a contiguous subarray which has the
	 * largest sum.
	 * 
	 * Notice
	 * 
	 * The subarray should contain at least one number.
	 * 
	 * 
	 * Example Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray
	 * [4,−1,2,1] has the largest sum = 6.
	 * 
	 * Challenge Can you do it in time complexity O(n)?
	 */
	// v1 greedy : O(n)
	public int maxSubArray(int[] nums) {
		// write your code
		if (nums == null) {
			return Integer.MIN_VALUE;
		}

		int sum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			sum = Math.max(0, sum);
		}
		return max;
	}

	// v2 : divide and conquer:
	public int maxSubArray_DC(int[] nums) {
		return max(nums, 0, nums.length - 1);
	}

	 private int max(int[] A, int left, int right) {
		if (left == right) {
			return A[left];
		}
		if (left + 1 == right) {
			return Math.max(Math.max(A[left] + A[right], A[left]), A[right]);
		}
		int mid = (left + right) / 2;
		int leftmax = max(A, left, mid - 1);
		int rightmax = max(A, mid + 1, right);
		int mmax = A[mid];
		int max = mmax;
		for (int i = mid - 1; i >= left; i--) {
			max += A[i];
			mmax = Math.max(mmax, max);
		}
		max = mmax;
		for (int i = mid + 1; i <= right; i++) {
			max += A[i];
			mmax = Math.max(mmax, max);
		}
		return Math.max(mmax, Math.max(leftmax, rightmax));
	}
}
