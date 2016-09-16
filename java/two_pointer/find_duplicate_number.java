package two_pointer;

import algorithms_template.bit_map;
import java.util.Arrays;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: You must not modify the array (assume the array is read only). You must
 * use only constant, O(1) extra space. Your runtime complexity should be less
 * than O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 * 
 * @author kaizhang
 *
 */
public class find_duplicate_number {
	// first version use count_array
	// public static int findDuplicate(int[] nums) {
	//
	// if (nums == null || nums.length == 0 ) {
	// return -1;
	// }
	// int[] arr = new int[nums.length - 1];
	// for (int i = 0 ; i < nums.length; i++) {
	// arr[nums[i] - 1] ++;
	// }
	// for(int i = 0; i < arr.length ; i++) {
	// if (arr[i] > 1) {
	// return i + 1;
	// }
	// }
	// return -1;
	//
	// }
	// second version(optimization : use bit_map algo to store the count number)
	public static int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		bit_map map = new bit_map(nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			if (map.contain(nums[i])) {
				return nums[i];
			}
			map.add(nums[i]);
		}
		return -1;
	}

	// // third version : binary search
	// public static int findDuplicate(int[] nums) {
	// int low = 1, high = nums.length - 1;
	// while (low <= high) {
	// int mid = (int) (low + (high - low) * 0.5);
	// int cnt = 0;
	// for (int a : nums) {
	// if (a <= mid)
	// ++cnt;
	// }
	// if (cnt <= mid)
	// low = mid + 1;
	// else
	// high = mid - 1;
	// }
	// return low;
	// }

	// version 4: modify the value
	// public static int findDuplicate (int[] nums){
	// if(nums == null || nums.length == 0) {
	// return -1;
	// }
	// for (int i = 0; i < nums.length; i++ ) {
	// if
	// ( nums[Math.abs(nums[i])] <= 0) {
	//
	// return nums[Math.abs(nums[i])];
	// }else{
	// nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
	// }
	//
	// }
	// return -1;
	// }
	// v5 : just like linked_list_cycle_ II
	// (https://discuss.leetcode.com/topic/25913/my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation/2)
	// public static int findDuplicate(int[] nums) {
	// if(nums == null || nums.length <= 1) {
	// return -1;
	// }
	// int fast = nums[nums[0]];
	// int slow = nums[0];
	// while (fast != slow) {
	// slow = nums[slow];
	// fast = nums[nums[fast]];
	// }
	// fast = 0;
	// while (fast != slow ) {
	// fast = nums[fast];
	// slow = nums[slow];
	// }
	// return fast;
	// }
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 3, 4, 5 };
		int[] c = new int[] { 1, 2, 2 };
		int res = findDuplicate(c);
		System.out.println(res);
		// System.out.println(Arrays.toString(args));

	}
}
