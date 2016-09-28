package DP;

/**
 * There is a fence with n posts, each post can be painted with one of the k
 * colors. You have to paint all the posts such that no more than two adjacent
 * fence posts have the same color. Return the total number of ways you can
 * paint the fence.
 * 
 * Notice
 * 
 * n and k are non-negative integers.
 *  Example
	Given n=3, k=2 return 6
	
	      post 1,   post 2, post 3
	way1    0         0       1 
	way2    0         1       0
	way3    0         1       1
	way4    1         0       0
	way5    1         0       1
	way6    1         1       0
 * 
 * 
 * 
 * @author kaizhang
 *
 */
public class Paint_Fence {
	public int numWays(int n, int k) {
		// Write your code here
		if (n == 0) {
			return 0;
		}
		if (n <= 2) {
			return n == 1 ? k : k * k;
		}
		int local = k;
		int global = k * k - k;
		for (int i = 3; i <= n; i++) {
			int temp = local;
			local = global;
			global = (global + temp) * (k - 1);
		}
		return global + local;
	}
}
