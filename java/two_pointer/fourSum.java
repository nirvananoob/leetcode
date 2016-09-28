package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: The solution set must not contain duplicate quadruplets.
	 * 
	 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	 * 
	 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		int left, right, sum;
		for (int i = 0; i < nums.length - 3; i++) {
//			if (nums[i] > target) {
//				break;
//			}
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
//				if (nums[j] > target) {
//					break;
//				}
				if (j != i +1 && nums[j] == nums[j - 1]) {
					continue;
				}
				left = j + 1;
				right = nums.length - 1;
				while (left < right) {
					while (left < right && left != j + 1
							&& nums[left] == nums[left - 1]) {
						++left;
					}
					while (left < right && right != nums.length - 1
							&& nums[right] == nums[right + 1]) {
						++right;
					}
					sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left],
								nums[right]));
						++left;
						--right;
					} else if (sum < target) {
						++left;
					} else {
						--right;
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		fourSum test= new fourSum ();
		int[] arr = {3,1,4,2,5,-4,2,4,-5
				};
		System.out.println(test.fourSum(arr, -12).toString());
	}
}
