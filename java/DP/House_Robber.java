package DP;

public class House_Robber {
	/**
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping
	 * you from robbing each of them is that adjacent houses have security
	 * system connected and it will automatically contact the police if two
	 * adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police. 
	 * Example Given [3, 8, 4], return 8.
	 * 
	 * Challenge O(n) time and O(1) memory.
	 */
	/**
	 * @param A
	 *            : An array of non-negative integers. return: The maximum
	 *            amount of money you can rob tonight
	 */
	// v1
	// public long houseRobber(int[] A) {
	// // write your code here

	// if (A == null || A.length == 0) {
	// return (long)0;
	// }
	// if (A.length == 1){
	// return (long)A[0];
	// }
	// if (A.length == 2){
	// return (long)Math.max(A[0], A[1]);
	// }
	// long[] res = new long[A.length];
	// long[] cur = new long[A.length];
	// //initialization
	// cur[0] = (long)A[0];
	// cur[1] =(long) A[1];
	// res[0] = (long)A[0];
	// res[1] =(long) Math.max(A[0], A[1]);
	// for (int i = 2; i < A.length; i++){
	// cur[i] = res[i - 2] + (long)A[i];
	// res[i] = Math.max(cur[i - 1] , cur[i] );
	// }
	// return res[A.length - 1];
	// }
	// v2: challenge :
	public long houseRobber(int[] A) {
		if (A == null || A.length == 0) {
			return (long) 0;
		}
		if (A.length == 1) {
			return (long) A[0];
		}
		long[] res = new long[2];
		res[0] = (long) A[0];
		res[1] = (long) Math.max(A[1], A[0]);
		for (int i = 2; i < A.length; i++) {
			res[i % 2] = Math.max((long) A[i] + res[i % 2], res[(i + 1) % 2]);
		}
		return res[(A.length - 1) % 2];
	}
}
