package DP;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * 
 * Example Given S = "rabbbit", T = "rabbit", return 3.
 * 
 * Challenge Do it in O(n2) time and O(n) memory.
 * 
 * O(n2) memory is also acceptable if you do not know how to optimize memory.
 * 
 * @author kaizhang
 *
 */
public class Distinct_Subsequences {
	public static int numDistinct(String S, String T) {
		if (S == null || T == null) {
			return Integer.MIN_VALUE;
		}
		if (T.length() == 0) {
			return 1;
		}
		if (S.length() == 0) {
			return 0;
		}
		int slen = S.length();
		int tlen = T.length();
		int[][] res = new int[2][slen + 1];
		for (int i = 0; i <= slen; i++) {
			res[0][i] = 1;
		}
		for (int i = 1; i <= tlen; i++) {
			res[i % 2][0] = 0;
			for (int j = 1; j <= slen; j++) {
				res[i % 2][j] = res[i % 2][j - 1];
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					res[i % 2][j] += res[(i + 1) % 2][j - 1];
				}
			}

		}
		return res[tlen % 2][slen];
	}

	public static void main(String[] args) {
		String S = "ddd";
		String T = "dd";
		System.out.print(numDistinct(S, T));
	}
}
