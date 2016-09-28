package Search.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the word list For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"] Return [ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"] ] Note: All words have the same length. All
 * words contain only lowercase alphabetic characters.
 * 
 * @author kaizhang
 *
 */
public class Word_Ladder_II {
	public List<List<String>> findLadders(String beginWord, String endWord,
			Set<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (beginWord == null || endWord == null) {
			return res;
		}
		wordList.add(beginWord);
		wordList.add(endWord);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int path = bfs(beginWord, endWord, wordList, map);
		System.out.println(path);
		if (path == Integer.MAX_VALUE) {
			return res;
		}
		ArrayList<String> lst = new ArrayList<String>();

		lst.add(beginWord);
		if (beginWord.equals(endWord)) {
			res.add(lst);
			return res;
		}
		dfs(res, lst, endWord, path, path, wordList, map);

		return res;
	}

	private int bfs(String beginWord, String endWord, Set<String> wordList,
			HashMap<String, Integer> map) {
		
		map.put(endWord, 1);
		int d1 = 1;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(endWord);
		while (!queue.isEmpty()) {
			++d1;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String temp = queue.poll();
				for (String next : findNext(temp, wordList)) {
					 if(map.containsKey(next)){
	                        continue;
	                    }
					map.put(next, d1);
					
					if (next.equals(beginWord)) {
						return d1;
					}
					queue.offer(next);
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private HashSet<String> findNext(String word, Set<String> wordList) {
		HashSet<String> set = new HashSet<String>();
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char pre = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == pre) {
					continue;
				}
				chars[i] = c;
				String temp = new String(chars);
				if (wordList.contains(temp)) {
					set.add(temp);
				}
			}
			chars[i] = pre;
		}
		return set;
	}

	private void dfs(List<List<String>> res, ArrayList<String> lst,
			String endWord, int cur, int size, Set<String> wordList,
			HashMap<String, Integer> map) {
		if (lst.size() == size) {
			if (lst.get(size - 1).equals(endWord)) {
				res.add(new ArrayList<String>(lst));
			}
			return;
		}
		for (String next : findNext(lst.get(lst.size() - 1), wordList)) {
			if (map.containsKey(next) && map.get(next) == cur - 1) {
				lst.add(next);
				dfs(res, lst, endWord, cur - 1, size, wordList, map);
				lst.remove(lst.size() - 1);
			}
		}
		return;
	}

	public static void main(String[] args) {
		String a = "hit";
		String b = "cog";
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dog");
		set.add("dot");
		set.add("log");
		set.add("lot");
		String a1 = "a";
		String a2 = "c";
		Set<String> set2 = new HashSet<String>();
		set2.add(a1);
		set2.add(a2);
		set2.add("b");
		Word_Ladder_II test = new Word_Ladder_II();
		// System.out.println(test.findNext(a, set));
		
		System.out.println(test.findLadders(a1, a2, set2));
	}
}
