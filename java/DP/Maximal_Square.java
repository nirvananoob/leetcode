package DP;

public class Maximal_Square {
	/**
	 *
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
	 * containing all 1's and return its area.
	 * 
	 * 
	 * Example For example, given the following matrix: 
	 * 1 0 1 0 
	 * 0 1 0 1 
	 * 1 1 1 1
	 * 1 1 1 1 
	 * 0 0 1 0 
	 * Return 4.
	 */
	// v1
	// public int maxSquare(int[][] matrix) {
	// // write your code here
	// if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	// return 0;
	// }
	// //the array to store the max square length end at the point (i, j)
	// int[][] res = new int[matrix.length][matrix[0].length];
	// // res[0][0] = matrix[0][0];
	// int max = res[0][0];
	// for(int i = 0; i < matrix.length; i ++) {
	// res[i][0] = matrix[i][0];
	// if (max < res[i][0]) {
	// max = res[i][0];
	// }
	// }
	// for(int j = 1; j < matrix[0].length; j++){
	// res[0][j] = matrix[0][j];
	// if (max < res[0][j]){
	// max = res[0][j];
	// }
	// }
	// if (matrix.length == 1 || matrix[0].length == 1){
	// return max;
	// }
	// for (int i = 1; i < matrix.length; i++) {
	// for(int j = 1; j < matrix[0].length; j++) {
	// if (matrix[i][j] == 0){
	// res[i][j] = 0;
	// }else{
	// res[i][j] = getMin(res[i - 1][j - 1], res[i][j - 1], res[i - 1][j]) +1;
	// if(res[i][j] > max) {
	// max = res[i][j];
	// }
	// }

	// }
	// }
	// return max * max;

	// }
	// private int getMin(int a, int b, int c) {
	// int min1 = Math.min(a, b);
	// return min1 > c ? c : min1;
	// }
	// v2 rotate array:
	public int maxSquare(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int res = matrix[0][0];

		int[][] dp = new int[2][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == 0) {
					dp[i % 2][j] = matrix[i][j];
					res = Math.max(res, dp[i % 2][j]);
					continue;
				}
				if (matrix[i][j] == 0) {
					dp[i % 2][j] = 0;
				} else {
					dp[i % 2][j] = Math.min(Math.min(dp[(i + 1) % 2][j - 1],
							dp[(i + 1) % 2][j]), dp[i % 2][j - 1]) + 1;
					if (dp[i % 2][j] > res) {
						res = dp[i % 2][j];
					}
				}
			}
		}
		return res * res;
	}
	/**
	 * follow up :
	 * what if we wanna get the maximal square ,in which only diagonal  matrix：
	 * ans get maxlength of 0's for(i,j) and f[i - 1][j- 1];
	 *f[i][j] = min(lengh of 0's before [i][j] length of 0's above[i][j], f[i- 1][j -1]);
	 */
}
