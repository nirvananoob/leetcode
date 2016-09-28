package two_pointer;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Notice
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * @author kaizhang
 *
 */
public class move_zeros {
	/**
	 * @param nums
	 *            an integer array
	 * @return nothing, do this in-place
	 */
	// v1
	public void moveZeroes(int[] nums) {
		// // Write your code here
		// if (nums == null || nums.length == 0) {
		// return ;
		// }
		// int index1 = 0;
		// int index2;
		// // int count == 0 ;
		// while (index1 < nums.length ){
		// //find first zero

		// while(index1 < nums.length && nums[index1] != 0 ){
		// ++index1;
		// }

		// //find first non-zero
		// index2 = index1;
		// while(index2 < nums.length && nums[index2] == 0){
		// ++index2;
		// }
		// if (index2 == nums.length) {
		// break;
		// }
		// swap(nums, index1, index2);
		// if (index2 == nums.length - 1) {
		// break;
		// }
		// ++index1;

		// }
		// return;
		// }
		// private void swap(int[] arr, int i , int j) {
		// int temp = arr[i];
		// arr[i] = arr[j];
		// arr[j] = temp;
		// }
		// v2 best solution..
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		for (; j < nums.length; j++) {
			nums[j] = 0;
		}
		return;

	}

}
