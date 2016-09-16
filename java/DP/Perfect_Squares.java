package DP;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * 
 * Example Given n = 12, return 3 because 12 = 4 + 4 + 4 Given n = 13, return 2
 * because 13 = 4 + 9
 * 
 * 
 * @author kaizhang
 *
 */
public class Perfect_Squares {
	public int numSquares(int n) {
        // Write your code here
        if(n == 0 ) {
            return 0 ;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1] ;
        int last1 = 1;
        int last2 = -1;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            int temp = sqrt(i);
            if(temp * temp == i){
                last2 = last1;
                last1 = i;
                dp[i]  = 1;
            }else{
                if(last2 == -1) {
                    dp[i] = dp[i - 1] + 1;
                }else {
                    dp[i] = Math.min(1 + dp[i - last1] , 1 + dp[i - last2]);
                }
                
            }
        }
        return dp[n];
        
    }
    private int sqrt(int n) {
        long l = 1; 
        long r = n;
        long mid;
        while(l + 1 < r) {
            mid = (l + r) / 2;
            if(mid * mid == n){
                return (int) mid;
            }else if(mid * mid  > n){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        if (r * r <= n) {
            return (int)r;
        }
        return (int)l;
    }
    public static void main(String[] args) {
    	Perfect_Squares test = new Perfect_Squares ();
    	System.out.println(test.numSquares(30));
    }
}
