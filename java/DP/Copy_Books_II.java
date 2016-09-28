package DP;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given n books( the page number of each book is the same) and an array of
 * integer with size k means k people to copy the book and the i th integer is
 * the time i th person to copy one book). You must distribute the continuous id
 * books to one people to copy. (You can give book A[1],A[2] to one people, but
 * you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is
 * not continuous.) Return the number of smallest minutes need to copy all the
 * books.
 * 
 * Given n = 4, array A = [3,2,4], Return 4( First person spends 3 minutes to
 * copy book 1, Second person spends 4 minutes to copy book 2 and 3, Third
 * person spends 4 minutes to copy book 4. )
 * 
 * @author kaizhang
 *
 */
public class Copy_Books_II {
	/**
	 * method 1: Greedy: every time to read a new book , just choose the people
	 * with min cost;
	 * 
	 * @author kaizhang
	 *
	 */
	class Node {
		int cost;
		int count;
		int val;

		public Node(int a, int b, int c) {
			this.cost = a;
			this.count = b;
			this.val = c;
		}
	}

	private Comparator<Node> comp = new Comparator<Node>() {
		public int compare(Node n1, Node n2) {
			if (n1.val != n2.val) {
				return n1.val - n2.val;
			}
			return n1.cost - n2.cost;
		}
	};

	public int copyBooksII_Greedy(int n, int[] times) {
		// write your code here
		if (n == 0 || times == null || times.length == 0) {
			return 0;
		}
		int min = -1;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(times.length, comp);
		for (int i = 0; i < times.length; i++) {
			queue.offer(new Node(times[i], 0, times[i]));
		}
		for (int i = 0; i < n; i++) {
			Node temp = queue.poll();
			min = temp.val;
			++temp.count;

			temp.val += temp.cost;
			queue.offer(temp);
			;
		}
		return min;
	}

	/**
	 * method 2: dp : just like the solution of Copy_Books_I
	 * 
	 * @param n
	 * @param times
	 * @return
	 */
	public int copyBooksII_DP(int n, int[] times) {
		// write your code here

		if (n == 0 || times == null || times.length == 0) {
			return 0;
		}
		int[][] dp = new int[2][n + 1];
		dp[0][1] = times[0];
		dp[1][1] = Integer.MAX_VALUE;
		for (int i = 2; i <= n; i++) {
			dp[0][i] = times[0] + dp[0][i - 1];
			dp[1][i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < times.length; i++) {
			int right = 1, left = 0;
			int sum;
			// dp[i % 2][0] = Math.min(tims[i - 1],dp[(i - 1) % 2][0]);
			while (true) {
				sum = times[i] * (right - left);
				dp[i % 2][right] = Math.min(dp[i % 2][right],
						Math.max(dp[(i - 1) % 2][left], sum));
				if (left < right && dp[(i - 1) % 2][left] < sum) {
					left++;
				} else {
					right++;
					// !take care, you must move left pointer back because it
					// can be a potential solution for example(10,2), k = 2
					if (left > 0) {
						left--;
					}
					if (right > n) {
						// clear the previous row
						for (int m = 1; m <= n; m++) {
							dp[(i - 1) % 2][m] = Integer.MAX_VALUE;
						}
						break;
					}
				}
			}
		}
		return dp[(times.length - 1) % 2][n];
	}

	public static void main(String[] args) {
		Copy_Books_II test = new Copy_Books_II();
		int[] arr = new int[] { 10, 2 };
		int k = 2;
		Stack<Integer> s = new Stack<Integer> ();
		System.out.println(test.copyBooksII_DP(k, arr));
	}
}
