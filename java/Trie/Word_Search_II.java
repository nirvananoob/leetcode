package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Search_II {
/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
 */
	/**
	 * @param board
	 *            : A list of lists of character
	 * @param words
	 *            : A list of string
	 * @return: A list of string
	 */
	// store the string at each node make it faster(dont need to check the
	// prefix)
	//v1 
//	class TrieNode {
//		String s;
//		boolean isString;
//		HashMap<Character, TrieNode> subtree;
//
//		public TrieNode() {
//			// TODO Auto-generated constructor stub
//			isString = false;
//			subtree = new HashMap<Character, TrieNode>();
//			s = "";
//		}
//	};
//
//	class TrieTree {
//		TrieNode root;
//
//		public TrieTree(TrieNode TrieNode) {
//			root = TrieNode;
//		}
//
//		public void insert(String s) {
//			TrieNode now = root;
//			for (int i = 0; i < s.length(); i++) {
//				if (!now.subtree.containsKey(s.charAt(i))) {
//					now.subtree.put(s.charAt(i), new TrieNode());
//				}
//				now = now.subtree.get(s.charAt(i));
//			}
//			now.s = s;
//			now.isString = true;
//		}
//
//		public boolean find(String s) {
//			TrieNode now = root;
//			for (int i = 0; i < s.length(); i++) {
//				if (!now.subtree.containsKey(s.charAt(i))) {
//					return false;
//				}
//				now = now.subtree.get(s.charAt(i));
//			}
//			return now.isString;
//		}
//	};
//
//	public int[] dx = { 1, 0, -1, 0 };
//	public int[] dy = { 0, 1, 0, -1 };
//
//	public void search(char[][] board, int x, int y, TrieNode root,
//			ArrayList<String> ans, String res) {
//		if (root.isString == true) {
//			if (!ans.contains(root.s)) {
//				ans.add(root.s);
//			}
//		}
//		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
//				|| board[x][y] == 0 || root == null)
//			return;
//		if (root.subtree.containsKey(board[x][y])) {
//			for (int i = 0; i < 4; i++) {
//				char now = board[x][y];
//				board[x][y] = 0;
//				search(board, x + dx[i], y + dy[i], root.subtree.get(now), ans,
//						res);
//				board[x][y] = now;
//			}
//		}
//
//	}
//
//	public List<String> findWords(char[][] board, String[] words) {
//		ArrayList<String> ans = new ArrayList<String>();
//
//		TrieTree tree = new TrieTree(new TrieNode());
//		for (String word : words) {
//			tree.insert(word);
//		}
//		String res = "";
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				search(board, i, j, tree.root, ans, res);
//			}
//		}
//		return ans;
		// write your code here
//}
	//v2 :
	public List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    TrieNode root = buildTrie(words);
	    for(int i = 0; i < board.length; i++) {
	        for(int j = 0; j < board[0].length; j++) {
	            dfs(board, i, j, root, res);
	        }
	    }
	    return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
	    char c = board[i][j];
	    if(c == '#' || p.next[c - 'a'] == null) return;
	    p = p.next[c - 'a'];
	    if(p.word != null) {   // found one
	        res.add(p.word);
	        p.word = null;     // de-duplicate
	    }

	    board[i][j] = '#';
	    if(i > 0) dfs(board, i - 1, j ,p, res); 
	    if(j > 0) dfs(board, i, j - 1, p, res);
	    if(i < board.length - 1) dfs(board, i + 1, j, p, res); 
	    if(j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
	    board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
	    TrieNode root = new TrieNode();
	    for(String w : words) {
	        TrieNode p = root;
	        for(char c : w.toCharArray()) {
	            int i = c - 'a';
	            if(p.next[i] == null) p.next[i] = new TrieNode();
	            p = p.next[i];
	       }
	       p.word = w;
	    }
	    return root;
	}

	class TrieNode {
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}
	

}
