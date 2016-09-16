package Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
/**
 * Build tries from a list of pairs. Save top 10 for each node.

Have you met this question in a real interview? Yes
Example
Given a list of

<"abc", 2>
<"ac", 4>
<"ab", 9>
Return <a[9,4,2]<b[9,2]<c[2]<>>c[4]<>>>, and denote the following tree structure:

         Root
         / 
       a(9,4,2)
      /    \
    b(9,2) c(4)
   /
 c(2)

 * @author kaizhang
 *
 */
public class Trie_Service {
	/**
	 * Definition of TrieNode:
	 * 
	 */
	class TrieNode {
		public NavigableMap<Character, TrieNode> children;
		public List<Integer> top10;

		public TrieNode() {
			children = new TreeMap<Character, TrieNode>();
			List<Integer> top10 = new ArrayList<Integer>();
		}
	}

	private TrieNode root = null;

	public Trie_Service() {
		root = new TrieNode();
	}

	public TrieNode getRoot() {
		// Return root of trie root, and
		// lintcode will print the tree struct.
		return root;
	}

	private int findindex(List<Integer> list, int target) {
		if (list.size() == 0) {
			return 0;
		}
		int l = 0, r = list.size() - 1, mid, pivot;
		while (l + 1 < r) {
			mid = l + (r - l) / 2;
			pivot = list.get(mid);
			if (pivot == target) {
				return mid;
			} else if (pivot < target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		if (list.get(r) >= target) {
			return r + 1;
		} else if (list.get(l) >= target) {
			return r;
		} else {
			return l;
		}
	}

	public void insert(String word, int frequency) {
		// Write your cod here
		TrieNode cur = root;
		int n = word.length();

		for (int i = 0; i < n; ++i) {
			Character c = word.charAt(i);
			if (!cur.children.containsKey(c))
				cur.children.put(c, new TrieNode());

			cur = cur.children.get(c);
			if (cur.top10.size() > 10)
				cur.top10.remove(n - 1);

			int pos = findindex(cur.top10, frequency);
			cur.top10.add(pos, frequency);

		}
	}

}
