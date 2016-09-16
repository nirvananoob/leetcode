package DP;

public class Minimum_Path_Sum {
	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Notice
	 * 
	 * You can only move either down or right at any point in time.
	 */
	/**
	 * @param grid
	 *            : a list of lists of integers.
	 * @return: An integer, minimizes the sum of all numbers along its path
	 */
	// v2:
	 public int minPathSum(int[][] grid) {
	 // write your code here
	 if (grid == null || grid.length == 0 || grid[0].length == 0) {
	 return Integer.MAX_VALUE;
	 }
	 int row = grid.length, col = grid[0].length;
	 int[][] res = new int[row][col];
	 //initialization:
	 res[0][0] = grid[0][0];
	 for (int i = 1 ; i < col; i++ ) {
	 res[0][i] = res[0][i - 1] + grid[0][i];
	 }
	 for (int i = 1; i < row; i++) {
	 res[i][0] = res[i - 1][0] + grid[i][0];
	 }
	 //dp
	 for (int i = 1; i < row; i++) {
	 for(int j = 1; j < col; j++) {
	 res[i][j] = Math.min(res[i - 1][j] , res[i][j - 1]) + grid[i][j];
	 }
	 }
	 return res[row - 1][col - 1];
	 }
}
