package tree;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Follow up: Could you do it using only constant space complexity?
 * 
 * @author kaizhang
 *
 */
public class Verify_Preorder_Sequence_in_Binary_Search_Tree {
	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0 || preorder.length == 1) {
			return true;
		}
		Stack<Integer> s = new Stack<Integer>();
		int cur = 1;
		s.push(preorder[0]);
		int min = Integer.MIN_VALUE;
		while (true) {
			while (cur < preorder.length && preorder[cur] < preorder[cur - 1]) {
				if (preorder[cur] < min) {
					return false;
				}
				s.push(preorder[cur]);
				cur++;
			}
			while (!s.isEmpty() && cur < preorder.length
					&& preorder[cur] > s.peek()) {
				int temp = s.pop();
				if (temp <= min) {
					return false;
				}
				min = temp;
			}
			if (cur == preorder.length) {
				return true;
			}
			s.push(preorder[cur]);
			cur++;
		}

	}

	// follow up :constant space
	public boolean verifyPreorder_followup(int[] preorder) {

		if (preorder == null || preorder.length < 2) {
			return true;
		}

		int min = -1;
		int max = 0;
		int cur = 1;
		while (cur < preorder.length) {
			int val = preorder[cur];
			if (min != -1 && val <= preorder[min]) {
				return false;
			}
			if (val > preorder[max]) {
				min = max;
				max = cur;
			} else if (val > preorder[cur - 1]) {
				if (min == -1) {
					min = cur - 1;
				}
				while (min > 0 && val > preorder[min - 1]) {
					min--;
				}

			}
			++cur;
		}
		return true;

	}
}
