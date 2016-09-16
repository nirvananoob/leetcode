package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * Example Given two 1d vectors:
 * 
 * v1 = [1, 2] v2 = [3, 4, 5, 6] By calling next repeatedly until hasNext
 * returns false, the order of elements returned by next should be: [1, 3, 2, 4,
 * 5, 6].
 * 
 * @author kaizhang
 *
 */
public class Zigzag_Iterator_I {
	private List<Integer> l1;
	private List<Integer> l2;
	private int next1, next2;

	public Zigzag_Iterator_I(List<Integer> v1, List<Integer> v2) {
		// initialize your data structure here.
		if (v1 == null || v2 == null) {
			throw new IllegalArgumentException();
		}
		l1 = new ArrayList<Integer>(v1);
		l2 = new ArrayList<Integer>(v2);
		next1 = 0;
		next2 = 0;

	}

	public int next() {
		// Write your code here
		if (next1 < l1.size() && next1 <= next2
				|| (next1 > next2 && next2 == l2.size())) {
			return l1.get(next1++);
		}
		return l2.get(next2++);
	}

	public boolean hasNext() {
		// Write your code here
		return next1 < l1.size() || next2 < l2.size();
	}

	/**
	 * Your ZigzagIterator object will be instantiated and called as such:
	 * ZigzagIterator solution = new ZigzagIterator(v1, v2); while
	 * (solution.hasNext()) result.add(solution.next()); Output result
	 */
	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList<Integer>();
		v1.add(1);
		v1.add(3);
		List<Integer> v2 = new ArrayList<Integer>();
		v2.add(2);
		v2.add(4);
		v2.add(5);
		v2.add(6);
		Zigzag_Iterator_I test = new Zigzag_Iterator_I(v1, v2);
		while (test.hasNext()) {
			System.out.println(test.next());
		}
	}
}
