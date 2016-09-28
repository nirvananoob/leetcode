package DP;

import java.util.ArrayList;

/**
 * Given an integer array, adjust each integers so that the difference of every
 * adjacent integers are not greater than a given number target.
 * 
 * If the array before adjustment is A, the array after adjustment is B, you
 * should minimize the sum of |A[i]-B[i]|
 * 
 * Notice
 * 
 * You can assume each number in the array is a positive integer and not greater
 * than 100.
 * 
 * 
 * Example Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3],
 * the adjustment cost is 2 and it's minimal.
 * 
 * Return 2.
 * 
 * @author kaizhang
 *
 */
public class Minimum_Adjustment_Cost {
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0){
            return -1;
        }
        int res;
        int[][] dp = new int[A.size()][101];
        for (int i = 0 ; i < 101; i++) {
            dp[0][i] = Math.abs(A.get(0) - i);
        }
        for(int i = 1; i < A.size(); i++){
            for(int j = 0; j< 101; j++ ){
             res = Integer.MAX_VALUE;
            for(int m = Math.max(0, j - target); m < Math.min(j + target + 1, 101); m++){
                res = Math.min(dp[i - 1][m],res);
            }
            dp[i][j] = res + Math.abs(A.get(i) - j);
            }
        }
       res = Integer.MAX_VALUE;
        for(int i = 0 ; i < 101; i++) {
            res = Math.min(res, dp[A.size() - 1][i]);
        }
        return res;
    }
}
