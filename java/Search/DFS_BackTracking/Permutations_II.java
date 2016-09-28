package Search.DFS_BackTracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a list of numbers with duplicate number in it. Find all unique
 * permutations.
 * 
 * 
 * Example For numbers [1,2,2] the unique permutations are:
 * 
 * [ [1,2,2], [2,1,2], [2,2,1] ]
 * 
 * @author kaizhang
 *
 */
public class Permutations_II {
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		// write your code here
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return rst;
		}
		int[] visited = new int[nums.size()];
		Collections.sort(nums);
		ArrayList<Integer> list = new ArrayList<Integer>();
		dfs(rst, list, nums, visited);
		return rst;
	}

	private void dfs(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, ArrayList<Integer> nums, int[] visited) {
		if (list.size() == nums.size()) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
//		 long pre = Long.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			if (visited[i] == 1 || i != 0 && nums.get(i) == nums.get(i - 1)
					&& visited[i - 1] == 0) {

				continue;
			}
			int n = nums.get(i);
			//v2 : use a variable pre to avoid duplication 
//			if (visited[i] == 1|| pre == n){
//				continue;
//			}
//			pre = n;
			visited[i] = 1;
			list.add(nums.get(i));
			dfs(res, list, nums, visited);
			list.remove(list.size() - 1);
			visited[i] = 0;
		}
		return;
	}

	public static void main(String[] args) {
		Permutations_II test = new Permutations_II();
		int[] arr = { 1, 2, 2 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int cur : arr) {
			list.add(cur);
		}
		System.out.println(test.permuteUnique(list));
	}
}
