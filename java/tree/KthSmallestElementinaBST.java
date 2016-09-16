package tree;

import java.util.Map.Entry;
import java.util.Stack;

public class KthSmallestElementinaBST {
	
	public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        int count = 0;
        Stack<TreeNode> s = new Stack<TreeNode> ();
        TreeNode cur = root;
        TreeNode prev = null;
        while (!s.isEmpty() && cur != null) {
            if (count == k) {
                return prev.val;
            }
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
             prev = s.pop();
            if (prev.right != null) {
                cur = prev.right;
            }
            count ++;
        }
        return -1;
    }
	public int kthSmallestRec(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
       int leftcount = count(root.left);
       if (leftcount + 1 == k ) {
    	   return root.val;
       }else if(leftcount + 1 < k) {
    	   return kthSmallestRec(root.right, k - leftcount - 1);
       }else {
    	   return kthSmallestRec(root.left, k);
       }
    }
	private int count (TreeNode root) {
		if(root == null) {
			return 0;
		}
		return count(root.left) + count(root.right) + 1;
	}
	
}
