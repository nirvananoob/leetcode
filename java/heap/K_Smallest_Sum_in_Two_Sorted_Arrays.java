package heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Given two integer arrays sorted in ascending order and an integer k. Define
 * sum = a + b, where a is an element from the first array and b is an element
 * from the second one. Find the kth smallest sum out of all possible sums
 * 
 * @author kaizhang
 *
 */
public class K_Smallest_Sum_in_Two_Sorted_Arrays {
	/**
	 * @param A
	 *            an integer arrays sorted in ascending order
	 * @param B
	 *            an integer arrays sorted in ascending order
	 * @param k
	 *            an integer
	 * @return an integer
	 */
	/**
	 * 
	 * @author kaizhang override equals 及hashcode() 防止hashset.contains()报错！
	 */
//	class Node {
//		int x;
//		int y;
//		int val;
//
//		Node(int index1, int index2, int val) {
//			this.x = index1;
//			this.y = index2;
//			this.val = val;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (obj == this) {
//				return true;
//			}
//			if (!(obj instanceof Node)) {
//				return false;
//			}
//			Node temp = (Node) obj;
//			return temp.x == this.x && temp.y == this.y && temp.val == this.val;
//		}
//
//		@Override
//		public int hashCode() {
//			return x * 101 + y;
//		}
//	}
//
//	static Comparator<Node> comp = new Comparator<Node>() {
//		public int compare(Node n1, Node n2) {
//			if (n1.val != n2.val) {
//				return n1.val - n2.val;
//			} else if (n1.x != n2.x) {
//				return n1.x - n2.x;
//			} else {
//				return n1.y - n2.y;
//			}
//		}
//	};
//
//	public int kthSmallestSum(int[] A, int[] B, int k) {
//		// Write your code here
//		if (A == null || A.length == 0 || B == null || B.length == 0 || k <= 0) {
//			return -1;
//		}
//		PriorityQueue<Node> queue = new PriorityQueue<Node>(k, comp);
//		HashSet<Node> set = new HashSet<Node>();
//		int count = 0;
//		int pre = -1;
//		int row = A.length, col = B.length;
//		Node temp = new Node(0, 0, A[0] + B[0]);
//		queue.offer(temp);
//		set.add(temp);
//		while (count < k && !queue.isEmpty()) {
//			temp = queue.poll();
//			count++;
//			pre = temp.val;
//			if (temp.y + 1 < col) {
//				Node nextB = new Node(temp.x, temp.y + 1, A[temp.x]
//						+ B[temp.y + 1]);
//				if (!set.contains(nextB)) {
//					set.add(nextB);
//					queue.offer(nextB);
//				}
//			}
//			if (temp.x + 1 < row) {
//				Node nextA = new Node(temp.x + 1, temp.y, A[temp.x + 1]
//						+ B[temp.y]);
//				if (!set.contains(nextA)) {
//					set.add(nextA);
//					queue.offer(nextA);
//				}
//			}
//		}
//		return count == k ? pre : -1;
//	}
	class Node {
        int index1;
        int index2;
        int sum;
        public Node(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
        @Override
        public int hashCode ( ){
            return this.index1 * 298731 + index2;
        }
        @Override 
        public boolean equals(Object obj) {
            if(obj == this){
                return true;
            }
            if (!(obj instanceof Node)){
                return false;
            }
            Node temp = (Node)obj;
            return this.index1 == temp.index1 && this.index2 == temp.index2 && this.sum == temp.sum;
        }
        
    }
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if(A == null || B == null || A.length == 0 || B.length == 0 || k == 0) {
            return Integer.MAX_VALUE;
        }
        // Arrays.sort(A);
        // Arrays.sort(B);
        HashSet<Node> set = new HashSet<Node> ();
        Comparator<Node> comp = new Comparator<Node> (){
            public int compare(Node n1, Node n2) {
                if(n1.sum == n2.sum) {
                    return n1.index1 - n2.index1; 
                }
                return n1.sum - n2.sum;
            }
        };
        PriorityQueue<Node> queue = new  PriorityQueue<Node> (k, comp);
        Node temp = new Node(0, 0, A[0] + B[0]);
        set.add(temp);
        queue.offer(temp);
        int[] dx = {0,1};
        int[] dy = {1,0};
        for(int i = 0 ; i < k - 1; i++){
        	 if(queue.isEmpty()){
                 return -1;
             }
             Node pre = queue.poll();
            for(int m = 0; m < dx.length; m++){
              int nextx = dx[m] + pre.index1;
              int nexty = dy[m] + pre.index2;
              if(nextx < A.length  && nexty < B.length) {
              Node next = new Node(nextx, nexty, A[nextx] + B[nexty]);
              if(!set.contains(next)) {
                  set.add(next);
                  queue.offer(next);
                }
              }    
              
            }
        }
        return queue.peek().sum;
    }
	public static void main(String[] args) {
		int[] A = new int[] { 1, 7, 11 };
		int[] B = new int[] { 2, 4, 6 };
		K_Smallest_Sum_in_Two_Sorted_Arrays test = new K_Smallest_Sum_in_Two_Sorted_Arrays();
		System.out.println(test.kthSmallestSum(A, B, 3));
	}
}
