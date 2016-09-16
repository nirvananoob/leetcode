package Search.DFS_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * 
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * @author kaizhang
 *
 */
public class Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		List<Character> list = new ArrayList<Character>();
		dfs(res, list, 0, digits);
		return res;
	}

	private void dfs(List<String> res, List<Character> list, int pos,
			String digits) {
		if (list.size() == digits.length()) {
			StringBuilder sb = new StringBuilder();
			for (char c : list) {
				sb.append(c);
			}
			res.add(sb.toString());
			return;
		}
		char c = digits.charAt(pos);
		int index = c - '2';
		int start = index >= 6 ? index * 3 + 1 : index * 3;
		int end = index == 7 || index == 5 ? start + 3 : start + 2;
		for (int i = start; i <= end; i++) {
			char next = (char) ((int) 'a' + i);
			list.add(next);
			dfs(res, list, pos + 1, digits);
			list.remove(list.size() - 1);
		}

		return;
	}

	public static void main(String[] args) {
		String s = "23459";
		System.out.println((char)('c' + 1));
		Letter_Combinations_of_a_Phone_Number test = new Letter_Combinations_of_a_Phone_Number();
		System.out.println(test.letterCombinations(s).toString());
	}
}
