package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
 * @author kaizhang
 *
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II {
	public void connect(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new  LinkedList<TreeNode> ();
        queue.offer(root);
        TreeNode cur = null;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++ ){
                cur = queue.poll();
                cur.next = i == size - 1? null : queue.peek();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return;
    }
	 public void connect_best(TreeNode root) {
	        if (root == null) {
	            return;
	        }

	        TreeNode parent = root;
	        TreeNode pre;
	        TreeNode next;
	        while (parent != null) {
	            pre = null;
	            next = null;
	            while (parent != null) {
	                if (next == null){
	                    next = (parent.left != null) ? parent.left: parent.right;
	                }

	                if (parent.left != null){
	                    if (pre != null) {
	                        pre.next = parent.left;
	                        pre = pre.next;
	                    } else {
	                        pre = parent.left;
	                    }
	                }

	                if (parent.right != null) {
	                    if (pre != null) {
	                        pre.next = parent.right;
	                        pre = pre.next;
	                    } else {
	                        pre = parent.right;
	                    }
	                }
	                parent = parent.next;
	            }
	            parent = next;
	        }
	    }
}
