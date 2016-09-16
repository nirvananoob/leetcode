package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,1,2,1,1].
 * 
 * Example 2: Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,4,6].
 * 
 * @author kaizhang
 *
 */
/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation
 * 
 * }
 */
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class Flattern_Nested_List_Iteraotr implements Iterator<Integer> {
	/**
	 * method 1 : create a list then merge all 
	 */
	private List<Integer> list;
	private int cur;

	public Flattern_Nested_List_Iteraotr(List<NestedInteger> nestedList) {
		list = new ArrayList<Integer>();
		dfs(list, nestedList);
		cur = 0;
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			return list.get(cur++);
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		return cur != list.size();
	}

	private void dfs(List<Integer> list, List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return;
		}
		for (NestedInteger next : nestedList) {
			if (next.isInteger()) {
				list.add(next.getInteger());
			} else {
				dfs(list, next.getList());
			}
		}
	}
}
