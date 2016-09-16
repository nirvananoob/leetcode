package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeDemo {
	// 前序遍历递归
	public List<Integer> preorderTraversalrec(TreeNode root) {

		List<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}
		list.add(root.val);
		list.addAll(preorderTraversalrec(root.left));
		list.addAll(preorderTraversalrec(root.right));
		return list;
	}

	// 前序遍历迭代
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode t = s.pop();
			list.add(t.val);
			if (t.right != null) {
				s.push(t.right);
			}
			if (t.left != null) {
				s.push(t.left);
			}
		}
		return list;

	}

	// 中序遍历递归
	public List<Integer> inorderTraversalrec(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(inorderTraversalrec(root.left));
		list.add(root.val);
		list.addAll(inorderTraversalrec(root.left));
		return list;
	}

	// 中序遍历迭代
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		while (!s.isEmpty() || cur != null) {
			if (cur != null) {
				s.push(cur);
				cur = cur.left;
			} else {//
				cur = s.pop();
				list.add(cur.val);
				cur = cur.right;
			}
		}
		return list;
	}

	// 后序遍历递归
	public List<Integer> postorderTraversalrec(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		list.addAll(postorderTraversalrec(root.left));
		list.addAll(postorderTraversalrec(root.right));
		list.add(root.val);
		return list;

	}

	// 后序遍历迭代1 * 从左到右的后序 与从右到左的前序的逆序是一样的,用另外一个栈进行翻转即可
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<Integer> o = new Stack<Integer>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode t = s.pop();
			o.push(t.val);
			if (t.left != null) {
				s.push(t.left);
			}
			if (t.right != null) {
				s.push(t.right);
			}
		}
		while (!o.isEmpty()) {
			list.add(o.pop());
		}
		return list;
	}

	// 后序遍历迭代2 up,down 分析
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		// v1
		// Stack<TreeNode> s = new Stack<TreeNode> ();
		// Stack<Integer> o = new Stack<Integer> ();
		// s.push(root);
		// while(!s.isEmpty()) {
		// TreeNode t = s.pop();
		// o.push(t.val);
		// if(t.left != null) {
		// s.push(t.left);
		// }
		// if(t.right != null) {
		// s.push(t.right);
		// }
		// }
		// while(!o.isEmpty()) {
		// list.add(o.pop());
		// }
		// return list;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode prev = null;
		s.push(root);
		while (!s.isEmpty()) {
			// down
			cur = s.peek();
			if (prev == null || cur == prev.left || cur == prev.right) {

				if (cur.left != null) {
					s.push(cur.left);
				} else if (cur.right != null) {
					s.push(cur.right);
				}
			}
			// up from left side
			else if (prev == cur.left) {
				if (cur.right != null) {
					s.push(cur.right);
				}

			}
			// up from right
			else {
				list.add(cur.val);
				s.pop();
			}
			prev = cur;

		}
		return list;

	}

	// 层序遍历bfs
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
				list.add(temp.val);
			}
			res.add(list);
		}
		return res;
	}

	// 层序遍历递归（dfs）
	public List<List<Integer>> levelTraversalRec(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		levelTraversalVisit(root, 0, ret);
		return ret;
	}

	/**
	 * 分层遍历二叉树（递归） 很少有人会用递归去做level traversal
	 * 基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。 大的ArrayList的size和level有关系
	 * 
	 * http://discuss.leetcode.com/questions/49/binary-tree-level-order-
	 * traversal#answer-container-2543
	 */
	public static void levelTraversalVisit(TreeNode root, int level,
			List<List<Integer>> ret) {
		if (root == null) {
			return;
		}

		// 如果ArrayList的层数不够用， 则新添加一层
		// when size = 3, level: 0, 1, 2
		if (level >= ret.size()) { 
			ret.add(new ArrayList<Integer>());
		}

		// visit 当前节点
		ret.get(level).add(root.val);

		// 将左子树， 右子树添加到对应的层。
		levelTraversalVisit(root.left, level + 1, ret);
		levelTraversalVisit(root.right, level + 1, ret);
	}

	// 求node 个数 递归
	public int getNodeNumRec(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
	}

	// 求node 个数迭代
	public int getNodeNum(TreeNode root) {
		int sum = 0;
		if (root == null) {
			return sum;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {

			TreeNode temp = queue.poll();
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
			sum++;
		}
		return sum;
	}

	// 求深度递归
	public int getDepthRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftdepth = getDepthRec(root.left);
		int rightdepth = getDepthRec(root.right);
		return Math.max(leftdepth, rightdepth) + 1;
	}

	// 求深度迭代
	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();

				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}

			}
		}
		return cnt;
	}

	// 求二叉树第K层的节点个数：getNodeNumKthLevelRec
	public int getNodeNumKthLevel(TreeNode root, int k) {
		if (root == null || k <= 0) {
			return 0;
		}

		int level = 0;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		TreeNode dummy = new TreeNode(0);
		int cnt = 0; // record the size of the level.

		q.offer(dummy);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node == dummy) {
				level++;
				if (level == k) {
					return cnt;
				}
				cnt = 0; // reset the cnt;
				if (q.isEmpty()) {
					break;
				}
				q.offer(dummy);
				continue;
			}

			cnt++;
			if (node.left != null) {
				q.offer(node.left);
			}

			if (node.right != null) {
				q.offer(node.right);
			}
		}

		return 0;
	}

	/*
	 * * 6. 求二叉树第K层的节点个数：, getNodeNumKthLevel
	 */
	public  int getNodeNumKthLevelRec(TreeNode root, int k) {
		if (root == null || k <= 0) {
			return 0;
		}

		if (k == 1) {
			return 1;
		}

		// 将左子树及右子树在K层的节点个数相加.
		return getNodeNumKthLevelRec(root.left, k - 1)
				+ getNodeNumKthLevelRec(root.right, k - 1);
	}

	/*
	 * 7. getNodeNumLeafRec 把左子树和右子树的叶子节点加在一起即可
	 */
	public  int getNodeNumLeafRec(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
	}

	/*
	 * 7. getNodeNumLeaf 随便使用一种遍历方法都可以，比如，中序遍历。 inorderTraversal，判断是不是叶子节点。
	 */
	public int getNodeNumLeaf(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int cnt = 0;

		// we can use inorderTraversal travesal to do it.
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;

		while (true) {
			while (cur != null) {
				s.push(cur);
				cur = cur.left;
			}

			if (s.isEmpty()) {
				break;
			}

			// all the left child has been put into the stack, let's deal with
			// the
			// current node.
			cur = s.pop();
			if (cur.left == null && cur.right == null) {
				cnt++;
			}
			cur = cur.right;
		}

		return cnt;
	}

	/*
	 * 8. 判断两棵二叉树是否相同的树。 递归解法： （1）如果两棵二叉树都为空，返回真 （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
	 * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
	 */
	public  boolean isSameRec(TreeNode r1, TreeNode r2) {
		// both are null.
		if (r1 == null && r2 == null) {
			return true;
		}

		// one is null.
		if (r1 == null || r2 == null) {
			return false;
		}

		// 1. the value of the root should be the same;
		// 2. the left tree should be the same.
		// 3. the right tree should be the same.
		return r1.val == r2.val && isSameRec(r1.left, r2.left)
				&& isSameRec(r1.right, r2.right);
	}

	// * 8. 判断两棵二叉树是否相同的树。
	// * 迭代解法
	// * 我们直接用中序遍历来比较就好啦
	// * */
	public boolean isSame(TreeNode r1, TreeNode r2) {
		// both are null.
		if (r1 == null && r2 == null) {
			return true;
		}

		// one is null.
		if (r1 == null || r2 == null) {
			return false;
		}

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		TreeNode cur1 = r1;
		TreeNode cur2 = r2;

		while (true) {
			while (cur1 != null && cur2 != null) {
				s1.push(cur1);
				s2.push(cur2);
				cur1 = cur1.left;
				cur2 = cur2.left;
			}

			if (cur1 != null || cur2 != null) {
				return false;
			}

			if (s1.isEmpty() && s2.isEmpty()) {
				break;
			}

			cur1 = s1.pop();
			cur2 = s2.pop();
			if (cur1.val != cur2.val) {
				return false;
			}

			cur1 = cur1.right;
			cur2 = cur2.right;
		}

		return true;
	}
	/*
	 * 
	 *  9. 判断二叉树是不是平衡二叉树：isAVLRec
	 *     1. 左子树，右子树的高度差不能超过1
	 *     2. 左子树，右子树都是平衡二叉树。 
	 *      
	 */
	    public  boolean isAVLRec(TreeNode root) {
	        if (root == null) {
	            return true;
	        }
	        
	        // 左子树，右子树都必须是平衡二叉树。 
	        if (!isAVLRec(root.left) || !isAVLRec(root.right)) {
	            return false;
	        }
	        
	        int dif = Math.abs(getDepthRec(root.left) - getDepthRec(root.right));
	        if (dif > 1) {
	            return false;
	        }
	        
	        return true;
	    }
    /** 
     * 10. 求二叉树的镜像 递归解法：
     * 
     *   (1) 破坏原来的树
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     * */  
    public  TreeNode mirrorRec(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        // 先把左右子树分别镜像,并且交换它们
        TreeNode tmp = root.right;
        root.right = mirrorRec(root.left);
        root.left = mirrorRec(tmp);
        
        return root;
    }  
    
    /** 
     * 10. 求二叉树的镜像 Iterator解法：
     * 
     *   (1) 破坏原来的树
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     *      
     *  应该可以使用任何一种Traversal 方法。 
     *  我们现在可以试看看使用最简单的前序遍历。
     * */  
    public  TreeNode mirror(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            
            // 交换当前节点的左右节点
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            
            // traversal 左节点，右节点。
            if (cur.right != null) {
                s.push(cur.right);
            }
            
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        
        return root;
    }  
    
    /** 
     * 10. 求二叉树的镜像 Iterator解法：
     * 
     *   (2) 创建一个新的树
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     *      
     *  应该可以使用任何一种Traversal 方法。 
     *  我们现在可以试看看使用最简单的前序遍历。
     *  前序遍历我们可以立刻把新建好的左右节点创建出来，比较方便 
     * */  
    public  TreeNode mirrorCopy(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> sCopy = new Stack<TreeNode>();
        s.push(root);
        
        TreeNode rootCopy = new TreeNode(root.val);
        sCopy.push(rootCopy);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            TreeNode curCopy = sCopy.pop();
            
            // traversal 左节点，右节点。
            if (cur.right != null) {
                
                // copy 在这里做比较好，因为我们可以容易地找到它的父节点
                TreeNode leftCopy = new TreeNode(cur.right.val);
                curCopy.left = leftCopy;
                s.push(cur.right);
                sCopy.push(curCopy.left);
            }
            
            if (cur.left != null) {
                // copy 在这里做比较好，因为我们可以容易地找到它的父节点
                TreeNode rightCopy = new TreeNode(cur.left.val);
                curCopy.right = rightCopy;
                s.push(cur.left);
                sCopy.push(curCopy.right);
            }
        }
        
        return rootCopy;
    }  
    
    /** 
     * 10. 求二叉树的镜像 递归解法：
     * 
     *   (1) 不破坏原来的树，新建一个树 
     *   
     *      1               1
     *     /                 \
     *    2     ----->        2
     *     \                 /
     *      3               3
     * */  
    public  TreeNode mirrorCopyRec(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        // 先把左右子树分别镜像,并且把它们连接到新建的root节点。
        TreeNode rootCopy = new TreeNode(root.val);
        rootCopy.left = mirrorCopyRec(root.right);
        rootCopy.right = mirrorCopyRec(root.left);
        
        return rootCopy;
    }  

	/*
	 * 10.1. 判断两个树是否互相镜像 (1) 根必须同时为空，或是同时不为空
	 * 
	 * 如果根不为空: (1).根的值一样 (2).r1的左树是r2的右树的镜像 (3).r1的右树是r2的左树的镜像
	 */
	public  boolean isMirrorRec(TreeNode r1, TreeNode r2) {
		// 如果2个树都是空树
		if (r1 == null && r2 == null) {
			return true;
		}

		// 如果其中一个为空，则返回false.
		if (r1 == null || r2 == null) {
			return false;
		}

		// If both are not null, they should be:
		// 1. have same value for root.
		// 2. R1's left tree is the mirror of R2's right tree;
		// 3. R2's right tree is the mirror of R1's left tree;
		return r1.val == r2.val && isMirrorRec(r1.left, r2.right)
				&& isMirrorRec(r1.right, r2.left);
	}

	/*
	 * 10.1. 判断两个树是否互相镜像 Iterator 做法 (1) 根必须同时为空，或是同时不为空
	 * 
	 * 如果根不为空: traversal 整个树，判断它们是不是镜像，每次都按照反向来traversal (1). 当前节点的值相等 (2).
	 * 当前节点的左右节点要镜像， 无论是左节点，还是右节点，对应另外一棵树的镜像位置，可以同时为空，或是同时不为空，但是不可以一个为空，一个不为空。
	 */
	public  boolean isMirror(TreeNode r1, TreeNode r2) {
		// 如果2个树都是空树
		if (r1 == null && r2 == null) {
			return true;
		}

		// 如果其中一个为空，则返回false.
		if (r1 == null || r2 == null) {
			return false;
		}

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		s1.push(r1);
		s2.push(r2);

		while (!s1.isEmpty() && !s2.isEmpty()) {
			TreeNode cur1 = s1.pop();
			TreeNode cur2 = s2.pop();

			// 弹出的节点的值必须相等
			if (cur1.val != cur2.val) {
				return false;
			}

			// tree1的左节点，tree2的右节点，可以同时不为空，也可以同时为空，否则返回false.
			TreeNode left1 = cur1.left;
			TreeNode right1 = cur1.right;
			TreeNode left2 = cur2.left;
			TreeNode right2 = cur2.right;

			if (left1 != null && right2 != null) {
				s1.push(left1);
				s2.push(right2);
			} else if (!(left1 == null && right2 == null)) {
				return false;
			}

			// tree1的左节点，tree2的右节点，可以同时不为空，也可以同时为空，否则返回false.
			if (right1 != null && left2 != null) {
				s1.push(right1);
				s2.push(left2);
			} else if (!(right1 == null && left2 == null)) {
				return false;
			}
		}

		return true;
	}
	   /*
     * 11. 求二叉树中两个节点的最低公共祖先节点：
     * Recursion Version:
     * LACRec 
     * 1. If found in the left tree, return the Ancestor.
     * 2. If found in the right tree, return the Ancestor.
     * 3. If Didn't find any of the node, return null.
     * 4. If found both in the left and the right tree, return the root.
     * */
    public static TreeNode LACRec(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        
        // If any of the node is the root, just return the root.
        if (root == node1 || root == node2) {
            return root;
        }
        
        // if no node is in the node, just recursively find it in LEFT and RIGHT tree.
        TreeNode left = LACRec(root.left, node1, node2);
        TreeNode right = LACRec(root.right, node1, node2);
        
        if (left == null) {  // If didn't found in the left tree, then just return it from right.
            return right;
        } else if (right == null) { // Or if didn't found in the right tree, then just return it from the left side.
            return left;
        } 
        
        // if both right and right found a node, just return the root as the Common Ancestor.
        return root;
    }
    
    /*
     * 11. 求BST中两个节点的最低公共祖先节点：
     * Recursive version:
     * LCABst 
     * 
     * 1. If found in the left tree, return the Ancestor.
     * 2. If found in the right tree, return the Ancestor.
     * 3. If Didn't find any of the node, return null.
     * 4. If found both in the left and the right tree, return the root.
     * */
    public static TreeNode LCABstRec(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        
        // If any of the node is the root, just return the root.
        if (root == node1 || root == node2) {
            return root;
        }
        
        int min = Math.min(node1.val, node2.val);
        int max = Math.max(node1.val, node2.val);
        
        // if the values are smaller than the root value, just search them in the left tree.
        if (root.val > max) {
            return LCABstRec(root.left, node1, node2);
        } else if (root.val < min) {
        // if the values are larger than the root value, just search them in the right tree.    
            return LCABstRec(root.right, node1, node2);
        }
        
        // if root is in the middle, just return the root.
        return root;
    }
    
    /*
     * 解法1. 记录下path,并且比较之:
     * LAC
     * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
     * */
    public static TreeNode LCA(TreeNode root, TreeNode r1, TreeNode r2) {
        // If the nodes have one in the root, just return the root.
        if (root == null || r1 == null || r2 == null) {
            return null;
        }
        
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
        
        boolean find1 = LCAPath(root, r1, list1);
        boolean find2 = LCAPath(root, r2, list2);
        
        // If didn't find any of the node, just return a null.
        if (!find1 || !find2) {
            return null;
        }
        
        // 注意: 使用Iterator 对于linkedlist可以提高性能。
        // 所以 统一使用Iterator 来进行操作。
        Iterator<TreeNode> iter1 = list1.iterator();
        Iterator<TreeNode> iter2 = list2.iterator();
        
        TreeNode last = null;
        while (iter1.hasNext() && iter2.hasNext()) {
            TreeNode tmp1 = iter1.next();
            TreeNode tmp2 = iter2.next();
            
            if (tmp1 != tmp2) {
                return last;
            }
            
            last = tmp1;
        }
        
        // If never find any node which is different, means Node 1 and Node 2 are the same one.
        // so just return the last one.
        return last;
    }
    
    public static boolean LCAPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        // if didn't find, we should return a empty path.
        if (root == null || node == null) {
            return false;
        }
        
        // First add the root node.
        path.add(root);
        
        // if the node is in the left side.
        if (root != node 
                && !LCAPath(root.left, node, path)
                && !LCAPath(root.right, node, path)
                ) {
            // Didn't find the node. should remove the node added before.
            path.remove(root);
            return false;
        }
        
        // found
        return true;
    }
    /*
     *  * 12. 求二叉树中节点的最大距离：getMaxDistanceRec
     *  
     *  首先我们来定义这个距离：
     *  距离定义为：两个节点间边的数目.
     *  如：
     *     1
     *    / \
     *   2   3
     *        \
     *         4
     *   这里最大距离定义为2，4的距离，为3.      
     * 求二叉树中节点的最大距离 即二叉树中相距最远的两个节点之间的距离。 (distance / diameter) 
     * 递归解法：
     * 返回值设计：
     * 返回1. 深度， 2. 当前树的最长距离  
     * (1) 计算左子树的深度，右子树深度，左子树独立的链条长度，右子树独立的链条长度
     * (2) 最大长度为三者之最：
     *    a. 通过根节点的链，为左右深度+2
     *    b. 左子树独立链
     *    c. 右子树独立链。
     * 
     * (3)递归初始条件：
     *   当root == null, depth = -1.maxDistance = -1;
     *   
     */  
    public static int getMaxDistanceRec(TreeNode root) {
        return getMaxDistanceRecHelp(root).maxDistance;
    }
    
    public static Result getMaxDistanceRecHelp(TreeNode root) {
        Result ret = new Result(-1, -1);
        
        if (root == null) {
            return ret;
        }
        
        Result left = getMaxDistanceRecHelp(root.left);
        Result right = getMaxDistanceRecHelp(root.right);
        
        // 深度应加1， the depth from the subtree to the root.
        ret.depth = Math.max(left.depth, right.depth) + 1;
        
        // 左子树，右子树与根的距离都要加1，所以通过根节点的路径为两边深度+2
        int crossLen = left.depth + right.depth + 2;
        
        // 求出cross根的路径，及左右子树的独立路径，这三者路径的最大值。
        ret.maxDistance = Math.max(left.maxDistance, right.maxDistance);
        ret.maxDistance = Math.max(ret.maxDistance, crossLen);
        
        return ret;
    }

    
    private static class Result {
        int depth;
        int maxDistance;
        public Result(int depth, int maxDistance) {
            this.depth = depth;
            this.maxDistance = maxDistance;
        }
    }
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        TreeNode dummyNode = new TreeNode(0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        q.offer(dummyNode);
        
        // if this is true, no node should have any child.
        boolean noChild = false;
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == dummyNode) {
                if (!q.isEmpty()) {
                    q.offer(dummyNode);
                }
                // Dummy node不需要处理。 
                continue;
            }
            
            if (cur.left != null) {
                // 如果标记被设置，则Queue中任何元素不应再有子元素。
                if (noChild) {
                    return false;
                }
                q.offer(cur.left);
            } else {
                // 一旦某元素没有左节点或是右节点，则之后所有的元素都不应有子元素。
                // 并且该元素不可以有右节点.
                noChild = true;
            }
            
            if (cur.right != null) {
                // 如果标记被设置，则Queue中任何元素不应再有子元素。
                if (noChild) {
                    return false;
                }
                q.offer(cur.right);
            } else {
                // 一旦某元素没有左节点或是右节点，则之后所有的元素都不应有子元素。
                noChild = true;
            }
        }
        
        return true;
    }
    
    /*
     * 14. 判断二叉树是不是完全二叉树：isCompleteBinaryTreeRec
     * 
     * 
     *    我们可以分解为：
     *    CompleteBinary Tree 的条件是：
     *    1. 左右子树均为Perfect binary tree, 并且两者Height相同
     *    2. 左子树为CompleteBinaryTree, 右子树为Perfect binary tree，并且两者Height差1
     *    3. 左子树为Perfect Binary Tree,右子树为CompleteBinaryTree, 并且Height 相同
     *    
     *    Base 条件：
     *    (1) root = null: 为perfect & complete BinaryTree, Height -1;
     *    
     *    而 Perfect Binary Tree的条件：
     *    左右子树均为Perfect Binary Tree,并且Height 相同。
     * */
    
    public static boolean isCompleteBinaryTreeRec(TreeNode root) {
        return isCompleteBinaryTreeRecHelp(root).isCompleteBT;
    }
    
    private static class ReturnBinaryTree {
        boolean isCompleteBT;
        boolean isPerfectBT;
        int height;
        
        ReturnBinaryTree(boolean isCompleteBT, boolean isPerfectBT, int height) {
            this.isCompleteBT = isCompleteBT;
            this.isPerfectBT = isPerfectBT;
            this.height = height;
        }
    }
    
    /*
     * 我们可以分解为：
     *    CompleteBinary Tree 的条件是：
     *    1. 左右子树均为Perfect binary tree, 并且两者Height相同
     *    2. 左子树为CompleteBinaryTree, 右子树为Perfect binary tree，并且两者Height差1
     *    3. 左子树为Perfect Binary Tree,右子树为CompleteBinaryTree, 并且Height 相同
     *    
     *    Base 条件：
     *    (1) root = null: 为perfect & complete BinaryTree, Height -1;
     *    
     *    而 Perfect Binary Tree的条件：
     *    左右子树均为Perfect Binary Tree,并且Height 相同。
     * */
    public static ReturnBinaryTree isCompleteBinaryTreeRecHelp(TreeNode root) {
        ReturnBinaryTree ret = new ReturnBinaryTree(true, true, -1);
        
        if (root == null) {
            return ret;
        }
        
        ReturnBinaryTree left = isCompleteBinaryTreeRecHelp(root.left);
        ReturnBinaryTree right = isCompleteBinaryTreeRecHelp(root.right);
        
        // 树的高度为左树高度，右树高度的最大值+1
        ret.height = 1 + Math.max(left.height, right.height);
        
        // set the isPerfectBT
        ret.isPerfectBT = false;
        if (left.isPerfectBT && right.isPerfectBT && left.height == right.height) {
            ret.isPerfectBT = true;
        }
        
        // set the isCompleteBT.
        /*
         * CompleteBinary Tree 的条件是：
         *    1. 左右子树均为Perfect binary tree, 并且两者Height相同(其实就是本树是perfect tree)
         *    2. 左子树为CompleteBinaryTree, 右子树为Perfect binary tree，并且两者Height差1
         *    3. 左子树为Perfect Binary Tree,右子树为CompleteBinaryTree, 并且Height 相同
         * */
        ret.isCompleteBT = ret.isPerfectBT 
                || (left.isCompleteBT && right.isPerfectBT && left.height == right.height + 1)
                || (left.isPerfectBT && right.isCompleteBT && left.height == right.height);
        
        return ret;
    }
}
