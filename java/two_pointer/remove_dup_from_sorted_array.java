package two_pointer;

public class remove_dup_from_sorted_array {
	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int size = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[size]) {
				nums[++size] = nums[i];
			}
		}
		return size + 1;
	}

	/**
	 * follow up: Follow up for "Remove Duplicates": What if duplicates are
	 * allowed at most twice?
	 * 
	 * For example, Given sorted array A = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
	 */
	public int removeDuplicates_follow_up(int[] nums) {
		// write your code here
		if (nums == null)
			return 0;
		int cur = 0;
		int i, j;
		for (i = 0; i < nums.length;) {
			int now = nums[i];
			for (j = i; j < nums.length; j++) {
				if (nums[j] != now)
					break;
				if (j - i < 2)
					nums[cur++] = now;
			}
			i = j;
		}
		return cur;
	}

	
	public static void main(String[] args) {
		int[] arr = {-8,0,1,2,3};
		System.out.println( removeDuplicates(arr));
	}
}
