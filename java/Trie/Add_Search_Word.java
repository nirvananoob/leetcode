package Trie;

/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
 * search("bad") -> true search(".ad") -> true search("b..") -> true Note: You
 * may assume that all words are consist of lowercase letters a-z.
 * 
 * @author kaizhang
 *
 */
public class Add_Search_Word {
	class TrieNode {
		// Initialize your data structure here.
		private TrieNode[] childs;
		public boolean visited;
		public int freq;

		public TrieNode() {
			/**
			 * // consider there are only 26 lowercase letters , or we can
			 * implement a hash map
			 */
			this.childs = new TrieNode[26];
			this.visited = false;
			this.freq = 0;
		}

		// public boolean startsWith(String word, int index) {
		// if (word == null || word.length() <= index) {
		// return false;
		// }

		// int offset = word.charAt(index) - 'a';

		// if (childs[offset] == null) {
		// return false;
		// }
		// if (index == word.length() - 1) {
		// return childs[offset].freq > 0 ? true : false;
		// }
		// return childs[offset].startsWith(word, index + 1);
		// }
		public boolean search(String word, int index) {
			if (word == null || word.length() <= index) {
				return false;
			}

			char c = word.charAt(index);
			if (c == '.') {
				if (index == word.length() - 1) {
					for (TrieNode child : childs) {
						if (child != null && child.visited) {
							return true;
						}
					}
					return false;
				} else {
					for (TrieNode child : childs) {
						if (child != null && child.search(word, index + 1)) {
							return true;
						}
					}
					return false;
				}

			}
			int offset = c - 'a';

			if (childs[offset] == null) {
				return false;
			}
			if (index == word.length() - 1) {
				return childs[offset].visited;
			}
			return childs[offset].search(word, index + 1);

		}

		public void insert(String word, int index) {
			if (word == null || word.length() <= index) {
				return;
			}

			int offset = word.charAt(index) - 'a';
			if (childs[offset] == null) {
				childs[offset] = new TrieNode();
			}
			++childs[offset].freq;
			if (word.length() - 1 == index) {
				childs[offset].visited = true;
				return;
			}
			childs[offset].insert(word, index + 1);
		}
	}

	private TrieNode root;

	// Adds a word into the data structure.
	public Add_Search_Word() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		root.insert(word, 0);
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return root.search(word, 0);
	}

	public static void main(String[] args) {
		Add_Search_Word test = new Add_Search_Word();
		test.addWord("a");
		System.out.println(test.search(".a"));
	}

}
