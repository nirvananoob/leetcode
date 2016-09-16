package DP;

/**
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note: All costs are positive integers.
 * 
 * Follow up: Could you solve it in O(nk) runtime?
 * 
 * @author kaizhang
 *
 */
public class Paint_House_II {
	// v1 O(n * k * k)
	public int minCostII(int[][] costs) {
		// Write your code here
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}
		int k = costs[0].length;
		int[][] colors = new int[2][k];

		for (int i = 0; i < k; i++) {
			colors[0][i] = costs[0][i];
		}
		for (int i = 1; i < costs.length; i++) {
			for (int j = 0; j < k; j++) {
				colors[i % 2][j] = costs[i][j] + getMin(colors, (i + 1) % 2, j);
			}
		}
		return getMin(colors, (costs.length + 1) % 2, -1);

	}

	private int getMin(int[][] colors, int row, int temp) {
		int mincost = Integer.MAX_VALUE;
		for (int i = 0; i < colors[0].length; i++) {
			if (i == temp) {
				continue;
			}
			mincost = Math.min(mincost, colors[row][i]);
		}
		return mincost;
	}
}
