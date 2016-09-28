package DP;

/**
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color red; costs[1][2] is the cost of painting house 1 with color green, and
 * so on... Find the minimum cost to paint all houses.
 * 
 * Notice
 * 
 * All costs are positive integers.
 * Example
	Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
	
	house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10
 * @author kaizhang
 *
 */
public class Paint_House {
	public int minCost(int[][] costs) {
		// Write your code here
		if (costs == null || costs.length == 0 || costs[0].length != 3) {
			return 0;
		}
		int red = costs[0][0], blue = costs[0][1], green = costs[0][2];
		int prevr, prevb;
		for (int i = 1; i < costs.length; i++) {
			prevr = red;
			prevb = blue;
			red = Math.min(blue, green) + costs[i][0];
			blue = Math.min(prevr, green) + costs[i][1];
			green = Math.min(prevr, prevb) + costs[i][2];
		}
		return Math.min(Math.min(red, blue), green);
	}
}
