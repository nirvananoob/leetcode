package DP;

public class climbing_stairs {
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 * 
	 * Example Given an example n=3 , 1+1+1=2+1=1+2=3
	 * 
	 * return 3
	 */
	/**
	 * @param n
	 *            : An integer
	 * @return: An integer
	 */
	public int climbStairs(int n) {
		if (n <= 1) {
			return 1;
		}
		int last = 1, lastlast = 1;
		int now = 0;
		for (int i = 2; i <= n; i++) {
			now = last + lastlast;
			lastlast = last;
			last = now;
		}
		return now;

	}
}
