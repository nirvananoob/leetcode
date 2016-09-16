package design;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Implement a standard bloom filter. Support the following method: 1.
 * StandardBloomFilter(k),The constructor and you need to create k hash
 * functions. 2. add(string). add a string into bloom filter. 3.
 * contains(string). Check a string whether exists in bloom filter.
 * 
 * Have you met this question in a real interview? Yes Example
 * StandardBloomFilter(3) add("lint") add("code") contains("lint") // return
 * true contains("world") // return false
 * 
 * @author kaizhang
 *
 */
public class Standard_Bloomfilter {
	class HashFunction {
		int capacity;
		int seed;

		public HashFunction(int cap, int seed) {
			this.capacity = cap;
			this.seed = seed;
		}

		public int hashcode(String word) {
			int res = 0;
			for (char c : word.toCharArray()) {
				res += res * seed + (int) c;
				res %= capacity;
			}
			return res;
		}
	}

	private BitSet bits;
	private List<HashFunction> hashs;

	public Standard_Bloomfilter(int k) {
		// initialize your data structure here
		this.hashs = new ArrayList<HashFunction>();
		for (int i = 0; i < k; i++) {
			hashs.add(new HashFunction(100000, 33 + i));
		}
		this.bits = new BitSet(100000);

	}

	public void add(String word) {
		// Write your code here
		for (HashFunction hash : hashs) {
			int pos = hash.hashcode(word);
			bits.set(pos);
		}
	}

	public boolean contains(String word) {
		// Write your code here
		for (HashFunction hash : hashs) {
			int pos = hash.hashcode(word);
			if (bits.get(pos) == false) {
				return false;
			}
		}
		return true;
	}
}
