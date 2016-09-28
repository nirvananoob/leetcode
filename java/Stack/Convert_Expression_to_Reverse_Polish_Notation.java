package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Convert_Expression_to_Reverse_Polish_Notation {
	class ExpressionTreeNode {
		String symbol;
		int val;
		ExpressionTreeNode left;
		ExpressionTreeNode right;

		public ExpressionTreeNode(String s, int v) {
			this.symbol = s;
			this.val = v;
		}
	}

	public ArrayList<String> convertToRPN(String[] expression) {
		// write your code here
		ExpressionTreeNode root = buildTree(expression);
		ArrayList<String> res = new ArrayList<String>();
		postorder(root, res);
		return res;
	}

	// public ArrayList<String> convertToPN(String[] expression) {
	// // write your code here
	// ExpressionTreeNode root = buildTree(expression);
	// ArrayList<String> res = new ArrayList<String> ();
	// preorder(root,res);
	// return res;
	// }
	private void postorder(ExpressionTreeNode root, ArrayList<String> res) {
		if (root == null) {
			return;
		}
		Stack<ExpressionTreeNode> pre = new Stack<ExpressionTreeNode>();
		Stack<String> post = new Stack<String>();
		ExpressionTreeNode cur = root;
		pre.push(root);
		while (!pre.isEmpty()) {
			ExpressionTreeNode tmp = pre.pop();
			post.push(tmp.symbol);
			if (tmp.left != null) {
				pre.push(tmp.left);
			}
			if (tmp.right != null) {
				pre.push(tmp.right);
			}
		}
		while (!post.isEmpty()) {
			res.add(post.pop());
		}
		return;

	}

	// private void preorder( ExpressionTreeNode root, ArrayList<String> res) {
	// if(root == null) {
	// return;
	// }
	// Stack<ExpressionTreeNode> s = new Stack<ExpressionTreeNode> ();
	// s.push(root);
	// while(!s.isEmpty()) {
	// ExpressionTreeNode temp = s.pop();
	// res.add(temp.symbol);
	// if(temp.right != null){
	// s.push(temp.right);
	// }
	// if(temp.left != null) {
	// s.push(temp.left);
	// }
	// }
	// return;
	// }
	private ExpressionTreeNode buildTree(String[] expression) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("dummy", 0);
		map.put("+", 1);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 2);
		// return TreeNodehelper(expression, 0, expression.length - 1);
		Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
		int carry = 0;
		for (int i = 0; i <= expression.length; i++) {
			String temp = i == expression.length ? "dummy" : expression[i];
			if (i != expression.length) {
				if (expression[i].equals("(")) {
					carry += 10;
					continue;
				} else if (expression[i].equals(")")) {
					carry -= 10;
					continue;
				}
			}
			int val = carry;
			if (map.containsKey(temp)) {
				val += map.get(temp);
			} else {
				val = Integer.MAX_VALUE;
			}
			ExpressionTreeNode cur = new ExpressionTreeNode(temp, val);
			while (!stack.isEmpty()) {
				ExpressionTreeNode pre = stack.peek();
				if (pre.val < cur.val) {
					break;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						cur.left = pre;
					} else {
						if (stack.peek().val >= cur.val) {
							stack.peek().right = pre;
						} else {
							cur.left = pre;
						}
					}
				}
			}
			stack.push(cur);
		}
		return stack.peek().left;
	}

	public static void main(String[] args) {
		String[] expression = new String[] { "3", "-", "4", "+", "5" };
		Convert_Expression_to_Reverse_Polish_Notation test = new Convert_Expression_to_Reverse_Polish_Notation();
		System.out.println(test.convertToRPN(expression).toString());
	}
}
