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
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ) {
            return 0;
        }
        int[][] lens = new int[matrix.length][matrix[0].length];
        
        int max = 0;
        for(int i = 0; i < lens.length; i++){
            for(int j = 0 ; j < lens[0].length; j++){
                max = Math.max(max, search(matrix, lens, i, j));
            }
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer> ();
        for(int i = 0; i < lens.length; i++){
            for(int j = 0 ; j < lens[0].length; j++){
                if(lens[i][j] == max){
                    list.add(matrix[i][j]);
                    printpath(lens, matrix, i, j,res,list,max);
                    list.remove(list.size() -1);
                }
            }
        }
        for(int i = 0 ; i < lens.length; i++){
            System.out.println(Arrays.toString(lens[i]));
        }
        System.out.println(res.toString());
        return max;
    }
    private int search(int[][] matrix, int[][] res, int x, int y) {
        
        if(res[x][y] != 0){
            
            return res[x][y];
        }
        int nx, ny;
        res[x][y] = 1;
        for(int i = 0 ; i < dx.length; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx >= 0 && nx < res.length && ny >= 0  && ny < res[0].length && matrix[nx][ny] < matrix[x][y]) {
                res[x][y] = Math.max(search(matrix, res, nx, ny) + 1, res[x][y] );
            }
        }
        return res[x][y];
    }
    private  void printpath(int[][] arr, int[][] mat, int x, int y, ArrayList<List<Integer>> ans,List<Integer> list,int max){
        if(arr[x][y] == 1 && list.size() == max){
            ans.add(new ArrayList<Integer> (list));
            return;
        }
        int nx, ny;
        for(int i = 0 ; i < dx.length; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx >= 0 && nx < mat.length && ny >= 0  && ny < mat[0].length && arr[nx][ny] ==  arr[x][y] - 1 && mat[x][y] > mat[nx][ny]) {
                list.add(0,mat[nx][ny]);
                printpath(arr,mat, nx, ny,ans,list,max);
                list.remove(0);
            }
        }
        return;
        
    }
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 16, 17, 24, 23, 6 },
				{ 15, 18, 25, 22, 7 }, { 14, 19, 20, 21, 8 },
				{ 13, 12, 11, 10, 9 } };
		Longest_Increasing_Continuous_Subsequence_II  test = new Longest_Increasing_Continuous_Subsequence_II ();
		System.out.println(test.longestIncreasingContinuousSubsequenceII(arr));
	}
}
