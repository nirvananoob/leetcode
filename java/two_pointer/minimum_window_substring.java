package two_pointer;

/**
 * Given a string source and a string target, find the minimum window in source
 * which will contain all the characters in target.
 */
public class minimum_window_substring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return t;
		}
		int[] dict = new int[256];
		for (char c : t.toCharArray()) {
			dict[c]++;
		}
		int counter = t.length();
		char[] chars = s.toCharArray();
		int start = 0, end = 0;
		int head = 0, d = Integer.MAX_VALUE;
		while (end < chars.length) {
			if (dict[chars[end++]]-- > 0) {
				counter--;
			}
			while (counter == 0) {
				if (d > end - start) {
					d = end - start;
					head = start;
				}
				if (dict[chars[start++]]++ == 0) {
					counter++;
				}
			}
		}
		return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
	}
}
