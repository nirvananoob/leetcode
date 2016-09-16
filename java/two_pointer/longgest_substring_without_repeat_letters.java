package two_pointer;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
import java.util.HashSet;

public class longgest_substring_without_repeat_letters {
	public int lengthOfLongestSubstring(String s) {
		// write your code here
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashSet<Character> set = new HashSet<Character>();
		int end = 0, len = s.length(), res = 0;
		int cur_len = 0;
		for (int i = 0; i < len; i++) {
			while (end < len && !set.contains(s.charAt(end))) {

				set.add(s.charAt(end));
				++end;
			}
			cur_len = end - i;
			if (end != len || cur_len >= res) {
				res = Math.max(cur_len, res);
				set.remove(s.charAt(i));
			} else {
				break;
			}
		}
		return res;
	}
}
