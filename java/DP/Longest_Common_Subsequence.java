package DP;

public class Longest_Common_Subsequence {
	/**
	 * Given two strings, find the longest common subsequence (LCS).
	 * 
	 * Your code should return the length of LCS.
	 * 
	 * 
	 * Clarification What's the definition of Longest Common Subsequence?
	 * 
	 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
	 * http://baike.baidu.com/view/2020307.htm Example For "ABCD" and "EDCA",
	 * the LCS is "A" (or "D", "C"), return 1.
	 * 
	 * For "ABCD" and "EACB", the LCS is "AC", return 2.
	 */
	 public int longestCommonSubsequence(String A, String B) {
	        // write your code here
	        if (A == null ||B == null || A.length() == 0 || B.length() == 0) {
	            return 0;
	        }
	        int row = A.length();
	        int col = B.length();
	        int[][] res = new int[row + 1][col + 1];
	        // res[0][0] = 0;
	        for (int i = 1; i < row + 1; i++) {
	            for (int j = 1; j < col + 1; j ++) {
	                if  (A.charAt(i - 1) == B.charAt( j - 1)) {
	                    res[i][j] = getMax(res[i - 1][j - 1] + 1, res[i - 1][j], res[i][j - 1]);
	                }else {
	                    res[i][j] = getMax(res[i - 1][j - 1], res[i - 1][j], res[i][j - 1]);
	                }
	            }
	        }
	        return res[row][col];
	        
	    }
	    private int  getMax(int a , int b, int c){
	        return Math.max(a,b) > c ? Math.max(a, b) : c;
	    }
}
