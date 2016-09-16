package Trie;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Notice
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * 
 * Example insert("lintcode") search("code") // return false startsWith("lint")
 * // return true startsWith("linterror") // return false insert("linterror")
 * search("lintcode) // return true startsWith("linterror") // return true
 * 
 * @author kaizhang
 *
 */
class TrieNode {
	private TrieNode[] childs;
	public boolean visited;
	public int freq;

	public TrieNode() {
		/**
		 * // consider there are only 26 lowercase letters , or we can implement
		 * a hash map
		 */
		this.childs = new TrieNode[26];
		this.visited = false;
		this.freq = 0;
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

	public boolean search(String word, int index) {
		if (word == null || word.length() <= index) {
			return false;
		}

		int offset = word.charAt(index) - 'a';

		if (childs[offset] == null) {
			return false;
		}
		if (index == word.length() - 1) {
			return childs[offset].visited;
		}
		return childs[offset].search(word, index + 1);

	}

	public boolean startsWith(String word, int index) {
		if (word == null || word.length() <= index) {
			return false;
		}

		int offset = word.charAt(index) - 'a';

		if (childs[offset] == null) {
			return false;
		}
		if (index == word.length() - 1) {
			return childs[offset].freq > 0 ? true : false;
		}
		return childs[offset].startsWith(word, index + 1);
	}
}
	public class Trie {
		private TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			this.root.insert(word, 0);
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			return root.search(word, 0);
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			return root.startsWith(prefix, 0);
		}
	}

