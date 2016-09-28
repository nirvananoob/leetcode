package two_pointer;

/**
 * Partition an integers array into odd number first and even number second.
 * 
 * 
 * Example Given [1, 2, 3, 4], return [1, 3, 2, 4]
 * 
 * Challenge Do it in-place.
 * 
 * @author kaizhang
 *
 */
public class partition_array_by_odd_and_even {
	public void partitionArray(int[] nums) {
		if (nums == null) {
			return;
		}
		int cur = 0;
		int even = nums.length - 1;
		while (cur < even) {
			while (cur < even && nums[cur] % 2 == 1) {
				cur++;
			}
			while (cur < even && nums[even] % 2 == 0) {
				even--;
			}
			if (cur < even) {
				int temp = nums[even];
				nums[even] = nums[cur];
				nums[cur] = temp;
				cur++;
				even--;

			}
		}
		return;
	}

}
