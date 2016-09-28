package design;

import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example, Given 2d vector =
 * 
 * [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext returns
 * false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * 
 * Hint:
 * 
 * How many variables do you need to keep track? Two variables is all you need.
 * Try with x and y. Beware of empty rows. It could be the first few rows. To
 * write correct code, think about the invariant to maintain. What is it? The
 * invariant is x and y must always point to a valid point in the 2d vector.
 * Should you maintain your invariant ahead of time or right when you need it?
 * Not sure? Think about how you would implement hasNext(). Which is more
 * complex? Common logic in two different places should be refactored into a
 * common method. Follow up: As an added challenge, try to code it using only
 * iterators in C++ or iterators in Java.
 * 
 * Hide Company Tags
 * 
 * @author kaizhang
 *
 */
public class Flatten_2D_Vector implements Iterator<Integer> {
	private Iterator<List<Integer>> master;
	private Iterator<Integer> list;

	public Flatten_2D_Vector(List<List<Integer>> vec2d) {
		master = vec2d.iterator();
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			return null;
		}
		return list.next();

	}

	@Override
	public boolean hasNext() {
		while ((list == null || !list.hasNext()) && master.hasNext()) {
			list = master.next().iterator();
		}
		return list != null && list.hasNext();
	}
}
