package DP;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Example isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 * 
 * @author kaizhang
 *
 */
public class Regular_Expresssion_Matching {
	public boolean isMatch(String s, String p) {
		// write your code here
		if (s == null || p == null) {
			return false;
		}
		if (p.length() == 0) {
			return s.length() == 0;
		}
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		// initialization:
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			if (p.charAt(i - 1) == '*') {
				if (i == 1) {
					dp[0][i] = true;
				} else {
					dp[0][i] = dp[0][i - 2];
				}
			}
		}
		if (m >= 1) {
			dp[1][1] = charMatch(s, 0, p, 0);
			for (int i = 2; i <= n; i++) {
				if (p.charAt(i - 1) == '*') {
					dp[1][i] = charMatch(s, 0, p, i - 2)
							&& dp[1][i - 1] || dp[1][i - 2];
				} else {
					dp[1][i] = charMatch(s, 0, p, i - 1) && dp[0][i - 1];
				}
			}
		}

		for (int j = 2; j <= n; j++) {
			for (int i = 2; i <= m; i++) {
				if (p.charAt(j - 1) == '*') {

					dp[i][j] = charMatch(s, i - 1, p, j - 2)
							&& (dp[i - 1][j - 1] || dp[i - 1][j])
							|| dp[i][j - 2];

				} else {
					dp[i][j] = charMatch(s, i - 1, p, j - 1)
							&& dp[i - 1][j - 1];
				}
			}
		}
		return dp[m][n];

	}

	private boolean charMatch(String s, int sindex, String p, int pindex) {
		if (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Regular_Expresssion_Matching test = new Regular_Expresssion_Matching();
		System.out.println(test.isMatch("aaa", "ab*ac*a"));

	}
}
