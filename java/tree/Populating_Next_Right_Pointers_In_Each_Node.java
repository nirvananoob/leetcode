package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode
 * *next; }
 */
/**
 * Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author kaizhang
 *
 */
public class Populating_Next_Right_Pointers_In_Each_Node {
	public void connect(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		// root.next = null;
		TreeNode cur = null;
		TreeNode pre = null;
		while (!queue.isEmpty()) {
			pre = null;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				cur = queue.poll();
				if (pre != null) {
					pre.next = cur;

				}
				pre = cur;
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			cur.next = null;
		}
		return;

	}
	//O(1)extra space
	public void connect_better(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode parent = root;
        TreeNode next = parent.left;
        while (parent != null && next != null) {
            TreeNode prev = null;
            while (parent != null) {
                if (prev == null) {
                    prev = parent.left;
                } else {
                    prev.next = parent.left;
                    prev = prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
            }
            parent = next;
            next = parent.left;
        }
    }
}
