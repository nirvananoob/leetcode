package DP;

public class Longest_Common_Substring {
	/**
	 * Given two strings, find the longest common substring.
	 * 
	 * Return the length of it.
	 * 
	 * Notice
	 * 
	 * The characters in substring should occur continuously in original string.
	 * This is different with subsequence.
	 * 
	 * 
	 * Example Given A = "ABCD", B = "CBCE", return 2.
	 * 
	 * Challenge O(n x m) time and memory.
	 */
	  /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
     //v1 better
    //public int longestCommonSubstring(String A, String B) {
        // write your code here
    //     int maxlen = 0;
    //     int xlen = A.length();
    //     int ylen = B.length();
    //     for(int i = 0; i < xlen; ++i)
	   // {
		  //  for(int j = 0; j < ylen; ++j)
		  //  {
			 //   int len = 0;
    //             while (i + len < xlen && j + len < ylen && 
    //                 A.charAt(i + len) == B.charAt(j + len))
    //                     len ++;
			 //   if(len > maxlen)
				//     maxlen = len;
		  //  }
	   // }
    //     return maxlen;
    // }
    //v2
     public int longestCommonSubstring(String A, String B){
         if (A == null || B == null || A.length() == 0 || B.length() == 0){
             return 0;
         }
         int[][] res = new int[A.length() + 1][B.length() + 1];
         for (int i = 1; i < res.length; i++) {
             for (int j = 1; j < res[0].length; j++) {
                 if (A.charAt(i - 1) == B.charAt(j - 1)) {
                 res[i][j] = res[i - 1][j - 1] + 1;
             }
         }
     }
     int max = 0;
     for (int i = 0; i < res.length; i++){
         for (int j = 0; j < res[0].length; j++){
             max = res[i][j] > max? res[i][j] : max;
         }
     }
     return max;
     }
}
