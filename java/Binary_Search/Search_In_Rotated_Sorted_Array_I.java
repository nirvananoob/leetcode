package Binary_Search;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Subscribe to see which companies asked this question
 * 
 * @author kaizhang
 *
 */
public class Search_In_Rotated_Sorted_Array_I {
	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0, r = nums.length - 1;
		int mid;
		while (l + 1 < r) {
			mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[l] < nums[mid]) {
				if (target < nums[mid] && target >= nums[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[r]) {
					l = mid + 1;
				} else {

					r = mid - 1;
				}
			}
		}
		if (nums[l] == target) {
			return l;
		} else if (nums[r] == target) {
			return r;
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		System.out.println(search(arr, 5));
	}
}
