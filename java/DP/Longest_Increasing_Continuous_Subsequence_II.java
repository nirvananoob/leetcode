package DP;

/**
 * Give you an integer matrix (with row size n, column size m)，find the longest
 * increasing continuous subsequence in this matrix. (The definition of the
 * longest increasing continuous subsequence here can start at any row or column
 * and go up/down/right/left any direction).
 * 
 * 
 * Example Given a matrix:
 * 
 * [ [1 ,2 ,3 ,4 ,5], [16,17,24,23,6], [15,18,25,22,7], [14,19,20,21,8],
 * [13,12,11,10,9] ] return 25
 * 
 * Challenge O(nm) time and memory.
 * 
 * @author kaizhang
 *
 */
public class Longest_Increasing_Continuous_Subsequence_II {
	/**
	 * @param A
	 *            an integer matrix
	 * @return an integer
	 */
	// //v1 : heap, O(nmlgnm);
	// class ResultType {
	// int row;
	// int col;
	// int val;
	// ResultType(int r, int l , int v) {
	// this.row = r;
	// this.col = l;
	// this.val = v;
	// }
	// }
	// static Comparator<ResultType> comp = new Comparator<ResultType> () {
	// public int compare (ResultType r1, ResultType r2) {
	// return r2.val - r1.val;
	// }
	// };
	// public int longestIncreasingContinuousSubsequenceII(int[][] A) {
	// // Write your code here
	// if(A == null || A.length == 0 || A[0].length == 0) {
	// return 0;
	// }
	// // boolean[][] visited == new boolean[A.length][A[0].length] ;
	// int[][] res = new int[A.length][A[0].length];
	// PriorityQueue<ResultType> queue = new PriorityQueue<ResultType> (A.length
	// *A[0].length, comp);

	// for(int i = 0; i < A.length; i++) {
	// for(int j = 0; j < A[0].length; j++) {
	// queue.offer(new ResultType(i, j, A[i][j]));
	// }
	// }
	// int max = 1;
	// int row, col;
	// while(!queue.isEmpty()) {
	// ResultType cur = queue.poll();
	// row = cur.row;
	// col = cur.col;
	// res[row][col] = 1;
	// if (row > 0 && A[row - 1][ col] > A[row][col]) {
	// res[row][col] = Math.max(res[row - 1][col] + 1, res[row][col]);
	// }if (row < A.length - 1 && A[row + 1][ col] > A[row][col]) {
	// res[row][col] = Math.max(res[row + 1][col] + 1, res[row][col]);
	// }
	// if (col > 0 && A[row][col - 1] > A[row][col]) {
	// res[row][col] = Math.max(res[row][col - 1] + 1, res[row][col]);
	// }
	// if (col < A[0].length - 1 && A[row][col + 1] > A[row][col]) {
	// res[row][col] = Math.max(res[row][col + 1] + 1, res[row][col]);
	// }
	// max = Math.max(res[row][col], max);
	// }
	// return max;
	// }

	// v2 dp
	public int longestIncreasingContinuousSubsequenceII(int[][] A) {
		// Write your code here
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}
		int[][] res = new int[A.length][A[0].length];
		boolean[][] visited = new boolean[A.length][A[0].length];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int max = 1;
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				res[i][j] = search(i, j, A, res, visited, dx, dy);
				max = Math.max(res[i][j], max);
			}
		}
		return max;

	}

	private int search(int row, int col, int[][] arr, int[][] res,
			boolean[][] visited, int[] dx, int[] dy) {
		if (visited[row][col]) {
			return res[row][col];
		}
		res[row][col] = 1;
		visited[row][col] = true;
		// int nx, ny;
		for (int i = 0; i < dx.length; i++) {
			if (row + dx[i] >= 0 && row + dx[i] < arr.length
					&& col + dy[i] >= 0 && col + dy[i] < arr[0].length
					&& arr[row + dx[i]][col + dy[i]] > arr[row][col]) {
				res[row][col] = Math.max(
						res[row][col],
						search(row + dx[i], col + dy[i], arr, res, visited, dx,
								dy) + 1);
			}
		}
		return res[row][col];
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 16, 17, 24, 23, 6 },
				{ 15, 18, 25, 22, 7 }, { 14, 19, 20, 21, 8 },
				{ 13, 12, 11, 10, 9 } };
		Longest_Increasing_Continuous_Subsequence_II  test = new Longest_Increasing_Continuous_Subsequence_II ();
		System.out.println(test.longestIncreasingContinuousSubsequenceII(arr));
	}
}
