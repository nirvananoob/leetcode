package Search;
import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;
public class Unique_Binary_Search_Tree_II {
	/**
	 * Given n, generate all structurally unique BST's (binary search trees)
	 * that store values 1...n.
	 * 
	 * Example Given n = 3, your program should return all 5 unique BST's shown
	 * below.
	 * 
	 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
	 */
	/**
	 * Definition of TreeNode: public class TreeNode { public int val; public
	 * TreeNode left, right; public TreeNode(int val) { this.val = val;
	 * this.left = this.right = null; } }
	 */

	/**
	 * @paramn n: An integer
	 * @return: A list of root
	 */
	// ans , 不会实现tat＝＝
	public List<TreeNode> generateTrees(int n) {
		// write your code here
		return dfs(1, n);
	}

	private List<TreeNode> dfs(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = dfs(start, i - 1);
			List<TreeNode> right = dfs(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode p = new TreeNode(i);
					p.left = l;
					p.right = r;
					list.add(p);
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		Unique_Binary_Search_Tree_II test = new Unique_Binary_Search_Tree_II();
		System.out.println(test.generateTrees(2).toString());
	}
}
