package Search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * Please optimize your algorithm to use less time and space. The input size may
 * be as large as 5,000,000.
 * 
 * @author kaizhang
 *
 */
public class Lexicographical_Numbers {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new LinkedList<Integer>();
		if (n == 0) {
			return list;
		}
		for (int i = 1; i < 10; i++) {
			dfs(list, i, n);
		}

		return list;

	}

	private void dfs(List<Integer> list, int cur, int n) {
		if (n < cur) {
			return;
		}
		list.add(cur);
		if (cur * 10 <= n) {
			for (int i = 0; i < 10; i++) {
				if ((cur * 10 + i) > n) {
					break;
				}
				dfs(list, cur * 10 + i, n);
			}
		}
	}

	public static void main(String[] args) {
		Lexicographical_Numbers test = new Lexicographical_Numbers();
		System.out.println(test.lexicalOrder(30).toString());
	}
}
