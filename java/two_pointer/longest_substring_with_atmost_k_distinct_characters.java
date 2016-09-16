package two_pointer;

/**
 * Given a string s, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * @author kaizhang
 *
 */
public class longest_substring_with_atmost_k_distinct_characters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		// write your code here
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}

		int res = 0;
		int cur_count = 0, end = 0, len = s.length();
		int[] chars = new int[256];
		for (int i = 0; i < len; i++) {
			if (len - i < res) {
				break;
			}
			while (end < len && cur_count < k + 1) {
				// v1 wrong:
				// ++chars[s.charAt(end)];
				// if (chars[s.charAt(end)] == 1) {
				// ++cur_count;
				// }
				// if(cur_count < k + 1) {
				// ++end;
				// }
				if (chars[s.charAt(end)] == 0) {
					if (cur_count == k) {
						break;
					} else {

						++cur_count;
					}
				}
				++chars[s.charAt(end)];
				++end;
			}

			res = Math.max(res, end - i);
			--chars[s.charAt(i)];
			if (chars[s.charAt(i)] == 0) {
				--cur_count;
			}

		}
		return res;
	}
}
