package DP;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * Example Given encoded message 12, it could be decoded as AB (1 2) or L (12).
 * The number of ways decoding 12 is 2.
 * 
 * @author kaizhang
 *
 */
public class Decode_Ways {
	public int numDecodings(String s) {
		// Write your code here
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		if (s.charAt(0) != '0') {
			dp[1] = 1;
		}
		for (int i = 2; i < dp.length; i++) {
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			if ((s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')
					|| s.charAt(i - 2) == '1') {
				dp[i] += dp[i - 2];
			}
		}
		return dp[dp.length - 1];

	}
}
