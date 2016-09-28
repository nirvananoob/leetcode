package DP;
/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 * Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 * @author kaizhang
 *
 */
public class Range_Sum_Query_2D_Immutable {
	private int[][] mat;

	public Range_Sum_Query_2D_Immutable(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			// throw new IllegalArgumentException("invalid input matrix");
			return;
		}

		this.mat = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 1; i < mat.length; i++) {
//			for (int j = 1; j < mat[0].length; j++) {
//				mat[i][j] = mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1]
//						+ matrix[i - 1][j - 1];
//			}
			int temp = 0;
			for (int j = 1; j < mat[0].length; j++) {
				temp += matrix[i - 1][j - 1];
				mat[i][j]  = mat[i - 1][j] + temp;
			}

		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {

		if (mat == null || row1 < 0 || row2 > mat.length - 1 || col1 < 0
				|| col2 > mat[0].length - 1) {
			return 0;
		}
		return mat[row2 + 1][col2 + 1] - mat[row2 + 1][col1]
				- mat[row1][col2 + 1] + mat[row1][col1];
	}

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1 }, { -7 } };
		Range_Sum_Query_2D_Immutable test = new Range_Sum_Query_2D_Immutable(
				arr);
		System.out.println(test.sumRegion(0, 0, 0, 0));
		System.out.println(test.sumRegion(1, 0, 1, 0));
		System.out.println(test.sumRegion(0, 0, 1, 0));
	}
}
