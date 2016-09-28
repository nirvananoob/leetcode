package Stack;

import java.util.HashSet;
import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example: Given "bcabc" Return "abc"
 * 
 * Given "cbacdcbc" Return "acdb"
 * 
 * Credits: Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 * 
 * @author kaizhang
 *
 */
public class Remove_Duplicate_Letters {
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] chars = s.toCharArray();
		int[] counts = new int[26];
		for (char c : chars) {
			++counts[c - 'a'];
		}
		Stack<Character> stack = new Stack<Character>();
		HashSet<Character> set = new HashSet<Character>();
		for (char c : chars) {
			--counts[c - 'a'];
			if (set.contains(c)) {
				continue;
			}
			while (!stack.isEmpty() && counts[stack.peek() - 'a'] != 0
					&& (stack.peek() - c) > 0) {
				set.remove(stack.peek());
				stack.pop();

			}

			set.add(c);
			stack.push(c);

		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();
		return sb.toString();
	}

	public static void main(String[] args) {
		Remove_Duplicate_Letters test = new Remove_Duplicate_Letters();
		String str = "bcabc";
		System.out.println(test.removeDuplicateLetters(str));
	}
}
