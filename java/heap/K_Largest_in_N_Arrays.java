package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Find K-th largest element in N arrays.
public class K_Largest_in_N_Arrays {
	/**
	 * @param arrays
	 *            a list of array
	 * @param k
	 *            an integer
	 * @return an integer, K-th largest element in N arrays
	 */
	class Node {
		int id;
		int index;
		int val;

		Node(int x, int y, int val) {
			this.id = x;
			this.index = y;
			this.val = val;
		}
	}

	static Comparator<Node> comp = new Comparator<Node>() {
		public int compare(Node n1, Node n2) {
			return n2.val - n1.val;
		}
	};

	public int KthInArrays(int[][] arrays, int k) {
		if (arrays == null || k <= 0) {
			return -1;
		}
		int row = arrays.length;
		int col = arrays[0].length;

		for (int i = 0; i < row; i++) {
			Arrays.sort(arrays[i]);
		}
		PriorityQueue<Node> queue = new PriorityQueue<Node>(k, comp);
		int count = 0;
		int pre = -1;
		for (int i = 0; i < row; i++) {
			if (arrays[i].length != 0) {
				queue.offer(new Node(i, arrays[i].length - 1,
						arrays[i][arrays[i].length - 1]));

			}
		}
		while (count < k && !queue.isEmpty()) {
			Node temp = queue.poll();
			pre = temp.val;
			count++;
			if (temp.index > 0) {
				queue.offer(new Node(temp.id, temp.index - 1,
						arrays[temp.id][temp.index - 1]));
			}

		}
		return count == k ? pre : -1;
	}
}
