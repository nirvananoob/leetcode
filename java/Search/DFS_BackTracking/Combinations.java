package Search.DFS_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * Example For example, If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * 
 * 
 * @author kaizhang
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs(res, list, n, k);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> list, int n, int k) {
		if (list.size() == k) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1; i <= n; i++) {
			list.add(i);
			dfs(res, list, n, k);
			list.remove(list.size() - 1);
		}
		
		return;
	}
}
