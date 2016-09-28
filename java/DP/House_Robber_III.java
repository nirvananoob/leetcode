package DP;
import tree.TreeNode;
public class House_Robber_III {
	/**
	 * The thief has found himself a new place for his thievery again. There is
	 * only one entrance to this area, called the "root." Besides the root, each
	 * house has one and only one parent house. After a tour, the smart thief
	 * realized that "all houses in this place forms a binary tree". It will
	 * automatically contact the police if two directly-linked houses were
	 * broken into on the same night.
	 * 
	 * Determine the maximum amount of money the thief can rob tonight without
	 * alerting the police.
	 * 
	 * 
	 * Example   3 
	 * 			/ \ 
	 * 			2 3 
	 * 			 \ \ 
	 * 			  3 1
	 * RETURN 7
	 */
	/**
	 * Definition of TreeNode:
	 * public class TreeNode {
	 *     public int val;
	 *     public TreeNode left, right;
	 *     public TreeNode(int x) { val = x; }
	 * }
	 */
	 public int houseRobber3(TreeNode root) {
	        int[] ans = dp(root);
	        return Math.max(ans[0], ans[1]);
	    }
	    public int[] dp(TreeNode root) {
	        if (root == null) {
	            int[] now = new int[]{0, 0};
	            return now;
	        }
	        int[] left = dp(root.left);
	        int[] right = dp(root.right);
	        int[] now = new int[2];
	        now[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	        now[1] = left[0] + right[0] + root.val;
	        return now;
	    }
}
