package algorithms_template;

/**
 * O(m + n) algorithm to match the pattern for any string
 * 
 * @author kaizhang
 *
 */
public class KMP {
	private char[] string;
	private char[] pattern;

	public int[] prepare() {
		int[] prefixs = new int[pattern.length];
		int i = 1, j = 0;

		prefixs[0] = 0;
		while (i < prefixs.length) {
			if (pattern[i] == pattern[j]) {
				prefixs[i++] = ++j;
			} else {
				if (j == 0) {
					prefixs[i++] = 0;
				} else {
					j = prefixs[j - 1];
				}
			}
		}
		return prefixs;
	}

	public boolean KMP_match(String s, String t) {
		this.string = s.toCharArray();
		this.pattern = t.toCharArray();
		int[] prefixs = prepare();
		int i = 0, j = 0;
		while (i < string.length) {
			if (string[i] == pattern[j]) {
				i++;
				j++;
				if (j == pattern.length) {
					return true;
				}
			} else {
				if (j == 0) {
					i++;
				} else {
					j = prefixs[j - 1];
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
		KMP test = new KMP();
		System.out.println(test.KMP_match(str, subString));
		String s = "a";
		String b = "ab";
		System.out.println(s.compareTo(b));
	}

}
