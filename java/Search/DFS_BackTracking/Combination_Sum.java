package Search.DFS_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2, 3]]
 * 
 * @author kaizhang
 *
 */
public class Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<Integer>();
		helper(res, list, candidates, target, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list,
			int[] nums, int target, int index) {
		// if (target < 0 || nums[index] > target) {
		// return;
		// }
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = index; i < nums.length && nums[i] <= target; i++) {
			list.add(nums[i]);
			helper(res, list, nums, target - nums[i], i);
			list.remove(list.size() - 1);
			
		}
	}
	public static void main(String[] args) {
		Combination_Sum test = new Combination_Sum();
		int[] arr = new int[]{2,6,3,7};
		int target = 7;
		System.out.println(test.combinationSum(arr, target));
	}
}
