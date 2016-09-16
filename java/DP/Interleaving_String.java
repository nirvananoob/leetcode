package DP;

public class Interleaving_String {
	/**
	 * Given three strings: s1, s2, s3, determine whether s3 is formed by the
	 * interleaving of s1 and s2.
	 * 
	 * 
	 * Example For s1 = "aabcc", s2 = "dbbca"
	 * 
	 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
	 * false.
	 */
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s2.length() == 0) {
			return s3.equals(s1);
		}
		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s3.length() == 0) {
			return false;
		}

		boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
		res[0][0] = true;
		for (int i = 1; i < res.length; i++) {
			res[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && res[i - 1][0];
		}
		for (int i = 1; i < res[0].length; i++) {
			res[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && res[0][i - 1];
		}
		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res[0].length; j++) {
				res[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i - 1) && res[i - 1][j])
						|| (s3.charAt(i + j - 1) == s2.charAt(j - 1) && res[i][j - 1]);
			}
		}
		return res[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		System.out.println( isInterleave("abc","abd","aabbdc"));
	}
}
