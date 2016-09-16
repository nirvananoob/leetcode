package Search.DFS_BackTracking;

import java.util.ArrayList;

/**
 * Given a list of numbers, return all possible permutations.
 * 
 * 
 * Example For nums = [1,2,3], the permutations are:
 * 
 * [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author kaizhang
 *
 */
public class Permutations_I {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> num) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.size() == 0) {
			return rst;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(rst, list, num);
		return rst;
	}

	public void helper(ArrayList<ArrayList<Integer>> rst,
			ArrayList<Integer> list, ArrayList<Integer> num) {
		if (list.size() == num.size()) {
			rst.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.size(); i++) {
			if (list.contains(num.get(i))) {
				continue;
			}
			list.add(num.get(i));
			helper(rst, list, num);
			list.remove(list.size() - 1);
		}

	}
}
