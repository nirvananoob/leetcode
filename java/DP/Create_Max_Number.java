package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return an
 * array of the k digits. You should try to optimize your time and space
 * complexity. Example Given nums1 = [3, 4, 6, 5], nums2 = [9, 1, 2, 5, 8, 3], k
 * = 5 return [9, 8, 6, 5, 3]
 * 
 * Given nums1 = [6, 7], nums2 = [6, 0, 4], k = 5 return [6, 7, 6, 0, 4]
 * 
 * Given nums1 = [3, 9], nums2 = [8, 9], k = 3 return [9, 8, 9]
 * 
 * Tags Greedy Dynamic Programming Google
 * 
 * @author kaizhang
 *
 */
public class Create_Max_Number {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		// Write your code here
		if (nums1 == null || nums2 == null || nums1.length + nums2.length < k) {
			return null;
		}
		int[] res = new int[k];
		for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length,
				k); i++) {
			int[] l1 = gettopNumber(nums1, i);
			int[] l2 = gettopNumber(nums2, k - i);
			res = getMax(res, merge(l1, l2));
		}
		return res;

	}

	private int[] gettopNumber(int[] nums, int k) {

		if (k == 0) {
			return new int[0];
		}
//
//		int drop = nums.length - k;
//		int[] arr = new int[k];
		// for(int i = 0 ; i < arr.length; i++) {
		// arr[i] = -1;
		// }
//		for (int i = 0, j = 0; i < nums.length; i++) {
//			while (drop > 0 && j > 0 && arr[j - 1] < nums[i]) {
//				--drop;
//				j--;
//			}
//			if (j < k) {
//				arr[j++] = nums[i];
//			}else {
//				drop --;
//			}
//		}
//		return arr;
		 int n = nums.length;
		 int[] ans = new int[k];
		 for (int i = 0, j = 0; i < n; ++i) {
		 while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
		 if (j < k) ans[j++] = nums[i];
		 }
		 return ans;

	}

	public boolean greater(int[] nums1, int start1, int[] nums2, int start2) {
		for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
			if (nums1[start1] > nums2[start2])
				return true;
			if (nums1[start1] < nums2[start2])
				return false;
		}
		return start1 != nums1.length;
	}

	private int[] merge(int[] l1, int[] l2) {
		int[] res = new int[l1.length + l2.length];
		int index1 = 0, index2 = 0, count = 0;
		while (index1 < l1.length && index2 < l2.length) {
			res[count++] = greater(l1, index1, l2, index2) == true ? l1[index1++]
					: l2[index2++];
		}
		while (index1 < l1.length) {
			res[count++] = l1[index1++];
		}
		while (index2 < l2.length) {
			res[count++] = l2[index2++];
		}
		return res;
	}

	private int[] getMax(int[] res1, int[] res2) {
		if (res1.length != res2.length) {
			throw new IllegalArgumentException();
		}

		return greater(res1, 0, res2, 0) == true ? res1 : res2;
	}

	public static void main(String[] args) {
		Create_Max_Number test = new Create_Max_Number();

		int[] arr1 = new int[] { 8, 8, 7, 5, 9, 1, 2 };
		int[] arr2 = new int[] { 9,  8 };

		System.out.println(Arrays.toString(test.maxNumber(arr2, arr1, 5)));
	}
}
