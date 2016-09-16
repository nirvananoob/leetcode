package DP;

public class Palindrome_Partitioning_II {
	/**
	 * Given a string s, cut s into some substrings such that every substring is
	 * a palindrome.
	 * 
	 * Return the minimum cuts needed for a palindrome partitioning of s.
	 * Example Given s = "aab",
	 * 
	 * Return 1 since the palindrome partitioning ["aa", "b"] could be produced
	 * using 1 cut.
	 */
	public int minCut(String s) {
		// write your code here
		if (s == null) {
			return -1;
		}
		if (s.length() == 0 || s.length() == 1 || isValid(s)) {
			return 0;
		}
		int[] res = new int[s.length() + 1];
		res[0] = -1;

		for (int i = 2; i < res.length; i++) {
			res[i] = i;
			for (int j = 1; j <= i; j++) {
				if (isValid(s.substring(j - 1, i))
						&& res[i] - res[j - 1] - 1 > 0) {
					res[i] = res[j - 1] + 1;
				}
			}
		}
		return res[s.length()];

	}

	private boolean isValid(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		int len = s.length();
		int l = 0;
		while (l <= len / 2) {
			if (s.charAt(l) != s.charAt(len - 1 - l)) {
				return false;
			}
			l++;
		}
		return true;
	}
}
