package String;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author kaizhang
 *
 */
public class Longest_Palindrome_SubString {
	/**
	 * normal solution : time O(n ^ 2) space O(n)
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome_normal(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] chars = s.toCharArray();
		String res = "";
		for (int i = 0; i < chars.length; i++) {
			int left = i - 1, right = i + 1;
			while (left >= 0 && right < chars.length
					&& chars[left] == chars[right]) {
				--left;
				++right;
			}
			if (right - left - 1 > res.length()) {
				res = s.substring(left + 1, right);
			}
			left = i;
			right = i + 1;
			while (left >= 0 && right < chars.length
					&& chars[left] == chars[right]) {
				--left;
				++right;
			}
			if (right - left - 1 > res.length()) {
				res = s.substring(left + 1, right);
			}
		}
		return res;
	}

	/**
	 * Manacher’s Algorithm O(n)
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		String res = "";
		String str = preprocess(s);
		int[] lens = new int[str.length()];
		int center = 0;
		int R = 0;
		for (int i = 1; i < lens.length - 1; i++) {
			int mirrpos = 2 * center - i;
			lens[i] = R > i ? Math.min(lens[mirrpos], R - i) : 0;
			while (i - lens[i] > 0 && i + lens[i] + 1 < str.length()   && str.charAt(i + lens[i] + 1) == str.charAt(i - lens[i] - 1)) {
				lens[i]++;
			}
			if (i + lens[i] > R) {
				center = i;
				R = i + lens[i];
			}
		}

		center = 0;
		for (int i = 0; i < lens.length; i++) {
			if (lens[i] > lens[center]) {
				center = i;
			}
		}
		return s.substring((center - lens[center]) / 2, lens[center]);
	}

	private String preprocess(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append('#');
		for (char c : s.toCharArray()) {
			sb.append(c);
			sb.append('#');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String test = "ccc";
//		System.out.println(123);
		Longest_Palindrome_SubString lps = new Longest_Palindrome_SubString();
		System.out.println(lps.longestPalindrome(test));
	}

}
