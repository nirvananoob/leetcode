package DP;

public class Unique_Paths {
	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * Notice
	 * 
	 * m and n will be at most 100.
	 */
	public int uniquePaths(int m, int n) {
		// write your code here
		int[][] path = new int[m][n];

		for (int i = 0; i < m; i++) {
			path[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			path[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				path[i][j] = path[i - 1][j] + path[i][j - 1];
			}
		}
		return path[m - 1][n - 1];
	}
	/**
	 * Follow up for "Unique Paths":
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid.
	 * 
	 * Notice
	 * 
	 * m and n will be at most 100.
	 * 
	 * Have you met this question in a real interview? Yes Example For example,
	 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
	 * 
	 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return -1;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int [][] res = new int[row][col];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        res[0][0] = 1;
        for (int i = 1; i < row; i++) {
            // res[i][0] = obstacleGrid[i][0] == 1 ?  0 : res[i-1][0];
            if (obstacleGrid[i][0] == 1) {
                break;
            }else {
                res[i][0] = res[i - 1][0];
            }
        }
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }else {
                res[0][i] = res[0][i - 1];
            }
        }
        for (int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                res[i][j] = obstacleGrid[i][j] == 1? 0: res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[row - 1][col - 1];
    }
}
