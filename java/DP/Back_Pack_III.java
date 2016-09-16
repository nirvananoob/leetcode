package DP;

/**
 * Given n kind of items with size Ai and value Vi( each item has an infinite
 * number available) and a backpack with size m. What's the maximum value can
 * you put into the backpack?
 * 
 * Notice
 * 
 * You cannot divide item into small pieces and the total size of items you
 * choose should smaller or equal to m.
 * 
 * 
 * Example Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a
 * backpack with size 10. The maximum value is 15.
 * 
 * @author kaizhang
 *
 */
public class Back_Pack_III {
	 public int backPackIII(int[] A, int[] V, int m) {
	        // Write your code here
	         if(m == 0 || A.length == 0 || A.length != V.length) {
	             return 0;
	         }
	         int n = A.length;
	         //dp equation:
	         //f(i,v) = Math.max(f(i - 1, v), f(i, v - A[i]) + V[i])
	         int[] dp = new int[m + 1];
	         for(int i = 0 ; i < n; i++) {
	             for(int j = A[i]; j <= m; j++){
	                 dp[j] = Math.max(dp[j], dp[j - A[i]] +V[i]);
	             }
	         }
	         int max = 0; 
	         for(int i = 0 ; i <= m ; i ++) {
	             max = Math.max(max, dp[i]);
	         }
	         return max;
	    }
	 public static void main(String[] args) {
		 int[] A = {2,3,5,7};
		 int[] V = {1,5,2,4};
		 Back_Pack_III test = new Back_Pack_III ();
		 System.out.println(test.backPackIII(A, V, 10));
		 
	 }
}
