package Search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Alien_Dictionary {
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return new String();
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashMap<Character, HashSet<Character>> graph = new HashMap<Character, HashSet<Character>>();
		String s, t;
		// construct grpah
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (!map.containsKey(c)) {
					map.put(c, 0);
					graph.put(c, new HashSet<Character>());
				}
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			s = words[i];
			t = words[i + 1];
			for (int j = 0; j < s.length() && j < t.length(); j++) {
				char sc = s.charAt(j), tc = t.charAt(j);
				if (sc != tc) {
					HashSet<Character> set = graph.get(sc);
					if (!set.contains(tc)) {
						map.put(tc, map.get(tc) + 1);
						set.add(tc);
					}
					break;
				}
			}
		}
		int size = 0;
		Queue<Character> queue = new LinkedList<Character>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			++size;
			if (entry.getValue() == 0) {
				queue.offer(entry.getKey());
			}
		}
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			char c = queue.poll();
			++count;
			sb.append(c);
			for (char next : graph.get(c)) {
				int degree = map.get(next);
				if (degree == 0) {
					return new String();
				}
				--degree;
				if (degree == 0) {
					queue.offer(next);
				}
				map.put(next, degree);

			}
		}
		return count == size ? sb.toString() : new String();

	}
// better solution : use array for optimize
	public static void main(String[] args) {
		String[] words = new String[] { "wrt", "wrf", "er", "ett", "rftt" };
		Alien_Dictionary test = new Alien_Dictionary();
		System.out.println(test.alienOrder(words));
	}
}
